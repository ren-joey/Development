package dao;

import com.joey.entities.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import utils.HibernateUtils;

public class T03_SessionTestUpdate {


    /**
     * update
     */
//    @Test
    public void Hibernate_03_1 (){

        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setUuid("46aef94e-929e-4518-86b7-d27f82bd2371");
        employeeEntity.setId(8);
        employeeEntity.setName("吳文傑");
        employeeEntity.setRole("teacher");

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(employeeEntity);
        transaction.commit();
        session.close();

    }

    /**
     * save or change
     */
//    @Test
    public void Hibernate_03_02 (){

        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setUuid("46aef94e-929e-4518-86b7-d27f82bd2371");
        employeeEntity.setId(8);
        employeeEntity.setName("吳文傑");
        employeeEntity.setRole("athlete");

        Session session = HibernateUtils.getSession();

        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(employeeEntity);
        transaction.commit();
        session.close();

    }

    /**
     * delete
     */
//    @Test
    public void Hibernate_03_03 (){

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setUuid("76ecc4dc-788a-4261-94f0-816441baa288");

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(employeeEntity);
        transaction.commit();
        session.close();

    }

    /**
     * get
     */
    @Test
    public void Hibernate_03_04 (){

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        // 添加 sql 操作
        EmployeeEntity employeeEntity = session.load(EmployeeEntity.class, "0605ec0f-b080-492d-8d21-844da5cb5c80");
        System.out.println(employeeEntity.getUuid());
        System.out.println(employeeEntity.getId());
        System.out.println(employeeEntity.getName());
        System.out.println(employeeEntity.getRole());

        transaction.commit();
        session.close();

    }

}
