package com.mustafaderyol.inventory.entity;

import java.util.Date;

/**
 *
 * @author MstfDryl
 */
public class Services {

    private Long id;

    private Inventory inventory;

    private MovementHistory movementhistory;

    private Long goDate;

    private String goNote;

    private Long comeDate;

    private String comeNote;

    private Boolean status;

    public Services() {
    }

    public Services(Inventory inventory, MovementHistory movementhistory, Long goDate, String goNote, Long comeDate, String comeNote, Boolean status) {
        this.inventory = inventory;
        this.movementhistory = movementhistory;
        this.goDate = goDate;
        this.goNote = goNote;
        this.comeDate = comeDate;
        this.comeNote = comeNote;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    
    public MovementHistory getMovementhistory() {
        return movementhistory;
    }

    public void setMovementhistory(MovementHistory movementhistory) {
        this.movementhistory = movementhistory;
    }

    public Long getGoDate() {
        return goDate;
    }

    public void setGoDate(Long goDate) {
        this.goDate = goDate;
    }

    public String getGoNote() {
        return goNote;
    }

    public void setGoNote(String goNote) {
        this.goNote = goNote;
    }

    public Long getComeDate() {
        return comeDate;
    }

    public void setComeDate(Long comeDate) {
        this.comeDate = comeDate;
    }

    public String getComeNote() {
        return comeNote;
    }

    public void setComeNote(String comeNote) {
        this.comeNote = comeNote;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
}
