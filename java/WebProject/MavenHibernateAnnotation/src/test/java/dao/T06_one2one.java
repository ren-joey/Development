package dao;

import entities.CardEntity;
import entities.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import utils.HibernateUtils;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.UUID;


public class T06_one2one {

    @Test
    public void Hibernate_06_01 () {

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        GregorianCalendar calendar = new GregorianCalendar(2022, 12, 24);
        EmployeeEntity emp =  session.load(EmployeeEntity.class, "0605ec0f-b080-492d-8d21-844da5cb5c80");
        Date date = new Date(calendar.getTimeInMillis());

        System.out.println(emp.getName());

        CardEntity card = new CardEntity(UUID.randomUUID().toString(), "1234-1432-1423-1231", 123, date);
        card.setOwner(emp);

        session.save(card);

        transaction.commit();
        session.close();
    }

}
