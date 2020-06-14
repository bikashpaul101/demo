package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineService {
	
	@Autowired
	private MedicineRepository medicineRepository;
	
	public Optional<Medicine> getmedicineByNameAndPrice(String name,Float price) {
		Medicine medicine = medicineRepository.findByMedicineName(name);
		if(price.equals(medicine.getPrice())) {
			return Optional.of(medicine);
		}
		else 
			return Optional.empty();
	}
}
