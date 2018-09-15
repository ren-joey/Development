package dao;

import entities.HouseEntity;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.HibernateUtils;

import java.util.List;

/**
 * 本機 SQL 查詢
 * 此方法較少用到
 */
public class T12_SQL {

    private Session session;
    private Transaction transaction;

    @Before
    public void before(){
        session = HibernateUtils.getSession();
        transaction = session.beginTransaction();
    }

    /**
     * 以對象組封裝
     */
    @Test
    public void test_01(){
        SQLQuery sqlQuery = session.createSQLQuery("select * from house");

        List<Object[]> list = sqlQuery.list();
        for (Object[] objects: list){
            for(Object object: objects){
                System.out.print(object + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 以java bean對象封裝
     */
    @Test
    public void test_02(){
        SQLQuery sqlQuery = session.createSQLQuery("select * from house");
        sqlQuery.addEntity(HouseEntity.class);

        List<HouseEntity> list = sqlQuery.list();
        for(HouseEntity house: list){
            System.out.printf("%s %s\n", house.getName(), house.getAddress());
        }
    }

    @After
    public void after(){
        transaction.commit();
        session.close();
    }

}
