package dao;

import com.joey.entities.EmployeeEntity;
import com.joey.entities.HouseEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import utils.HibernateUtils;

import java.util.UUID;

public class T04_one2many {

    /**
     * 保存操作
     */
    @Test
    public void One2many_01 (){
        // 準備數據
        // 需求 1 個角色 多間房子
        String uuid = UUID.randomUUID().toString();
        EmployeeEntity employeeEntity = new EmployeeEntity(uuid, 12, "陳小可", "waitress");

        String uuid_2 = UUID.randomUUID().toString();
        HouseEntity houseEntity_1 = new HouseEntity(uuid_2, 2, "夢幻套房", "台中市向上北路120巷7號6樓");
        HouseEntity houseEntity_2 = new HouseEntity(UUID.randomUUID().toString(), 3, "快樂雅房", "台中市建國北路30號2樓D室");

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        // 建立一對多雙向關係
        employeeEntity.getHouses().add(houseEntity_1);
        employeeEntity.getHouses().add(houseEntity_2);
        houseEntity_1.setEmployeeByOwner(employeeEntity);
        houseEntity_2.setEmployeeByOwner(employeeEntity);

        session.save(employeeEntity);
        session.save(houseEntity_1);
        session.save(houseEntity_2);

        transaction.commit();
        session.close();

    }

}
