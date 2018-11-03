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
			
			try {
				reader = new Scanner(new FileReader(new File(filePaths[i])));
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
				formatContactInformation(filePaths[i]);
				nameA = "";
				emailA = "";
				number = "";
			} catch (FileNotFoundException e) {
				t.handleFileNotFoundException(e);
			}
			
			
			
		}
	}

	@Override
	public void formatContactInformation(String fileName) {
		// TODO Auto-generated method stub
		System.out.println(nameA);
		System.out.println(number);
		System.out.println(emailA);
		
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
		for(int i = 0; i< n.length; i++) {
			if (n[i] == '-' || n[i] == '(' || n[i] == ')') {
				
			}else {
				number += n[i];
			}
		}
		n = number.toCharArray();
		for(int i = 0; i < n.length; i++) {
			if (i == 0) {
				number = "(";
				number += n[i];
				
			}else if (i == 2) {
				number += n[i];
				number += ')';
				number += '-';
				
			}else if (i == 5) {
				number += n[i];
				number += '-';
			}else {
				number += n[i];
			}
			
		}
		
		
	}

	@Override
	public void formatName(String name) throws NameFormatException {
		// TODO Auto-generated method stub
		char[] n = name.toCharArray();
		for (int i = 0; i < n.length; i++) {
			//retry
			try {
			if(Character.isDigit(n[i])) {
				throw new NameFormatException();
			}
			if (n[i] == ' ') {
				nameA += n[i];
			}else if(Character.isLowerCase(n[i])) {
				nameA += n[i];
			}else if (!Character.isLowerCase(n[i])) {
				nameA += Character.toLowerCase(n[i]);
			}
		}catch(NameFormatException e) {
			t.handleNameFormatException(e);
		}
		}
		String [] a = nameA.split(" ");
		nameA = "";
		n = a[0].toCharArray();
		for(int i = 0; i < n.length; i++) {
			if (i == 0) {
				nameA += Character.toUpperCase(n[i]);
			}else {
				nameA += Character.toLowerCase(n[i]);
			}
			
				}
		nameA += ' ';
		n = a[1].toCharArray();
		
		for(int i = 0; i < n.length; i++) {
			if (i == 0) {
				nameA += Character.toUpperCase(n[i]);
			}else {
				nameA += Character.toLowerCase(n[i]);
		}
		
	}
	}
}
