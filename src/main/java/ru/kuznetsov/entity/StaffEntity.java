package ru.kuznetsov.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import java.sql.Timestamp;
import java.util.Arrays;

@Entity
@Table(name = "staff", schema = "movie")
public class StaffEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "staff_id")
    private Byte staffId;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressEntity addressId;
    @Lob
    @Column(name = "picture", columnDefinition = "BLOB")
    private byte[] picture;
    @Basic
    @Column(name = "email")
    private String email;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private StoreEntity storeId;

    @Column(name = "active", columnDefinition = "BIT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean active;
    @Basic
    @Column(name = "username")
    private String userName;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "last_update")
    @UpdateTimestamp
    private Timestamp lastUpdate;

    public Byte getStaffId() {
        return staffId;
    }

    public void setStaffId(Byte staffId) {
        this.staffId = staffId;
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

    public AddressEntity getAddressId() {
        return addressId;
    }

    public void setAddressId(AddressEntity addressId) {
        this.addressId = addressId;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StoreEntity getStoreId() {
        return storeId;
    }

    public void setStoreId(StoreEntity storeId) {
        this.storeId = storeId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "StaffEntity{" +
                "staffId=" + staffId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addressId=" + addressId +
                ", picture=" + Arrays.toString(picture) +
                ", email='" + email + '\'' +
                ", storeId=" + storeId +
                ", active=" + active +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
