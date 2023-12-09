package ru.kuznetsov.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "store", schema = "movie")
public class StoreEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "store_id")
    private Byte storeId;
    @OneToOne
    @JoinColumn(name = "manager_staff_id")
    private StaffEntity managerStaffId;
    @OneToOne
    @JoinColumn(name = "address_id")
    private AddressEntity addressId;
    @Basic
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    public Byte getStoreId() {
        return storeId;
    }

    public void setStoreId(Byte storeId) {
        this.storeId = storeId;
    }

    public StaffEntity getManagerStaffId() {
        return managerStaffId;
    }

    public void setManagerStaffId(StaffEntity managerStaffId) {
        this.managerStaffId = managerStaffId;
    }

    public AddressEntity getAddressId() {
        return addressId;
    }

    public void setAddressId(AddressEntity addressId) {
        this.addressId = addressId;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


}
