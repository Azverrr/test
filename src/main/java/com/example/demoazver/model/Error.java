package com.example.demoazver.model;

import com.example.demoazver.entity.ErrorEntity;

public class Error {
    private Long id;
    private String errorID;
    private String textError;

    public  static  Error toModel (ErrorEntity entity) {
        Error model = new Error();
        model.setId(entity.getId());
        model.setErrorID(entity.getErrorID());
        model.setTextError(entity.getTextError());
        return  model;
    }

    public Error() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getErrorID() {
        return errorID;
    }

    public void setErrorID(String errorID) {
        this.errorID = errorID;
    }

    public String getTextError() {
        return textError;
    }

    public void setTextError(String textError) {
        this.textError = textError;
    }
}
