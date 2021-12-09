package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlaceRushOrderControllerTest {
	private PlaceRushOrderController placeRushOrderController;

	@BeforeEach
	void setUp() throws Exception {
		placeRushOrderController = new PlaceRushOrderController();
	}
	
	@ParameterizedTest
	@CsvSource({
		", false",
		"01/12/2021, false",
		"17/12/2021, true"
	})
	
	void testValidateExpectedTime(String expectedTime, boolean expected) throws ParseException {
		boolean isValid = placeRushOrderController.validateExpectedTime(expectedTime);
		assertEquals(expected, isValid);
	}

}
