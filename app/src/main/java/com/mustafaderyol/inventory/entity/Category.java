
package com.mustafaderyol.inventory.entity;


/**
 *
 * @author MstfDryl
 */
public class Category {
    private Long id;

    private String name;

    private Boolean status;

    public Category() {
    }

    public Category(String name, Boolean status) {
        this.name = name;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
}
