package others;

import entities.AccountEntity;
import entities.EmployeeEntity;
import net.bytebuddy.utility.RandomString;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.HibernateUtils;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Runtime {

    private Session session;
    private Transaction transaction;

    @Before
    public void setUp() throws Exception {
        // 取得 session
        session = HibernateUtils.getSession();
        transaction = session.beginTransaction();
    }

    @Test
    public void runtime() {
        Query query = session.createQuery("from EmployeeEntity");
        List<EmployeeEntity> list = query.list();

        for(EmployeeEntity emp: list){
            if(emp.getAccount() == null){
                AccountEntity account = new AccountEntity(
                        UUID.randomUUID().toString(),
                        String.format("%10d", new Random().nextInt(1000000000)),
                        String.format(RandomString.make(10)),
                        emp);
                session.save(account);
            }else {
                System.out.println("已建立帳戶");
            }
        }
    }

    @After
    public void tearDown() throws Exception {
        // 提交事務並關閉session
        transaction.commit();
        session.close();
    }
}
