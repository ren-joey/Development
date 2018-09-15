package com.joey.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "card", schema = "hibernate", catalog = "")
public class CardEntity {
    private String uuid;
    private String id;
    private int securityCode;
    private Date deadline;
    private EmployeeEntity owner;

    public CardEntity() {
    }

    public CardEntity(String uuid, String id, int securityCode, Date deadline) {
        this.uuid = uuid;
        this.id = id;
        this.securityCode = securityCode;
        this.deadline = deadline;
    }

    @Id
    @Column(name = "uuid")
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Basic
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "security_code")
    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    @Basic
    @Column(name = "deadline")
    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "uuid")
    public EmployeeEntity getOwner() {
        return owner;
    }
    public void setOwner(EmployeeEntity owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardEntity that = (CardEntity) o;

        if (securityCode != that.securityCode) return false;
        if (uuid != null ? !uuid.equals(that.uuid) : that.uuid != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (deadline != null ? !deadline.equals(that.deadline) : that.deadline != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + securityCode;
        result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
        return result;
    }
}
