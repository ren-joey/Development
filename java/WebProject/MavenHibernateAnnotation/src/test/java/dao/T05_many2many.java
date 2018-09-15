package dao;

import entities.EmployeeEntity;
import entities.HouseEntity;
import entities.LikeRelEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import utils.HibernateUtils;

import java.util.UUID;

public class T05_many2many {

    @Test
    public void Hibernate_05_01 (){

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        EmployeeEntity employeeEntity = new EmployeeEntity(UUID.randomUUID().toString(), 12, "peter", 1, "MIS");
        HouseEntity houseEntity = new HouseEntity(UUID.randomUUID().toString(), 12, "超強大樓", "台中市大里區國光路四段12號三樓");
        LikeRelEntity likeRelEntity = new LikeRelEntity();

        likeRelEntity.setId(3);
        likeRelEntity.setEmployeeByEnd1(employeeEntity);
        likeRelEntity.setHouseByEnd2(houseEntity);

        session.save(employeeEntity);
        session.save(houseEntity);
        session.save(likeRelEntity);

        transaction.commit();
        session.close();

    }

}
