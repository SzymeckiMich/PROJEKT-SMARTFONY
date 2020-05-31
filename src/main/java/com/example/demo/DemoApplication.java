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

        Producer producer = new Producer("SAMSUNG", "South Korea", LocalDate.now(), "https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Samsung_Logo.svg/1024px-Samsung_Logo.svg.png");
        producerRepository.save(producer);

        Producer producer1 = new Producer("Apple", "USA", LocalDate.now(), "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Apple_logo_black.svg/202px-Apple_logo_black.svg.png");
        producerRepository.save(producer1);



        Smartphone smartphone = new Smartphone(producer, "Galaxy S20", 6.3, 8, 256, 3, 12000000, 1, 20000000, 4300, "Exynos", "https://image.ceneostatic.pl/data/products/91074694/i-samsung-galaxy-s20-plus-5g-sm-g986-128gb-szary.jpg");
        smartphoneRepository.save(smartphone);
    }

}
