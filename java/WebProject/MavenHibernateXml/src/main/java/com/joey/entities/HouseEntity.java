package com.joey.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "house", schema = "hibernate", catalog = "")
public class HouseEntity {
    private String uuid;
    private int id;
    private String name;
    private String address;
    private EmployeeEntity employeeByOwner;
    private Set<LikeRelEntity> likeRels = new HashSet<>();

    public HouseEntity() {
    }

    public HouseEntity(String uuid, int id, String name, String address) {
        this.uuid = uuid;
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public HouseEntity(String uuid, int id, String name, String address, EmployeeEntity employeeByOwner) {
        this.uuid = uuid;
        this.id = id;
        this.name = name;
        this.address = address;
        this.employeeByOwner = employeeByOwner;
        this.likeRels = likeRels;
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
    @Column(name = "address", length = 255, nullable = true)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HouseEntity that = (HouseEntity) o;

        if (id != that.id) return false;
        if (uuid != null ? !uuid.equals(that.uuid) : that.uuid != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "uuid")
    public EmployeeEntity getEmployeeByOwner() {
        return employeeByOwner;
    }

    public void setEmployeeByOwner(EmployeeEntity employeeByOwner) {
        this.employeeByOwner = employeeByOwner;
    }

    @OneToMany
    public Set<LikeRelEntity> getLikeRels() {
        return likeRels;
    }
    public void setLikeRels(Set<LikeRelEntity> likeRels) {
        this.likeRels = likeRels;
    }
}
