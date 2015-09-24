package intellimeet.hibernate;

import intellimeet.hibernate.entity.Employee;
import intellimeet.hibernate.enums.EmployeeStatus;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    private static final EntityManagerFactory entityManagerFactory;

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("mongoPU");
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    protected static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    protected static Session getSession() throws HibernateException {
        return getEntityManager().unwrap(Session.class);
    }

    public static void main(final String[] args) {
        try {
            System.out.println("====================Create Data====================");
            Employee employee = createEmployee();
            System.out.println(employee);

            System.out.println("====================Find Data====================");
            employee = findEmployee(employee.getId());
            System.out.println(employee);

            System.out.println("====================Update Data====================");
            employee = updateEmployeeData(employee.getId());
            System.out.println(employee);

            System.out.println("====================Remove Data====================");
            deleteEmployee(employee.getId());

            System.out.println("====================Find Data====================");
            employee = findEmployee(employee.getId());
            System.out.println(employee);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        entityManagerFactory.close();
    }

    private static Employee createEmployee() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        Employee employee = new Employee("Sandeep Poonia", "sandeep.poonia@tothenew.com", EmployeeStatus.PART_TIME);
        em.persist(employee);

        em.getTransaction().commit();
        em.close();

        return employee;
    }

    private static Employee findEmployee(Integer id) {
        EntityManager em = getEntityManager();

        Employee employee = em.find(Employee.class, id);

        em.close();

        return employee;
    }

    private static Employee updateEmployeeData(Integer id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        Employee employee = em.find(Employee.class, id);
        employee.setEmployeeStatus(EmployeeStatus.FULL_TIME);

        em.getTransaction().commit();
        em.close();

        return employee;
    }

    private static void deleteEmployee(Integer id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        Employee employee = em.find(Employee.class, id);
        em.remove(employee);

        em.getTransaction().commit();
        em.close();
    }
}