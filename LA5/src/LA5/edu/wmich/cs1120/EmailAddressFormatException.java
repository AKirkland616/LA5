package LA5.edu.wmich.cs1120;

public class EmailAddressFormatException extends Exception{
	/**
	 * 
	 * @param message prints out the error message if the email formatter finds an error
	 */
	public EmailAddressFormatException(String message) {
		super(message);
	}
}
