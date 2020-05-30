package com.example.demo.repository;

import com.example.demo.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {
}
