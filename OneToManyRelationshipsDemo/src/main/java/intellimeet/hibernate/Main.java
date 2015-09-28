package intellimeet.hibernate;

import intellimeet.hibernate.entity.Address;
import intellimeet.hibernate.entity.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.sql.JoinType;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main extends Application {

    private static List<String> names = Arrays.asList("Ankit", "Bishan", "Chanchal", "Dheeraj", "Ekansh", "Fareed", "Gautam", "Himanshu", "Ishika", "Jyoti");
    private static List<String> addresses = Arrays.asList("AK-72", "BM-23", "A-123", "B-234", "A-404", "B-345", "HZ-12", "B-123", "H-46", "HN-417");
    private static List<String> cities = Arrays.asList("Noida", "Shimla", "Panipat", "Bhopal", "Chandigarh", "Jalandhar", "Jaipur", "Delhi", "Goa", "Kerla");
    private static List<String> states = Arrays.asList("UP", "UK", "HR", "DL", "MP", "HP", "PN", "RJ", "Goa", "Kerla");
    private static List<Long> pinCodes = Arrays.asList(201301l, 101302l, 301303l, 401304l, 501305l, 601306l, 701307l, 801308l, 201309l, 201310l);

    public static void createData() {
        Session session = getSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            Employee employee = new Employee("Sandeep Poonia");
            employee.addAddress(new Address("Noida", "GTBNagar", "UP", 201301l, employee));
            employee.addAddress(new Address("Ashok Nagar", "Delhi", "Delhi", 110011l, employee));

            session.persist(employee);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        try {
            session = getSession();

            Criteria criteria = session.createCriteria(Employee.class);

            ProjectionList properties = Projections.projectionList();
            properties.add(Projections.property("id"), "id");
            properties.add(Projections.property("name"), "name");
            properties.add(Projections.property("addresses.id"), "id");
            properties.add(Projections.property("addresses.city"), "city");

            criteria.setProjection(properties);
            criteria.createAlias("addresses",  "addresses", JoinType.INNER_JOIN);

            criteria.setMaxResults(1);
            System.out.println(criteria.uniqueResult());

            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
//        createBulkData();
    }

    private static void createBulkData() {
        Employee employee;
        Address address;

        Session session = getSession();
        Transaction transaction = session.getTransaction();


        try {
            transaction.begin();

            ThreadLocalRandom random = ThreadLocalRandom.current();
            for (int i = 0; i < 50; i++) {
                employee = new Employee(names.get(random.nextInt(0, 10)));

                address = new Address(employee);
                address.setAddress(addresses.get(random.nextInt(0, 10)));
                address.setCity(cities.get(random.nextInt(0, 10)));
                address.setState(states.get(random.nextInt(0, 10)));
                address.setPinCode(pinCodes.get(random.nextInt(0, 10)));

                employee.addAddress(address);

                session.save(employee);
            }

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
