package com.example.demo;

import com.example.demo.model.Producer;
import com.example.demo.model.Smartphone;
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

        Producer producer = new Producer("Oppo", "Chiny", LocalDate.now(), "https://upload.wikimedia.org/wikipedia/commons/a/a2/OPPO_LOGO_2019.png");
        producerRepository.save(producer);

        Smartphone smartphone = new Smartphone(producer, "A5", 6.4, 4, 64, 3, 64, 1, 20, 3500, "SnapDragon100", "https://d2pa5gi5n2e1an.cloudfront.net/ph/images/special_article/PH_OPPO_A5_2020/13.jpg");
        smartphoneRepository.save(smartphone);
    }

}
