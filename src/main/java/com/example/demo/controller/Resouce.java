package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Medicine;
import com.example.demo.repository.MedicineRepository;
import com.example.demo.service.MedicineService;

@RestController
public class Resouce {
	 
	@Autowired
	private MedicineRepository medicineRepository;
	
	@Autowired
	private MedicineService medicineService;
	
	@GetMapping("/")
	public String getGreeting() {
		return "Hello World";
	}
	
	@GetMapping("/get/medicines")
	public Optional<List<Medicine>> getMedicines() {
		return Optional.ofNullable(medicineRepository.findAll());
	}
	
	@GetMapping("/get/medicineByid")
	public Optional<Optional<Medicine>> getMedicine(@RequestParam("id") Long id) {
		return Optional.ofNullable(medicineRepository.findById(id));
	}
	
	@PostMapping("/add/medicine")
	public void addMedicine(@RequestBody Medicine medicine) {
		medicineRepository.save(medicine);
	}
	
	@PostMapping("/addAll/medicine")
	public void bulkAddMedicine(@RequestBody List<Medicine> medicine) {
		medicineRepository.saveAll(medicine);
	}
	
	@PutMapping("/update/medicine")
	public void updateMedicine(@RequestBody Medicine medicine) {
		medicineRepository.save(medicine);
	}
	
	@DeleteMapping("/delete/medicine")
	public void deleteMedicine(@RequestParam("id") long id) {
		Medicine medicine = new Medicine();
		medicine.setId(id);
		medicineRepository.delete(medicine);
	}
	
	@GetMapping("/get/medicineByNameAndPrice")
	public Optional<Medicine> getmedicineByNameAndPrice(@RequestParam("name") String name,@RequestParam("price") Float price) {
		return medicineService.getmedicineByNameAndPrice(name, price);
	}
}
