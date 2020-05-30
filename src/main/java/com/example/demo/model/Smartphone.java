package com.example.demo.model;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class Smartphone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String producerName;


    @ManyToOne
    private Producer producer;

    private String model;

//    private double screenSize;
//    private int ram;
//    private int storage;
//    private int rearCameras;
//    private int frontCameras;
//    private int batteryCapacity;
//    private String processor;


    public Smartphone() {
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

//    public double getScreenSize() {
//        return screenSize;
//    }
//
//    public void setScreenSize(double screenSize) {
//        this.screenSize = screenSize;
//    }
//
//    public int getRam() {
//        return ram;
//    }
//
//    public void setRam(int ram) {
//        this.ram = ram;
//    }
//
//    public int getStorage() {
//        return storage;
//    }
//
//    public void setStorage(int storage) {
//        this.storage = storage;
//    }
//
//    public int getRearCameras() {
//        return rearCameras;
//    }
//
//    public void setRearCameras(int rearCameras) {
//        this.rearCameras = rearCameras;
//    }
//
//    public int getFrontCameras() {
//        return frontCameras;
//    }
//
//    public void setFrontCameras(int frontCameras) {
//        this.frontCameras = frontCameras;
//    }
//
//    public int getBatteryCapacity() {
//        return batteryCapacity;
//    }
//
//    public void setBatteryCapacity(int batteryCapacity) {
//        this.batteryCapacity = batteryCapacity;
//    }
//
//    public String getProcessor() {
//        return processor;
//    }
//
//    public void setProcessor(String processor) {
//        this.processor = processor;
//    }
}
