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
    public static void main(String[] args) {
        System.out.println("Hibernate tutorial");

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        DAO.ProductsEntity book = new DAO.ProductsEntity();

        book.setAuthor("Bik");
        book.setName("Nick");


        session.persist(book);
        session.getTransaction().commit();

        session.close();

    }
}