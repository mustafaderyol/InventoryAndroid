package com.mustafaderyol.inventory.entity;


/**
 *
 * @author MstfDryl
 */
public class UnderCommonParameter {

    private Long id;

    private String name;

    private Category category;

    private CommonParameter commonparameter;

    private Boolean status;

    public UnderCommonParameter() {
    }

    public UnderCommonParameter(String name, Category category, CommonParameter commonparameter, Boolean status) {
        this.name = name;
        this.category = category;
        this.commonparameter = commonparameter;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public CommonParameter getCommonParameter() {
        return commonparameter;
    }

    public void setCommonParameter(CommonParameter commonparameter) {
        this.commonparameter = commonparameter;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
}
