package ru.kuznetsov.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "rental", schema = "movie")
public class RentalEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "rental_id")
    private Integer rental;

    @Basic
    @Column(name = "rental_date")
    private LocalDateTime rentalDate;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private InventoryEntity inventory;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @Basic
    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private StaffEntity staff;

    @Basic
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    public Integer getRental() {
        return rental;
    }

    public void setRental(Integer rentalId) {
        this.rental = rentalId;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDateTime rentalDate) {
        this.rentalDate = rentalDate;
    }

    public InventoryEntity getInventory() {
        return inventory;
    }

    public void setInventory(InventoryEntity inventoryId) {
        this.inventory = inventoryId;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customerId) {
        this.customer = customerId;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public StaffEntity getStaff() {
        return staff;
    }

    public void setStaff(StaffEntity staffId) {
        this.staff = staffId;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "RentalEntity{" +
                "rentalId=" + rental +
                ", rentalDate=" + rentalDate +
                ", inventoryId=" + inventory +
                ", customerId=" + customer +
                ", returnDate=" + returnDate +
                ", staffId=" + staff +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
