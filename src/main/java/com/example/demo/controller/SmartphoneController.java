package com.example.demo.controller;

import com.example.demo.model.Producer;
import com.example.demo.model.Smartphone;
import com.example.demo.service.ProducerService;
import com.example.demo.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class SmartphoneController {

    private SmartphoneService smartphoneService;
    private ProducerService producerService;

    @Autowired
    public SmartphoneController(SmartphoneService smartphoneService, ProducerService producerService) {
        this.smartphoneService = smartphoneService;
        this.producerService = producerService;
    }

    @GetMapping("/")
    public String addPhone(Model model) {
        model.addAttribute("smartphone", new Smartphone());
        return "addForm";
    }

    @PostMapping("/add")
    @ResponseBody
    public String add(Smartphone smartphone){

        Optional<Producer> producer = producerService.findByName(smartphone.getProducerName());
        if(producer.isPresent()){
            smartphone.setProducer(producer.get());
            smartphoneService.save(smartphone);
            return "Dodano chyba";
        }

        return "Siusiak";

    }


}
