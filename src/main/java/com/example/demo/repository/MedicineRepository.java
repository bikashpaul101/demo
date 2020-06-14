package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long>{

	Medicine findByMedicineName(String name);
}
