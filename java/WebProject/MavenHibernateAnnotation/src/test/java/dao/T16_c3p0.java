package dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.junit.Test;
import utils.HibernateUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 連接池集合
 */
public class T16_c3p0 {

    @Test
    public void test() {

        Session session = HibernateUtils.getSession();

        session.doWork(
                new Work() {
                    @Override
                    public void execute(Connection connection) throws SQLException {
                        System.out.println(connection);
                    }
                }
        );

        session.close();
    }
}
