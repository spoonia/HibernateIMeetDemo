package imeet;

import imeet.entity.inheritence.singletable.*;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;

import java.util.Map;

public class Main {
    private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        createNewEmployee();

        createNewPayableEntities();

        queryAllTables();
    }

    private static void createNewEmployee() {
        final Session session = getSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            imeet.entity.EmployeeEntity entity = imeet.entity.EmployeeEntity.builder()
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

    private static void queryAllTables() {
        final Session session = getSession();

        try {
            System.out.println("querying all the managed entities...");
            final Map metadataMap = session.getSessionFactory().getAllClassMetadata();
            for (Object key : metadataMap.keySet()) {
                final ClassMetadata classMetadata = (ClassMetadata) metadataMap.get(key);
                final String entityName = classMetadata.getEntityName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
            ourSessionFactory.close();
        }
    }
}