package com.mustafaderyol.inventory.entity;


/**
 *
 * @author MstfDryl
 */

public class InventoryRelationship {

    private Long id;

    private Inventory inventory1;

    private Inventory inventory2;

    public InventoryRelationship() {
    }

    public InventoryRelationship(Inventory inventory1, Inventory inventory2) {
        this.inventory1 = inventory1;
        this.inventory2 = inventory2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Inventory getInventory1() {
        return inventory1;
    }

    public void setInventory1(Inventory inventory1) {
        this.inventory1 = inventory1;
    }

    public Inventory getInventory2() {
        return inventory2;
    }

    public void setInventory2(Inventory inventory2) {
        this.inventory2 = inventory2;
    }
    
}
