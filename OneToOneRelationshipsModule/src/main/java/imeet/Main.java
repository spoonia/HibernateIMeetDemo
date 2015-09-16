package imeet;

import imeet.entity.PassportEntity;
import imeet.entity.PersonEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main extends Application {

    public static void createData() {
        final Session session = getSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            PersonEntity personEntity = new PersonEntity("Sandeep Poonia");
            PassportEntity passportEntity = new PassportEntity(4582904378574l, personEntity);

//            session.save(personEntity);
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
