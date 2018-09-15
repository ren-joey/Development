package dao;

import entities.CardEntity;
import entities.EmployeeEntity;
import entities.HouseEntity;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.HibernateUtils;

import javax.smartcardio.Card;
import java.util.List;
import java.util.Set;

public class T15_fetch {

    private Session session;

    @Before
    public void before(){
        // 取得 session
        session = HibernateUtils.getSession();
        session.beginTransaction();
    }

//    @Test
    public void test_01() {
        EmployeeEntity emp = session.get(EmployeeEntity.class, "2181ffaf-76e7-4568-ba86-9e0ee25ff198");
        emp.getHouses().size();
    }

    @Test
    public void test_02() {
        List<HouseEntity> list = session.createQuery("from HouseEntity h where h.id in (1,2,3,4,5)").list();

        HouseEntity house = list.get(0);
        System.out.printf( "%s的擁有人%s其名下有%d間房子", list.get(0).getName(), house.getOwner().getName(), house.getOwner().getHouses().size() );
    }

    @After
    public void after(){
        // 提交事務並關閉session
        session.getTransaction().commit();
        session.close();
    }

}
