package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String country;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime dateOfCreation;


    @OneToMany(mappedBy = "producer", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Smartphone> smartphones;

    public Producer(){}

    public Producer(String name, String county, LocalDateTime dateOfCreation){
        this.name = name;
        this.country = county;
        this.dateOfCreation = dateOfCreation;
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

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public List<Smartphone> getSmartphones() {
        return smartphones;
    }

    public void setSmartphones(List<Smartphone> smartphones) {
        this.smartphones = smartphones;
    }
}
