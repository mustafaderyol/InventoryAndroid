package com.mustafaderyol.inventory.entity;


/**
 *
 * @author MstfDryl
 */
public class Unit {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private Unit parentunit;

    private Boolean status;

    public Unit() {
    }

    public Unit(String name, Unit parentunit, Boolean status) {
        this.name = name;
        this.parentunit = parentunit;
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

    public Unit getParentunit() {
        return parentunit;
    }

    public void setParentunit(Unit parentunit) {
        this.parentunit = parentunit;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
}
