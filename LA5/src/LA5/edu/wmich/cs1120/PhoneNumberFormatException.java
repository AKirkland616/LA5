package LA5.edu.wmich.cs1120;

public class PhoneNumberFormatException extends Exception{
	/**
	 * 
	 * @param message prints out the error message if the phone number formatter finds an error
	 */
	public PhoneNumberFormatException(String message) {
		super(message);
	}

}
