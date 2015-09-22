package intellimeet.hibernate;

import intellimeet.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main extends Application {

    public static void createData() {
        final Session session = getSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            Employee entity = Employee.builder()
                    .name("Sandeep Poonia")
                    .email("sandeep.poonia@tothenew.com")
                    .employeeStatus(EmployeeStatus.FULL_TIME)
                    .flag(false).build();

            session.save(entity);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}