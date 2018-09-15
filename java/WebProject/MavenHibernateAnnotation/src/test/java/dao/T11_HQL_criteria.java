package dao;

import entities.EmployeeEntity;
import entities.HouseEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.HibernateUtils;

import java.util.List;

public class T11_HQL_criteria {

    private Session session;
    private Transaction transaction;

    @Before
    public void before(){
        session = HibernateUtils.getSession();
        transaction = session.beginTransaction();
    }

    /**
     * 全表查詢
     */
    @Test
    public void test_01(){
        System.out.println("-------- Criteria 全表查詢 --------");

        Criteria criteria = session.createCriteria(EmployeeEntity.class);
        List<EmployeeEntity> list = criteria.list();

        for (EmployeeEntity emp: list){
            System.out.println(emp.getName());
        }
    }

    /**
     * 條件查詢
     */
    @Test
    public void test_02(){
        System.out.println("-------- Criteria 條件查詢 --------");

        Criteria criteria = session.createCriteria(HouseEntity.class);
        criteria.add(Restrictions.eq("id", 1));
        List<HouseEntity> list = criteria.list();

        for (HouseEntity emp: list){
            System.out.println(emp.getName());
        }
    }

    /**
     * 多重條件
     */
    @Test
    public void test_03(){
        System.out.println("-------- Criteria 多重條件 --------");

        Criteria criteria = session.createCriteria(HouseEntity.class);
        criteria.add( Restrictions.and( Restrictions.like("name", "%房%"), Restrictions.like("address", "%台中市%") , Restrictions.isNotNull("owner")) );
        List<HouseEntity> list = criteria.list();

        for (HouseEntity house: list){
            System.out.printf("%s %s\n", house.getName(), house.getAddress());
        }
    }

    /**
     * 序列查詢
     */
    @Test
    public void test_04(){
        System.out.println("-------- Criteria 序列查詢 --------");

        Criteria criteria = session.createCriteria(HouseEntity.class);
        // 起始位置
        criteria.setFirstResult(3);
        // 查詢行數
        criteria.setMaxResults(2);

        List<HouseEntity> list = criteria.list();
        for(HouseEntity house: list){
            System.out.printf("%s %s\n", house.getName(), house.getAddress());
        }

    }

    /**
     * 查詢排序功能
     */
    @Test
    public void test_05(){
        System.out.println("-------- Criteria 序列查詢 --------");

        Criteria criteria = session.createCriteria(HouseEntity.class);
        // 排序為 order by desc
        criteria.addOrder(org.hibernate.criterion.Order.desc("address"));

        List<HouseEntity> list = criteria.list();
        for (HouseEntity house: list){
            System.out.printf("%s %s\n", house.getName(), house.getAddress());
        }

    }

    /**
     * 集合查詢
     */
    @Test
    public void test_06(){
        System.out.println("-------- Criteria 集合查詢 --------");

        Criteria criteria = session.createCriteria(HouseEntity.class);
        // 查詢總紀錄數量
        // criteria.setProjection(Projections.count("id"));

        // 查詢 id 的最大值
        criteria.setProjection(Projections.max("id"));

        Long count = (Long)criteria.uniqueResult();
        System.out.println(count);
    }

    /**
     * 投影查詢
     */
    @Test
    public void test_07(){
        System.out.println("-------- Criteria 投影查詢 --------");

        Criteria criteria = session.createCriteria(HouseEntity.class);
        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Property.forName("name"));
        projectionList.add(Property.forName("address"));

        criteria.setProjection(projectionList);

        List<Object[]> list = criteria.list();
        for(Object[] objects: list){
            for (Object object: objects){
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
