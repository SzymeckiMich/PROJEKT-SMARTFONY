package com.example.demo.model;

public class PhoneWrapper {
    private String prodName;
    private Smartphone smartphone;

    public PhoneWrapper() {
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public Smartphone getSmartphone() {
        return smartphone;
    }

    public void setSmartphone(Smartphone smartphone) {
        this.smartphone = smartphone;
    }
}
