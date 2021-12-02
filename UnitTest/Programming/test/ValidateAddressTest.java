package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidateAddressTest {
	private PlaceOrderController placeOrderController;

	@BeforeEach
	void setUp() throws Exception {
		placeOrderController = new PlaceOrderController();
	}
	
	@ParameterizedTest
	@CsvSource({
		" , false",
		"Dong $Da, false",
		"Dong Da, true",
		"so 15 Dong Da, true",
		"Dong Da - Ha Noi, true",
		"131/12 Dong Da - Hanoi, true",
	})
	
	void test(String address, boolean expected) {
		boolean isValid = placeOrderController.validateAddress(address);
		assertEquals(expected, isValid);
	}
	
	@Test
	void test() {
		boolean isVal = placeOrderController.validateAddress("131/12 Dong Da, Ha Noi");
		assertEquals(true, isVal);
	}
}
