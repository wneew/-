package com.his.entity;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PharmacyDTO {
    private final StringProperty value;

    public PharmacyDTO(String value) {
        this.value = new SimpleStringProperty(value);
    }

    public StringProperty valueProperty(){
        return value;
    }

    public String getValue(){
        return value.getValue();
    }
    public void setValue(String value){
        this.value.set(value);
    }
}
