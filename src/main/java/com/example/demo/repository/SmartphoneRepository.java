package com.example.demo.repository;

import com.example.demo.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {

    public List<Smartphone> findTop2ByOrderByBatteryCapacityDesc();

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM smartphone WHERE id = :id", nativeQuery = true)
    void deleteUsingNativeQuery(@Param("id") Long contains);

    @Transactional
    public void removeById(Long id);

}
