package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee", schema = "hibernate", catalog = "")
public class EmployeeEntity {
    private String uuid;
    private int id;
    private String name;
    private int gender;
    private String role;
    private CardEntity card;
    private AccountEntity account;
    private Set<HouseEntity> houses = new HashSet<>();
    private Set<LikeRelEntity> likeRels = new HashSet<>();

    public EmployeeEntity() {
    }

    public EmployeeEntity(String uuid, int id, String name, int gender, String role) {
        this.uuid = uuid;
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.role = role;
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
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "gender", nullable = false, length = 1)
    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "role", nullable = false, length = 255)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @OneToMany
    @JoinColumn(name = "owner")
    public Set<HouseEntity> getHouses() {
        return houses;
    }
    public void setHouses(Set<HouseEntity> houses) {
        this.houses = houses;
    }

    @OneToMany
    @JoinColumn(name = "end1")
    public Set<LikeRelEntity> getLikeRels() {
        return likeRels;
    }
    public void setLikeRels(Set<LikeRelEntity> likeRels) {
        this.likeRels = likeRels;
    }

    @OneToOne(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    public CardEntity getCard() {
        return card;
    }
    public void setCard(CardEntity card) {
        if( card == null ){
            if( this.card != null ){
                this.card.setOwner(null);
            }
        }else {
            card.setOwner(this);
        }
        this.card = card;
    }

    @OneToOne(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    public AccountEntity getAccount() {
        return account;
    }
    public void setAccount(AccountEntity account) {
        if( account == null ){
            if(this.account != null){
                this.account.setProfile(null);
            }
        }else {
            account.setProfile(this);
        }
        this.account = account;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity that = (EmployeeEntity) o;

        if (id != that.id) return false;
        if (uuid != null ? !uuid.equals(that.uuid) : that.uuid != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
