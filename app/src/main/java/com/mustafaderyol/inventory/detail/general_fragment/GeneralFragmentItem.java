package com.mustafaderyol.inventory.detail.general_fragment;

/**
 * Created by MstfDryl on 11.12.2015.
 */
public class GeneralFragmentItem {
    private String parameter;
    private String value;

    public GeneralFragmentItem(String parameter, String value) {
        this.parameter = parameter;
        this.value = value;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
