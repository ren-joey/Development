package entities;

import javax.persistence.*;

@Entity
@Table(name = "like_rel", schema = "hibernate", catalog = "")
public class LikeRelEntity {
    private int id;
    private EmployeeEntity employeeByEnd1;
    private HouseEntity houseByEnd2;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LikeRelEntity that = (LikeRelEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "end1", referencedColumnName = "uuid", nullable = false)
    public EmployeeEntity getEmployeeByEnd1() {
        return employeeByEnd1;
    }

    public void setEmployeeByEnd1(EmployeeEntity employeeByEnd1) {
        this.employeeByEnd1 = employeeByEnd1;
    }

    @ManyToOne
    @JoinColumn(name = "end2", referencedColumnName = "uuid", nullable = false)
    public HouseEntity getHouseByEnd2() {
        return houseByEnd2;
    }

    public void setHouseByEnd2(HouseEntity houseByEnd2) {
        this.houseByEnd2 = houseByEnd2;
    }
}
