package com.example.demo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MockTestCases {

	@Mock
	MedicineService medicineService;
	
	@Test
	public void testIfNull() {
		Optional<Medicine> medicine =  Optional.of(new Medicine());
		medicine.get().setId(1l);
		medicine.get().setName("Test");
		medicine.get().setPower("Test");
		medicine.get().setPrice(100f);
		when(medicineService.getmedicineByNameAndPrice("Test",100f)).thenReturn(medicine);
		assertEquals(medicine,medicineService.getmedicineByNameAndPrice("Test",100f));
	}

}
