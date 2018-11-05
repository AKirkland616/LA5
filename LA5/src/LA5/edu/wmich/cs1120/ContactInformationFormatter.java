package LA5.edu.wmich.cs1120;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ContactInformationFormatter implements IContactInformationFormatter {
Scanner reader;
FormatExceptionHandler t = new FormatExceptionHandler();
String nameA = "";
String number = "";
String emailA = "";

	@Override
	public void readContactInformation(String[] filePaths) {
		// TODO Auto-generated method stub
		
		for (int i =0; i< filePaths.length; i++) {
				formatContactInformation(filePaths[i]);
				nameA = "";
				number = "";
				emailA = "";
		}
	}

	@Override
	public void formatContactInformation(String fileName) {
		// TODO Auto-generated method stub
		try {
			reader = new Scanner(new FileReader(new File(fileName)));
			try {
				formatName(reader.nextLine());
			} catch (NameFormatException e) {
				// TODO Auto-generated catch block
				t.handleNameFormatException(e);
			}
			
			try {
				formatPhoneNumber(reader.nextLine());
			} catch (PhoneNumberFormatException e) {
				// TODO Auto-generated catch block
				t.handlePhoneNumberFormatException(e);
			}
			
			try {
				formatEmail(reader.nextLine());
			} catch (EmailAddressFormatException e) {
				// TODO Auto-generated catch block
				t.handleEmailFormatException(e);
			} 
		}catch (FileNotFoundException e) {
				t.handleFileNotFoundException(e);
			}
		
		
	}

	@Override
	public void formatEmail(String email) throws EmailAddressFormatException {
		// TODO Auto-generated method stub
		char [] e1 = email.toCharArray();
		for(int i = 0; i < e1.length; i++) {
			if(e1[i]== '.' || e1[i] == '@' || Character.isDigit(e1[i]) || Character.isLowerCase(e1[i])) {
				
			}else{
				throw new EmailAddressFormatException(email);
			}
		}
		emailA = email;
		if (emailA != "") {
			System.out.println(emailA);
		}
	}

	@Override
	public void formatPhoneNumber(String phoneNumber) throws PhoneNumberFormatException {
		// TODO Auto-generated method stub
		char[] n = phoneNumber.toCharArray();
		for (int i= 0; i < n.length; i++) {
			if (i == 0 && n[0] != '(') {
				throw new PhoneNumberFormatException(phoneNumber);
			}else if (i == 4 && n[4] != ')') {
				throw new PhoneNumberFormatException(phoneNumber);
			}else if (i == 5 && n[5] != '-') {
				throw new PhoneNumberFormatException(phoneNumber);
			}else if (i == 9 && n[9] != '-') {
				throw new PhoneNumberFormatException(phoneNumber);
			}else if (!Character.isDigit(n[i])&& i != 9 && i != 5 && i != 4 && i != 0) {
				throw new PhoneNumberFormatException(phoneNumber);
			}
		}
		number = phoneNumber;
		if (number != "") {
			System.out.println(number);
		}
		
	
	}

	@Override
	public void formatName(String name) throws NameFormatException {
		// TODO Auto-generated method stub
		String [] a = name.split(" ");
		char[] n = a[0].toCharArray();
		char[] na = a[1].toCharArray();
	
		for (int i = 0; i < n.length; i++) {
			if(Character.isUpperCase(n[i]) && i != 0) {
				throw new NameFormatException(name);
			}
	}
		for (int i = 0; i < na.length; i++) {				
			if(Character.isUpperCase(na[i]) && i != 0) {
				throw new NameFormatException(name);
			}			
		
	}
	nameA = name;
	if (nameA != "") {
		System.out.println(nameA);
	}
	}
}
