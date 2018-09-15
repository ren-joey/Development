package dao;

import com.joey.entities.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.UUID;

public class T01_SessionTest {

    @Test
    public void Hibernate_01 (){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        UUID uuid = UUID.randomUUID();

        employeeEntity.setUuid(uuid.toString());
        employeeEntity.setId(8);
        employeeEntity.setName("莊承融");
        employeeEntity.setRole("Waiter");

        // 讀取 Hibernate.cfg.xml 文件設定
        Configuration configuration = new Configuration();
        configuration.configure();

        // 創建 Session Factory 工人
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // 創建 Session 對象
        Session session = sessionFactory.openSession();

        // 開啟事務
        Transaction transaction = session.beginTransaction();

        // 進行操作行為添加
        session.save(employeeEntity);

        // 提交事務
        transaction.commit();

        // 關閉資源
        session.close();

    }

}
