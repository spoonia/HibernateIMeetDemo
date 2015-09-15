package imeet;

import imeet.entity.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main extends Application {

    public static void main(final String[] args) throws Exception {
        createNewEmployee();

        queryAllTables();
    }

    private static void createNewEmployee() {
        final Session session = getSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            EmployeeEntity entity = EmployeeEntity.builder()
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