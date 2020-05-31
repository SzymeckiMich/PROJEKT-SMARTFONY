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
import org.springframework.web.bind.annotation.RequestParam;

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
    public String home(Model model) {
        List<Smartphone> phones = smartphoneService.find4Random();
        model.addAttribute("list", phones);
        return "home";
    }

    @GetMapping("/addPhone")
    public String addPhone(Model model) {
        List<Producer> producers = producerService.findAll();
        model.addAttribute("smartphone", new Smartphone());
        model.addAttribute("producers", producers);
        model.addAttribute("mode", "add");
        return "addPhoneForm";
    }

    @PostMapping("/addPhone")
    public String add(Smartphone smartphone, @RequestParam String producerName) {

        Optional<Producer> producer = producerService.findByName(producerName);
        if (producer.isPresent()) {
            smartphone.setProducer(producer.get());
            smartphoneService.save(smartphone);
        }
        return "redirect:/";
    }

    @GetMapping("/editPhone")
    public String editPhone(Model model, @RequestParam Long id) {
        List<Producer> producers = producerService.findAll();
        Smartphone smartphone = smartphoneService.findById(id).get();
        model.addAttribute("smartphone", smartphone);
        model.addAttribute("mode", "edit");
        model.addAttribute("producers", producers);

        return "addPhoneForm";
    }

    @PostMapping("/editPhone")
    public String editPhone(Smartphone smartphone, @RequestParam String producerName) {
        smartphone.setProducer(producerService.findByName(producerName).get());
        smartphoneService.update(smartphone);
        return "redirect:/";
    }

    @GetMapping("/addProducer")
    public String addProducer(Model model) {
        model.addAttribute("producer", new Producer());
        return "addProducerForm";
    }

    @PostMapping("/addProducer")
    public String addProducer(Producer producer) {
        producerService.save(producer);
        return "redirect:/";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("list", smartphoneService.find3Newest());
        return "list";
    }

    @GetMapping("showAll")
    public String showAll(Model model) {
        model.addAttribute("list", smartphoneService.findAll());
        return "list";
    }

    @GetMapping("/phone")
    public String details(@RequestParam Long id, Model model) {
        Optional<Smartphone> smartphone = smartphoneService.findById(id);
        if (smartphone.isPresent()) {
            model.addAttribute("phone", smartphone.get());
            return "phonePage"; // -> /resources/templates/animal.html
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id) {
        smartphoneService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/producers")
    public String producers(Model model) {
        model.addAttribute("list", producerService.findAll());
        return "producers";
    }

    @GetMapping("/findByProducer")
    public String findByProducer(@RequestParam Long id, Model model) {
        model.addAttribute("list", smartphoneService.findByProducer(id));
        return "list";
    }
}
