package com.example.demo;

import com.example.demo.model.Producer;
import com.example.demo.repository.ProducerRepository;
import com.example.demo.repository.SmartphoneRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        SmartphoneRepository smartphoneRepository = context.getBean(SmartphoneRepository.class);
        ProducerRepository producerRepository = context.getBean(ProducerRepository.class);

        Producer producer = new Producer("SAMSUNG", "South Korea", LocalDate.now());
        producerRepository.save(producer);

        Producer producer1 = new Producer("Apple", "USA", LocalDate.now());
        producerRepository.save(producer1);

    }

}
