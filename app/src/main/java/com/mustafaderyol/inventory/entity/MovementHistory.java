package com.mustafaderyol.inventory.entity;

import java.util.Date;

/**
 *
 * @author MstfDryl
 */
public class MovementHistory {
    private Long id;

    private Personal personal;

    private Unit unit;

    private Location location;

    private String locationdetail;

    private Long createdDate;

    private Boolean status;

    public MovementHistory() {
    }

    public MovementHistory(Personal personal, Unit unit, Location location, String locationdetail, Long createdDate, Boolean status) {
        this.personal = personal;
        this.unit = unit;
        this.location = location;
        this.locationdetail = locationdetail;
        this.createdDate = createdDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getLocationdetail() {
        return locationdetail;
    }

    public void setLocationdetail(String locationdetail) {
        this.locationdetail = locationdetail;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
}
