package dao;

import entities.CardEntity;
import entities.EmployeeEntity;
import entities.HouseEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.HibernateUtils;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

public class T18_JPA {
    private Session session;
    private Transaction transaction;

    @Before
    public void setUp() throws Exception {
        // 取得 session
        session = HibernateUtils.getSession();
        transaction = session.beginTransaction();
    }

    @Test
    public void test_01() {
        GregorianCalendar calendar = new GregorianCalendar(2080, 10, 26);
        Date date = new Date(calendar.getTimeInMillis());

        EmployeeEntity emp = new EmployeeEntity(UUID.randomUUID().toString(), 14, "邱郁文", 2, "warrior");
        HouseEntity house = new HouseEntity(UUID.randomUUID().toString(), 6, "中華大夏", "高雄市鼓山區五福四路1號");
        CardEntity card = new CardEntity(UUID.randomUUID().toString(), "1423-1231-1656-9887", 131, date);
        emp.setCard(card);
        emp.getHouses().add(house);
        session.save(emp);
        session.save(card);
        session.save(house);
    }

    @After
    public void tearDown() throws Exception {
        // 提交事務並關閉session
        transaction.commit();
        session.close();
    }
}
