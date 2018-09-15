package dao;

import entities.EmployeeEntity;
import entities.HouseEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.transform.ToListResultTransformer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.HibernateUtils;

import javax.persistence.OneToMany;
import java.util.*;

public class T09_HQL_single {

    private Session session;
    private Transaction transaction;

    @Before
    public void before (){
        session = HibernateUtils.getSession();
        transaction = session.beginTransaction();
    }

    /**
     * HQL 全域查詢
     */
//    @Test
    public void test_01 (){
        System.out.println("-------- HQL 全域查詢 --------");

        Query query = session.createQuery("from EmployeeEntity");
        List<EmployeeEntity> list = query.list();

        for (EmployeeEntity emp: list){
            System.out.println(emp.getName());
        }
    }

    /**
     * 別名查詢
     */
//    @Test
    public void test_02(){
        System.out.println("-------- HQL 別名查詢 --------");

        Query query = session.createQuery("select o from EmployeeEntity o");
        List<EmployeeEntity> list = query.list();

        for (EmployeeEntity emp: list){
            System.out.println(emp.getName());
        }
    }

    /**
     * 條件查詢
     */
//    @Test
    public void test_03(){
        System.out.println("-------- HQL 條件查詢 --------");

        Query query = session.createQuery("from HouseEntity where owner = '298c93c2-bb60-486e-8ad3-171d579cd373'");
        List<HouseEntity> list = query.list();

        for (HouseEntity house: list){
            System.out.println(house.getName());
        }
    }

    /**
     * 條件查詢 2
     */
//    @Test
    public void test_04(){
        System.out.println("-------- HQL 條件查詢2 --------");
        System.out.println("所有擁有信用卡的user");

        Query query = session.createQuery("from EmployeeEntity where uuid = ?1");
        query.setParameter(1, "298c93c2-bb60-486e-8ad3-171d579cd373");
        List<EmployeeEntity> list = query.list();
        for (EmployeeEntity emp: list){
            System.out.println(emp.getName());
        }
    }

    /**
     * 具名查詢
     */
//    @Test
    public void test_05(){
        System.out.println("-------- HQL 條件查詢2 --------");

        Query query = session.createQuery("from EmployeeEntity where name = :name");
        query.setParameter("name", "吳文傑");
        List<EmployeeEntity> list = query.list();
        for (EmployeeEntity emp: list){
            System.out.printf("%s %s %s", emp.getUuid(), emp.getName(), emp.getRole());
        }
    }

    /**
     * 次序查詢
     */
//    @Test
    public void test_06(){
        System.out.println("-------- HQL 次序查詢2 --------");

        Query query = session.createQuery("from HouseEntity order by id asc ");
        query.setFirstResult(2);
        query.setMaxResults(10);

        List<HouseEntity> list = query.list();
        for (HouseEntity house: list){
            System.out.printf("%d %s %s\n", house.getId(), house.getName(), house.getAddress());
        }

    }

    /**
     * 聚合查詢
     */
//    @Test
    public void test_07(){
        System.out.println("-------- HQL 聚合查詢 --------");

        Query query = session.createQuery("select count(*) from HouseEntity ");

//        List<Long> list = query.list();
//        Long count = list.get(0);

        Long count = (Long)query.uniqueResult();
        System.out.println(count);

    }

    /**
     * 投影查詢(查訊部分欄位)
     */
//    @Test
    public void test_08(){
        Query query = session.createQuery("select id,name from EmployeeEntity ");
        List<Object[]> list = query.list();
        for (Object[] objects : list) {
            for (Object object : objects) {
                System.out.print(object+"\t");
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
