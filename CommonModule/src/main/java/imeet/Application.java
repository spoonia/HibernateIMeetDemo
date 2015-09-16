package imeet;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class Application {

    private static final String DEFAULT_CFG_RESOURCE_NAME = "module.cfg.xml";

    private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration()
                    .configure()
                    .configure(DEFAULT_CFG_RESOURCE_NAME);

            serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    protected static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        Class<?> aClass = null;
        try {
            aClass = Class.forName("imeet.Main");
        } catch (ClassNotFoundException ex) {
            System.err.println("Could not load class: " + ex.getLocalizedMessage());
        }
        if (aClass != null) {
            try {
                aClass.getMethod("createData").invoke(aClass);
            } catch (NoSuchMethodException | InvocationTargetException ex) {
                System.err.println("Could not invoke method: " + ex.getLocalizedMessage());
            }
        }
        queryAllTables();
    }

    protected static void queryAllTables() {
        final Session session = getSession();

        try {
            System.out.println("--============================================================================--");
            System.out.println("Querying all the managed entities...");
            final Map metadataMap = session.getSessionFactory().getAllClassMetadata();
            for (Object key : metadataMap.keySet()) {
                final ClassMetadata classMetadata = (ClassMetadata) metadataMap.get(key);
                final String entityName = classMetadata.getEntityName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("\n++++++++++++++++++++++++++++++++++++++  executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("\n---------------->" + o);
                }
            }
            System.out.println("--============================================================================--");
        } finally {
            session.close();
            ourSessionFactory.close();
        }
    }
}