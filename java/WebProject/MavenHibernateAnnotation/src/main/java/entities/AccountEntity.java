package entities;

import javax.persistence.*;

@Entity
@Table(name = "account", schema = "hibernate", catalog = "")
public class AccountEntity {
    private String uuid;
    private String username;
    private String password;
    private EmployeeEntity profile;

    public AccountEntity() {
    }

    public AccountEntity(String uuid, String username, String password) {
        this.uuid = uuid;
        this.username = username;
        this.password = password;
    }

    public AccountEntity(String uuid, String username, String password, EmployeeEntity profile) {
        this.uuid = uuid;
        this.username = username;
        this.password = password;
        this.profile = profile;
    }

    @Id
    @Column(name = "uuid", nullable = false, length = 50)
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile", referencedColumnName = "uuid")
    public EmployeeEntity getProfile() {
        return profile;
    }

    public void setProfile(EmployeeEntity profile) {
        this.profile = profile;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountEntity that = (AccountEntity) o;

        if (uuid != null ? !uuid.equals(that.uuid) : that.uuid != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
