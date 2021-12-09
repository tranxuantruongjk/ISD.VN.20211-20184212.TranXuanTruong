package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import entity.cart.Cart;
import entity.cart.CartMedia;
import common.exception.InvalidDeliveryInfoException;
import entity.invoice.Invoice;
import entity.order.Order;
import entity.order.OrderMedia;
import views.screen.popup.PopupScreen;

/**
 * This class controls the flow of place order usecase in our AIMS project
 * @author nguyenlm
 */
public class PlaceOrderController extends BaseController{

    /**
     * Just for logging purpose
     */
    private static Logger LOGGER = utils.Utils.getLogger(PlaceOrderController.class.getName());

    /**
     * This method checks the avalibility of product when user click PlaceOrder button
     * @throws SQLException - Exception relates to SQL
     */
    public void placeOrder() throws SQLException{
        Cart.getCart().checkAvailabilityOfProduct();
    }

    /**
     * This method creates the new Order based on the Cart
     * @return Order
     * @throws SQLException - Exception relates to SQL
     */
    public Order createOrder() throws SQLException{
        Order order = new Order();
        for (Object object : Cart.getCart().getListMedia()) {
            CartMedia cartMedia = (CartMedia) object;
            OrderMedia orderMedia = new OrderMedia(cartMedia.getMedia(), 
                                                   cartMedia.getQuantity(), 
                                                   cartMedia.getPrice());    
            order.getlstOrderMedia().add(orderMedia);
        }
        return order;
    }

    /**
     * This method creates the new Invoice based on order
     * @param order - the order that the user placed
     * @return Invoice
     */
    public Invoice createInvoice(Order order) {
        return new Invoice(order);
    }

    /**
     * This method takes responsibility for processing the shipping info from user
     * @param info - the delivery information
     * @throws InterruptedException - InterruptedException is thrown when a thread is interrupted
     * @throws IOException - Exception is produced by failed or interrupted I/O operations
     */
    public void processDeliveryInfo(HashMap info) throws InterruptedException, IOException{
        LOGGER.info("Process Delivery Info");
        LOGGER.info(info.toString());
        validateDeliveryInfo(info);
    }
    
    /**
   * The method validates the info
   * @param info - the delivery information
   * @throws InterruptedException - An InterruptedException is thrown when a thread is interrupted
   * @throws IOException - Exception is produced by failed or interrupted I/O operations
   */
    public void validateDeliveryInfo(HashMap<String, String> info) throws InterruptedException, IOException{
    	
    }
    
    /**
     * The method validates the phone number
     * The phone number must be 10-digit number, start with 0 
     * @param phoneNumber - the phone number of user
     * @return true if the phone number is correct format, false if not
     */
    public boolean validatePhoneNumber(String phoneNumber) {
    	// TODO: your work
    	// Check null entry
    	if (phoneNumber == null) return false;
    	// Check that length of phone number equals to 10 
    	if (phoneNumber.length() != 10) return false;
    	// Check that phone number starts with 0...
    	if (!phoneNumber.startsWith("0")) return false;
    	// Check that phone number only numbers(0-9)
    	try {
    		Integer.parseInt(phoneNumber);
    	}catch (NumberFormatException e) {
    		return false;
    	}
    	return true;
    }
    
    /**
     * The method validates name 
     * Name must be include letters(a-z,A-Z) and space
     * @param name - name of user
     * @return true if name is correct format, false if not
     */
    public boolean validateName(String name) {
    	// TODO: your work
    	// Check null entry
    	if (name == null) return false;
    	// Check address that includes letters(a-z, A-Z) and space
    	if (!name.matches("^[a-zA-Z][a-zA-Z\\s]{0,}$")) return false;

//    	for (int i = 0; i < name.length(); i++ ) {
//    		char ch = name.charAt(i);
//    		if (ch == ' ') continue;
//    		if (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')))
//    			return false;
//    	}
//    	
    	return true;
    }
    
    /**
     * The method validates the address
     * The address include letters(a-z,A-Z), numbers(0-9), space, -/,
     * @param address - the address of user
     * @return true if the address is correct format, false if not
     */
    public boolean validateAddress(String address) {
    	// TODO: your work
    	// Check null entry
    	if (address == null) return false;
    	// Check address that includes letters(a-z, A-Z), numbers(0-9), -,/ and space
    	if (!address.matches("^[a-zA-Z0-9][a-zA-Z0-9-,/\\s]{1,100}$")) return false;
    	
    	return true;	
    }
    

    /**
     * This method calculates the shipping fees of order
     * @param order - the order that the user placed
     * @return shippingFee - the shipping fees
     */
    public int calculateShippingFee(Order order){
        Random rand = new Random();
        int fees = (int)( ( (rand.nextFloat()*10)/100 ) * order.getAmount() );
        LOGGER.info("Order Amount: " + order.getAmount() + " -- Shipping Fees: " + fees);
        return fees;
    }
}
