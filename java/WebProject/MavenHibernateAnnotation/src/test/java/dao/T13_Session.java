package dao;

import entities.HouseEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.HibernateUtils;

import java.util.List;

public class T13_Session {

    private Session session;

    @Before
    public void before(){
        // 取得 session
        session = HibernateUtils.getSession();
        session.beginTransaction();
    }

    /**
     * 緩存查詢測試
     */
//    @Test
    public void test_01(){
        // 查询 house 对象，如果查询到，会将 house 对象存储到一级缓存中
        HouseEntity houseEntity = session.get(HouseEntity.class, "632b38cc-70bc-4727-90f4-2ba4dfd987c0");

        // // 会从一级缓存中查询，而不会向数据库再发送sql语句查询
        HouseEntity houseEntity1 = session.get(HouseEntity.class, "f6d6c7f3-4ed8-46f9-af2e-df18ebe0bbe8");
    }

    /**
     * 自動更新數據庫
     */
//    @Test
    public void test_02(){
        HouseEntity houseEntity = session.get(HouseEntity.class, "f6d6c7f3-4ed8-46f9-af2e-df18ebe0bbe8");
        houseEntity.setName("猛鬼大夏");
    }

    /**
     * 測試 session 操作常用api
     */
//    @Test
    public void test_03() {

        List<HouseEntity> list = session.createQuery("from HouseEntity ").list();

        // 清空 session
        session.clear();

        // 從 session 中獲取，如果不存在，才會從數據庫裡面獲取
        HouseEntity house = session.get(HouseEntity.class, "f6d6c7f3-4ed8-46f9-af2e-df18ebe0bbe8");

        // 從 session 中刪除一個指定對象
        session.evict(house);
        HouseEntity house1 = session.get(HouseEntity.class, "37a7ab2f-f6aa-4e65-9885-bf11a6964e35");

        house1.setAddress("高雄市七賢二路130號");
        session.refresh(house1);
        // refresh方法的作用是：它会用数据库里面的数据来同步我们的一级缓存以及快照区，
        // 这样的话，再操作cc时，就不会发送update语句。
        // refresh方法：重新查询数据库，用数据库中的信息来更新一级缓存与快照区
    }


    @After
    public void after(){
        // 提交事務並關閉session
        session.getTransaction().commit();
        session.close();
    }

}
