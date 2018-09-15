package dao;

import com.joey.entities.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import utils.HibernateUtils;

import java.util.UUID;

public class T02_SessionTestUtils {

    @Test
    public void Hibernate_02 () {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        UUID uuid = UUID.randomUUID();

        employeeEntity.setUuid(uuid.toString());
        employeeEntity.setId(11);
        employeeEntity.setName("瑪麗");
        employeeEntity.setRole("PM");

        // 從 Utils 工具取得 Session 對象
        Session session = HibernateUtils.getSession();

        // 啟動事務
        Transaction transaction = session.beginTransaction();
        session.save(employeeEntity);
        transaction.commit();
        session.close();

    }

}
