package com.mustafaderyol.inventory.entity;

import java.util.List;

/**
 *
 * @author MstfDryl
 */
public class Inventory {

    private Long id;

    private Category category;

    private List<InventoryDetailParameter> inventoryDetailParameter;
    

    private List<InventoryDetailCommonParameter> inventoryDetailCommonParameter;

    private List<MovementHistory> movementHistory;

    private String note;
    

    public Inventory() {
    }

    public Inventory(Category category, List<InventoryDetailParameter> inventoryDetailParameter, List<InventoryDetailCommonParameter> inventoryDetailCommonParameter, List<MovementHistory> movementHistory, String note) {
        this.category = category;
        this.inventoryDetailParameter = inventoryDetailParameter;
        this.inventoryDetailCommonParameter = inventoryDetailCommonParameter;
        this.movementHistory = movementHistory;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<InventoryDetailParameter> getInventoryDetailParameter() {
        return inventoryDetailParameter;
    }

    public void setInventoryDetailParameter(List<InventoryDetailParameter> inventoryDetailParameter) {
        this.inventoryDetailParameter = inventoryDetailParameter;
    }

    public List<InventoryDetailCommonParameter> getInventoryDetailCommonParameter() {
        return inventoryDetailCommonParameter;
    }

    public void setInventoryDetailCommonParameter(List<InventoryDetailCommonParameter> inventoryDetailCommonParameter) {
        this.inventoryDetailCommonParameter = inventoryDetailCommonParameter;
    }

    public List<MovementHistory> getMovementHistory() {
        return movementHistory;
    }

    public void setMovementHistory(List<MovementHistory> movementHistory) {
        this.movementHistory = movementHistory;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
