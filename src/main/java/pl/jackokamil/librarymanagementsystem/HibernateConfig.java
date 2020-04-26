package pl.jackokamil.librarymanagementsystem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateConfig {
    private static SessionFactory sessionFactory;
    private Session session;

    public HibernateConfig() {
        this.sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(BookItem.class)
                .buildSessionFactory();
        this.session = sessionFactory.getCurrentSession();
    }

    public Session getSession() {
        return session;
    }
}
