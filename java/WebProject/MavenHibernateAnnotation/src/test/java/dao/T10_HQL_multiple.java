package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.HibernateUtils;

import org.hibernate.query.Query;

import java.util.List;

public class T10_HQL_multiple {

    private Session session;
    private Transaction transaction;

    @Before
    public void before(){
        session = HibernateUtils.getSession();
        transaction = session.beginTransaction();
    }

    /**
     * 內連接查詢
     * 只會顯示滿足條件的數據
     */
    @Test
    public void test_01(){
        System.out.println("-------- 內連接查詢 --------");

        Query query = session.createQuery("select emp.name, house.name, house.address from HouseEntity house inner join house.owner emp");
        List<Object[]> list = query.list();

        for (Object[] objects: list){
            for (Object object: objects){
                System.out.print(object + "\t");
            }
            System.out.println();
        }

    }

    /**
     * 左連結查詢
     * 左側的數據會全部獲得
     */
    @Test
    public void test_02(){
        System.out.println("-------- 左連接查詢 --------");

        Query query = session.createQuery("select emp.name, house.name, house.address from HouseEntity house left join house.owner emp");
        List<Object[]> list = query.list();

        for (Object[] objects: list){
            for(Object object: objects){
                System.out.print(object + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 右連結查詢
     * 右側的數據會全部獲得
     */
    @Test
    public void test_03(){
        System.out.println("-------- 右連接查詢 --------");

        Query query = session.createQuery("select emp.name, house.name, house.address from HouseEntity house right join house.owner emp");
        List<Object[]> list = query.list();

        for (Object[] objects: list){
            for(Object object: objects){
                System.out.print(object + "\t");
            }
            System.out.println();
        }
    }

    @After
    public void after(){
        transaction.commit();
        session.close();
    }

}
