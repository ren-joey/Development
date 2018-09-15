package others;

import entities.HouseEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.HibernateUtils;

import java.util.List;
import java.util.Objects;

/**
 * 測試 employee 跟 card 的 OneToOne 關係是否有正確連動
 * employee.uuid 放在 card.owner 內
 * 若設定成功，employee.setCard(card) 時，employee 中不應有 card uuid 的欄位
 */
public class Test_Hibernate {

    private Session session;
    private Transaction transaction;

    @Before
    public void setUp() throws Exception {
        // 取得 session
        session = HibernateUtils.getSession();
        transaction = session.beginTransaction();
    }

//    @Test
    public void test1() {
        System.out.println("-------- OneToOne test --------");

        Query query = session.createQuery("select emp.name, card.id from EmployeeEntity emp inner join emp.card card");
        List<Object[]> list = query.list();

        for (Object[] objects: list){
            for(Object object: objects){
                System.out.print( object + "\t");
            }
            System.out.println();
        }
    }

    @Test
    public void test2() {
        System.out.println("-------- HQL test --------");
        Query query = session.createQuery("from HouseEntity house where house.address like ?1 and house.id < 10 and house.id > 2 order by house.id asc");
        query.setParameter(1, "%台中市%");

        List<HouseEntity> list = query.list();
        System.out.println("總計共有" + list.size() + "個結果");
        for (HouseEntity house: list){
            System.out.printf("%d\t%s\t%s\n", house.getId(), house.getName(), house.getAddress());
        }
    }

    @After
    public void tearDown() throws Exception {
        // 提交事務並關閉session
        transaction.commit();
        session.close();
    }
}
