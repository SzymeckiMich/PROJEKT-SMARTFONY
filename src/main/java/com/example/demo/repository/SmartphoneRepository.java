package com.example.demo.repository;

import com.example.demo.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {

    public List<Smartphone> findTop2ByOrderByBatteryCapacityDesc();

}
