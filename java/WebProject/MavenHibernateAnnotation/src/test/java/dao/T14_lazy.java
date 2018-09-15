package dao;

import entities.EmployeeEntity;
import entities.HouseEntity;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.HibernateUtils;

import java.util.Set;

public class T14_lazy {

    private Session session;

    @Before
    public void before(){
        // 取得 session
        session = HibernateUtils.getSession();
        session.beginTransaction();
    }

    @Test
    public void test_01() {
        /**
         * load方式检索不到的话会抛出org.hibernate.ObjectNotFoundException异常
         * get方法检索不到的话会返回null
         */

        EmployeeEntity emp = session.get(EmployeeEntity.class, "2181ffaf-76e7-4568-ba86-9e0ee25ff198");
        Set<HouseEntity> houses = emp.getHouses();

        System.out.printf("%s名下共有%d間房子\n", emp.getName(), houses.size());

        HouseEntity house = session.get(HouseEntity.class, "93197a32-1dbf-4682-bfb1-72829a41c874");
        EmployeeEntity owner = house.getOwner();

        if( owner != null ){
            System.out.printf("%s目前為%s所持有\n", house.getName(), owner.getName());
        }else {
            System.out.printf("%s目前暫無人持有\n", house.getName());
        }
    }

    @After
    public void after(){
        // 提交事務並關閉session
        session.getTransaction().commit();
        session.close();
    }

}
