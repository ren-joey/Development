package dao;

import entities.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.HibernateUtils;

/**
 * 展示二級緩存作用
 */
public class T17_ehcache {

    /**
     * 二級緩存
     */
    @Test
    public void test_01() {
        Session session = HibernateUtils.getSession();
        EmployeeEntity emp = session.get(EmployeeEntity.class, "21581462-a9a4-11e8-98d0-529269fb1459");
        System.out.println(emp.getName());

        session.close();

        session = HibernateUtils.getSession();
        emp = session.get(EmployeeEntity.class, "21581462-a9a4-11e8-98d0-529269fb1459");
        System.out.println(emp.getName());

        session.close();
    }


    /**
     * 查詢緩存
     */
    @Test
    public void test_02() {
        Session session = HibernateUtils.getSession();

        Query query = session.createQuery("select id, name from EmployeeEntity ");
        query.setCacheable(true);
        query.list();
        session.close();

        session = HibernateUtils.getSession();
        query = session.createQuery("select id, name from EmployeeEntity ");
        query.setCacheable(true);
        query.list();
        session.close();

    }
}
