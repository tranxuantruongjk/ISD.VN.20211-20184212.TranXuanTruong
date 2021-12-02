package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class PlaceRushOrderController {
	
	public void validateDeliveryRushOrderInfo(HashMap<String, String> rushInfo) throws InterruptedException, IOException{
		
	}
	
	public boolean validateExpectedTime(String expectedTime) throws ParseException {
		// Check null entry
		if (expectedTime == null) return false;
		// Check the deliveried day after the placed day
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date currentDate = new Date();
		String currentDateString = df.format(currentDate);

	    Date date1 = df.parse(currentDateString);
	    Date date2 = df.parse(expectedTime);
	    return date2.after(date1);
		
	}

}
