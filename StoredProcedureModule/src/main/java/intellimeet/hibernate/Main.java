package intellimeet.hibernate;

import intellimeet.hibernate.entity.Employee;
import intellimeet.hibernate.entity.Passport;
import intellimeet.hibernate.proc.EmployeeDetails;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import java.math.BigInteger;

public class Main extends Application {

    public static void createData() {
        final Session session = getSession();
        Transaction transaction = session.getTransaction();

        Integer id = null;
        try {
            transaction.begin();

            Employee employeeEntity = new Employee("Sandeep Poonia");
            Passport passportEntity = new Passport(4582904378574l, employeeEntity);

            session.save(employeeEntity);
            session.save(passportEntity);

            transaction.commit();

            id = employeeEntity.getId();

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        createEmployeeDetailsProcedure();
        fetchEmployeeDetails(id);
    }

    private static void createEmployeeDetailsProcedure() {
        final Session session = getSession();

        String db = "HibernateIMeetDB";
        String sp_name = "employeeDetails";


        try {
            session.beginTransaction();

//            session.doWork(new Work() {
//                @Override
//                public void execute(Connection connection) throws SQLException {
//                    System.out.println("================================================");
//                    System.out.println(connection.getMetaData().getURL().split("/")[3].split("\\?")[0]);
//                }
//            });

            String procedure = "SELECT EXISTS (SELECT 1 FROM mysql.proc WHERE db = '" + db + "' AND name = '" + sp_name + "') CT;";
            BigInteger count = (BigInteger) session.createSQLQuery(procedure).uniqueResult();

            if (count.intValue() == 0) {
                procedure = "CREATE PROCEDURE `" + sp_name + "`(employeeId int)" +
                        "BEGIN" +
                        "   SELECT emp.id, emp.name, passport.passportNumber " +
                        "   FROM Employee emp, Passport passport " +
                        "   WHERE emp.id = passport.person_id AND emp.id = employeeId;" +
                        "END;";
                session.createSQLQuery(procedure).executeUpdate();
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private static void fetchEmployeeDetails(Integer id) {
        System.out.println("--------------------------------------------------->");
        final Session session = getSession();
        try {

            Query query = session.createSQLQuery("CALL employeeDetails(:employeeId)").setParameter("employeeId", id);
            query.setResultTransformer(Transformers.aliasToBean(EmployeeDetails.class));

            EmployeeDetails details = (EmployeeDetails) query.uniqueResult();
            System.out.println(details);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println("<----------------------------------------------------");
        getSession().getSessionFactory().close();
        System.exit(1);
    }
}
