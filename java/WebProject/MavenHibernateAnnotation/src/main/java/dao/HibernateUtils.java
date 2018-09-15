package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static Configuration configuration = null;
    private static SessionFactory sessionFactory = null;

    // 只需要執行一次
    static {
        configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    // 提供獲取管道
    public static Session getSession() {
        Session session = null;
        session = sessionFactory.openSession();

        return session;
    }
}
