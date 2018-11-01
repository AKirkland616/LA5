package LA5.edu.wmich.cs1120;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContactInformationFormatter implements IContactInformationFormatter {
Scanner reader;
FormatExceptionHandler t = new FormatExceptionHandler();
String nameA;
String number;
String emailA;

	@Override
	public void readContactInformation(String[] filePaths) {
		// TODO Auto-generated method stub
		
		for (int i =0; i< filePaths.length; i++) {
			File f = new File(filePaths[i]);
			
			try {
				reader = new Scanner(f);
			} catch (FileNotFoundException e) {
				t.handleFileNotFoundException(e);
			}
			
			try {
				formatName(reader.nextLine());
			} catch (NameFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				formatEmail(reader.nextLine());
			} catch (EmailAddressFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				formatPhoneNumber(reader.nextLine());
			} catch (PhoneNumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void formatContactInformation(String fileName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void formatEmail(String email) throws EmailAddressFormatException {
		// TODO Auto-generated method stub
		char [] e = email.toCharArray();
		for(int i = 0; i < e.length; i++) {
			if(e[i]== '.' || e[i] == '@') {
				emailA += e[i];
			}else {
				if(Character.isLowerCase(e[i])) {
					emailA += e[i];
				}else if (!Character.isLowerCase(e[i])) {
					emailA += Character.toLowerCase(e[i]);
				}
			}
			 
		}
		
	}

	@Override
	public void formatPhoneNumber(String phoneNumber) throws PhoneNumberFormatException {
		// TODO Auto-generated method stub
		char[] n = phoneNumber.toCharArray();
		
		
	}

	@Override
	public void formatName(String name) throws NameFormatException {
		// TODO Auto-generated method stub
		
	}

}
