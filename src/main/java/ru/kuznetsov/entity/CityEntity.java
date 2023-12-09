package ru.kuznetsov.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "city", schema = "movie")
public class CityEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "city_id")
    private Short cityId;
    @Basic
    @Column(name = "city")
    private String city;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryEntity countryId;
    @Basic
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    public Short getCityId() {
        return cityId;
    }

    public void setCityId(Short cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public CountryEntity getCountryId() {
        return countryId;
    }

    public void setCountryId(CountryEntity countryId) {
        this.countryId = countryId;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "CityEntity{" +
                "cityId=" + cityId +
                ", city='" + city + '\'' + "\n" +
                ", countryId=" + countryId +"\n" +
                ", lastUpdate=" + lastUpdate +"\n" +
                '}';
    }
}
