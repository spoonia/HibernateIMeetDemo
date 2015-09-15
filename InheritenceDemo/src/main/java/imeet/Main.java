package imeet;

import imeet.inheritence.entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main extends Application {

    public static void main(final String[] args) throws Exception {
        createNewPayableEntities();

        queryAllTables();
    }

    private static void createNewPayableEntities() {
        final Session session = getSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            PayableEntity payableEntity = new PayableEntity();
            payableEntity.setAmount(1000.00);

            InvoiceEntity invoiceEntity = new InvoiceEntity();
            invoiceEntity.setAmount(1000.00);
            invoiceEntity.setQuantity(4);
            invoiceEntity.setPricePerItem(150.00);

            EmployeeEntity employeeEntity = new EmployeeEntity();
            employeeEntity.setAmount(1000.00);
            employeeEntity.setFirstName("Sandeep");
            employeeEntity.setLastName("Poonia");

            SalariedEmployeeEntity salariedEmployeeEntity = new SalariedEmployeeEntity();
            salariedEmployeeEntity.setAmount(1000.00);
            salariedEmployeeEntity.setFirstName("Rahul");
            salariedEmployeeEntity.setLastName("Singhal");
            salariedEmployeeEntity.setSalary(5000.00);

            HourlyEmployeeEntity hourlyEmployeeEntity = new HourlyEmployeeEntity();
            hourlyEmployeeEntity.setAmount(1000.00);
            hourlyEmployeeEntity.setFirstName("Mahesh");
            hourlyEmployeeEntity.setLastName("Babu");
            hourlyEmployeeEntity.setWage(50000.00);
            hourlyEmployeeEntity.setHours(6.5);

            session.persist(payableEntity);
            session.persist(invoiceEntity);
            session.persist(employeeEntity);
            session.persist(salariedEmployeeEntity);
            session.persist(hourlyEmployeeEntity);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
