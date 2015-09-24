package intellimeet.hibernate;

import intellimeet.hibernate.entity.Address;
import intellimeet.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main extends Application {

    public static void createData() {
        Session session = getSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();
            Address addressEntity = null;

            Employee employeeEntity = new Employee("Sandeep Poonia");

            addressEntity = new Address("Noida", "GTBNagar", "UP", 201301l, employeeEntity);
            session.save(addressEntity);

            addressEntity = new Address("Ashok Nagar", "Delhi", "Delhi", 110011l, employeeEntity);
            session.save(addressEntity);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
