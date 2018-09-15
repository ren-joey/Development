package dao;

import entities.EmployeeEntity;
import entities.HouseEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import utils.HibernateUtils;

import java.util.Set;

public class T08_load_get {
    private Session session;
    private Transaction transaction;

    @Before
    public void before(){
        session = HibernateUtils.getSession();
        transaction = session.beginTransaction();
    }

    /**
     * get 方法查詢
     */
    @Test
    public void test1(){


        EmployeeEntity employeeEntity = session.get(EmployeeEntity.class, "2181ffaf-76e7-4568-ba86-9e0ee25ff198");
        Set<HouseEntity> houseEntitySet = employeeEntity.getHouses();

        System.out.println(employeeEntity.getName() + "名下的房子有：");
        for(HouseEntity house: houseEntitySet){
            System.out.printf("編號%s 名稱：%s 地址：%s\n", house.getUuid(), house.getName(), house.getAddress());
        }

    }

    /**
     * load 方法查詢
     */
    @Test
    public void test2(){
        transaction.commit();
        session.close();
    }

}
