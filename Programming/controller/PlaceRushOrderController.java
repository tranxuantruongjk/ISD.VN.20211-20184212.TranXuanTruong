package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * This class controls the flow of place rush order usecase in our AIMS project
 * @author TRUONG
 *
 */

public class PlaceRushOrderController {
		
	/**
	 * @param rushInfo - the delivery rush order information
	 * @throws InterruptedException - InterruptedException is thrown when a thread is interrupted
	 * @throws IOException - Exception is produced by failed or interrupted I/O operations
	 */
	public void validateDeliveryRushOrderInfo(HashMap<String, String> rushInfo) throws InterruptedException, IOException{
		
	}

	/**
	 * @param expectedTime - the date that the user expected to delivery rush order
	 * @return true if expectedTime is correct format, false if not
	 * @throws ParseException - Exception has been reached unexpectedly while parsing
	 */
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
