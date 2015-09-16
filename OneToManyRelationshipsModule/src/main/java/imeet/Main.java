package imeet;

import imeet.entity.AddressEntity;
import imeet.entity.PersonEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main extends Application {

    public static void createData() {
        Session session = getSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();
            AddressEntity addressEntity = null;

            PersonEntity personEntity = new PersonEntity("Sandeep Poonia");

            addressEntity = new AddressEntity("Noida", "GTBNagar", "UP", 201301l, personEntity);
            session.save(addressEntity);

            addressEntity = new AddressEntity("Ashok Nagar", "Delhi", "Delhi", 110011l, personEntity);
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
