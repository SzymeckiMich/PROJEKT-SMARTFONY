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

import java.util.List;
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
        public String home(Model model){
        List<Smartphone> phone = smartphoneService.find3Newest();
        Smartphone smartphone = phone.get(0);
        model.addAttribute("phone", smartphone);
            return "home";
        }


    @GetMapping("/addPhone")
    public String addPhone(Model model) {
        List<Producer> producers = producerService.findAll();
        model.addAttribute("smartphone", new Smartphone());
        model.addAttribute("producers", producers);
        return "addPhoneForm";
    }

    @PostMapping("/addPhone")
    @ResponseBody
    public String add(Smartphone smartphone) {

        Optional<Producer> producer = producerService.findByName(smartphone.getProducerName());
        if (producer.isPresent()) {
            smartphone.setProducer(producer.get());
            smartphoneService.save(smartphone);
            return "Dodano chyba";
        }

        return "Siusiak";
    }

    @GetMapping("/addProducer")
    public String addProducer(Model model) {
        model.addAttribute("producer", new Producer());
        return "addProducerForm";
    }

    @PostMapping("/addProducer")
    @ResponseBody
    public String addProducer(Producer producer) {
        producerService.save(producer);
        return "dodano";
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("list", smartphoneService.find3Newest());
        return "list";
    }


}
