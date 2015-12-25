package com.mustafaderyol.inventory.entity;


/**
 *
 * @author MstfDryl
 */
public class Parameter {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Category category;

    private Parameter parentparameter;

    private String name;

    private Boolean selectortext;

    private Boolean status;

    public Parameter() {
    }

    public Parameter(Category category, Parameter parentparameter, String name, Boolean selectortext, Boolean status) {
        this.category = category;
        this.parentparameter = parentparameter;
        this.name = name;
        this.selectortext = selectortext;
        this.status = status;
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

    public Parameter getParentparameter() {
        return parentparameter;
    }

    public void setParentparameter(Parameter parentparameter) {
        this.parentparameter = parentparameter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSelectortext() {
        return selectortext;
    }

    public void setSelectortext(Boolean selectortext) {
        this.selectortext = selectortext;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
