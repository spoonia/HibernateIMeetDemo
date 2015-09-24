package intellimeet.hibernate;

import intellimeet.hibernate.enums.EmployeeStatus;
import intellimeet.hibernate.inheritence.entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main extends Application {

    public static void createData() {
        final Session session = getSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            Payable payableEntity = new Payable();
            payableEntity.setAmount(1000.00);

            Invoice invoiceEntity = new Invoice();
            invoiceEntity.setAmount(1000.00);
            invoiceEntity.setQuantity(4);
            invoiceEntity.setPricePerItem(150.00);

            Employee employeeEntity = new Employee();
            employeeEntity.setAmount(1000.00);
            employeeEntity.setFirstName("Sandeep");
            employeeEntity.setLastName("Poonia");
            employeeEntity.setEmployeeStatus(EmployeeStatus.FULL_TIME);

            SalariedEmployee salariedEmployeeEntity = new SalariedEmployee();
            salariedEmployeeEntity.setAmount(1000.00);
            salariedEmployeeEntity.setFirstName("Rahul");
            salariedEmployeeEntity.setLastName("Singhal");
            salariedEmployeeEntity.setEmployeeStatus(EmployeeStatus.FULL_TIME);
            salariedEmployeeEntity.setSalary(5000.00);

            HourlyEmployee hourlyEmployeeEntity = new HourlyEmployee();
            hourlyEmployeeEntity.setAmount(1000.00);
            hourlyEmployeeEntity.setFirstName("Mahesh");
            hourlyEmployeeEntity.setLastName("Babu");
            hourlyEmployeeEntity.setEmployeeStatus(EmployeeStatus.FULL_TIME);
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
