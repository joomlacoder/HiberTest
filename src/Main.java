import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Map;

/**
 * Created by Andrej on 26.11.2016.
 */
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
        final Session session = getSession();
        try {
            System.out.println("querying all the managed entities...");
            session.beginTransaction();
            Hiber.ProductsEntity book = new Hiber.ProductsEntity();
            //book.setId(20);
            book.setName("Кникакакаято");
            //book.setYear(2016);
            book.setAuthor("wert");
            //book.setPrice(1234);
            //book.setPublishingHouse("asdfgh");
            //book.setQuantityInStock(9999);
            session.save(book);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}