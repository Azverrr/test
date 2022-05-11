package com.example.demoazver.entity;

import javax.persistence.*;

@Entity
public class ErrorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(255)")
    private String errorID;
    @Column(unique = true, nullable = false, columnDefinition = "TEXT")
    private String textError;
    @Column(nullable = false, columnDefinition = "varchar(255) default 'error'")
    private String typeError;

    public ErrorEntity() {
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

    public String getTypeError() {
        return typeError;
    }

    public void setTypeError(String typeError) {
        this.typeError = typeError;
    }
}
