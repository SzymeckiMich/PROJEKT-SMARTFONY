package com.example.demo.model;

import javax.persistence.*;


@Entity
public class Smartphone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String producerName;


    @ManyToOne
    private Producer producer;

    private String model;

    private double screenSize;
    private int ram;
    private int storage;
    private int rearCameras;
    private long mainRearCameraResolution;
    private int frontCameras;
    private long mainFrontCameraResolution;
    private int batteryCapacity;
    private String processor;
    private String imageUrl;


    public Smartphone() {
    }

    public Smartphone(String producerName, Producer producer, String model, double screenSize, int ram, int storage, int rearCameras, long mainRearCameraResolution, int frontCameras, long mainFrontCameraResolution, int batteryCapacity, String processor, String imageUrl) {
        this.producerName = producerName;
        this.producer = producer;
        this.model = model;
        this.screenSize = screenSize;
        this.ram = ram;
        this.storage = storage;
        this.rearCameras = rearCameras;
        this.mainRearCameraResolution = mainRearCameraResolution;
        this.frontCameras = frontCameras;
        this.mainFrontCameraResolution = mainFrontCameraResolution;
        this.batteryCapacity = batteryCapacity;
        this.processor = processor;
        this.imageUrl = imageUrl;
    }

    public long getMainRearCameraResolution() {
        return mainRearCameraResolution;
    }

    public void setMainRearCameraResolution(long mainRearCameraResolution) {
        this.mainRearCameraResolution = mainRearCameraResolution;
    }

    public long getMainFrontCameraResolution() {
        return mainFrontCameraResolution;
    }

    public void setMainFrontCameraResolution(long mainFrontCameraResolution) {
        this.mainFrontCameraResolution = mainFrontCameraResolution;
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

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getRearCameras() {
        return rearCameras;
    }

    public void setRearCameras(int rearCameras) {
        this.rearCameras = rearCameras;
    }

    public int getFrontCameras() {
        return frontCameras;
    }

    public void setFrontCameras(int frontCameras) {
        this.frontCameras = frontCameras;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
