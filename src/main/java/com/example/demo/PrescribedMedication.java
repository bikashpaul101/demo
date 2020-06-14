package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prescribedmedication")
public class PrescribedMedication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "prescribedmedicationid")
	private Integer id;

	@OneToOne
	private Medicine medicine;

	@Column(name = "dosage")
	private String dosage;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
}
