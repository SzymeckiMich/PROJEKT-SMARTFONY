package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String country;
    private String logoUrl;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfCreation;


    @OneToMany(mappedBy = "producer", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Smartphone> smartphones;

    public Producer(){}

    public Producer(String name, String county, LocalDate dateOfCreation, String url){
        this.name = name;
        this.country = county;
        this.dateOfCreation = dateOfCreation;
        this.logoUrl = url;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public List<Smartphone> getSmartphones() {
        return smartphones;
    }

    public void setSmartphones(List<Smartphone> smartphones) {
        this.smartphones = smartphones;
    }
}
