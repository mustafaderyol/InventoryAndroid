package com.mustafaderyol.inventory.entity;


/**
 *
 * @author MstfDryl
 */
public class InventoryDetailCommonParameter {

    private Long id;

    private CommonParameter commonparameter;

    private UnderCommonParameter undercommonparameter;

    private String text;

    public InventoryDetailCommonParameter() {
    }

    public InventoryDetailCommonParameter(CommonParameter commonparameter, UnderCommonParameter undercommonparameter, String text) {
        this.commonparameter = commonparameter;
        this.undercommonparameter = undercommonparameter;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CommonParameter getCommonparameter() {
        return commonparameter;
    }

    public void setCommonparameter(CommonParameter commonparameter) {
        this.commonparameter = commonparameter;
    }

    public UnderCommonParameter getUndercommonparameter() {
        return undercommonparameter;
    }

    public void setUndercommonparameter(UnderCommonParameter undercommonparameter) {
        this.undercommonparameter = undercommonparameter;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
