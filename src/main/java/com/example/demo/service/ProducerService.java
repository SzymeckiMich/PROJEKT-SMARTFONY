package com.example.demo.service;

import com.example.demo.model.Producer;
import com.example.demo.model.Smartphone;
import com.example.demo.repository.ProducerRepository;
import com.example.demo.repository.SmartphoneRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProducerService {

    private ProducerRepository producerRepository;

    public ProducerService(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    public void save(Producer producer) {
        producerRepository.save(producer);
    }


    public Optional<Producer> findByName(String name) {
        return producerRepository.findByName(name);
    }
}
