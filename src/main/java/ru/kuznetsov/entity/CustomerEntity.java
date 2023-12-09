package ru.kuznetsov.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "customer", schema = "movie")
public class CustomerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "customer_id")
    private Short customerId;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private StoreEntity storeId;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "email")
    private String email;
    @OneToOne
    @JoinColumn(name = "address_id")
    private AddressEntity addressId;
    @Basic
    @Column(name = "active", columnDefinition = "BIT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean isActive;
    @Basic
    @Column(name = "create_date")
    @CreationTimestamp
    private Timestamp createDate;
    @Basic
    @Column(name = "last_update")
    @UpdateTimestamp
    private Timestamp lastUpdate;

    public Short getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Short customerId) {
        this.customerId = customerId;
    }

    public StoreEntity getStoreId() {
        return storeId;
    }

    public void setStoreId(StoreEntity storeId) {
        this.storeId = storeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressEntity getAddressId() {
        return addressId;
    }

    public void setAddressId(AddressEntity addressId) {
        this.addressId = addressId;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "customerId=" + customerId +
                ", storeId=" + storeId + "\n"+
                ", firstName='" + firstName + '\'' +"\n"+
                ", lastName='" + lastName + '\'' +"\n"+
                ", email='" + email + '\'' +"\n"+
                ", addressId=" + addressId +"\n"+
                ", isActive=" + isActive +"\n"+
                ", createDate=" + createDate +"\n"+
                ", lastUpdate=" + lastUpdate +"\n"+
                '}';
    }
}
