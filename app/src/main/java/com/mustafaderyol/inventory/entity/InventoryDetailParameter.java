package com.mustafaderyol.inventory.entity;


/**
 *
 * @author MstfDryl
 */
public class InventoryDetailParameter {

    private Long id;

    private Parameter parameter;

    private Parameter answerparameter;

    private String text;
    
    public InventoryDetailParameter() {
    }

    public InventoryDetailParameter(Parameter parameter, Parameter answerparameter, String text) {
        this.parameter = parameter;
        this.answerparameter = answerparameter;
        this.text = text;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public Parameter getAnswerparameter() {
        return answerparameter;
    }

    public void setAnswerparameter(Parameter answerparameter) {
        this.answerparameter = answerparameter;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
