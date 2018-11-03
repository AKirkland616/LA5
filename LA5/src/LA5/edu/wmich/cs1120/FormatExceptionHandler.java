package LA5.edu.wmich.cs1120;

import java.io.FileNotFoundException;

public class FormatExceptionHandler implements IFormatExceptionHandler{

	@Override
	public void handleFileNotFoundException(FileNotFoundException e) {
		// TODO Auto-generated method stub
		System.out.println(e);
		
	}

	@Override
	public void handlePhoneNumberFormatException(PhoneNumberFormatException e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleEmailFormatException(EmailAddressFormatException e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleNameFormatException(NameFormatException e) {
		// TODO Auto-generated method stub
		
	}

}
