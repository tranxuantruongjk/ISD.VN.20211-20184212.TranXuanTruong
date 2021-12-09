package controller;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * All test cases for validating the delivery information
 * @author TRUONG
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ValidateNameTest.class,ValidatePhoneNumberTest.class,ValidateAddressTest.class})
public class AllTests {

}
