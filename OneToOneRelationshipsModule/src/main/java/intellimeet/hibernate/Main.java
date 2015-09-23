package intellimeet.hibernate;

import intellimeet.hibernate.entity.Employee;
import intellimeet.hibernate.entity.Passport;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main extends Application {

    public static void createData() {
        final Session session = getSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            Employee employeeEntity = new Employee("Sandeep Poonia");
            Passport passportEntity = new Passport(4582904378574l, employeeEntity);

//            session.save(employeeEntity);
            session.save(passportEntity);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
