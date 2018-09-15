package dao;

import entities.AccountEntity;
import entities.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class MemberServices {

    private String username;
    private String password;
    private Boolean success;
    private EmployeeEntity employee;
    private AccountEntity account;

    public MemberServices(HttpServletRequest request) {
        this.username = request.getParameter("username");
        this.password = request.getParameter("password");

        Session session = HibernateUtils.getSession();

        Query query = session.createQuery("from AccountEntity account where username = ?1 and password = ?2");
        query.setParameter(1, username);
        query.setParameter(2, password);
        List<AccountEntity> list = query.list();

        try{
            if(list.size() > 0){
                account = list.get(0);
                employee = account.getProfile();
                success = true;
            }else {
                success = false;
            }
        }catch (Exception e){
            success = false;
        }
    }

    public Boolean getSuccess() {
        return success;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public AccountEntity getAccount() {
        return account;
    }
}
