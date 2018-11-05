package LA5.edu.wmich.cs1120;

import java.io.FileNotFoundException;

public class FormatExceptionHandler implements IFormatExceptionHandler{

	private String nameA = "";
	private String number = "";
	private String emailA = "";
	@Override
	public void handleFileNotFoundException(FileNotFoundException e) {
		// TODO Auto-generated method stub
		System.out.println(e.getMessage());
	}
	@Override
	public void handlePhoneNumberFormatException(PhoneNumberFormatException e) {
		// TODO Auto-generated method stub
		number="";
		char[] n = e.getMessage().toCharArray();
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
		System.out.println(number);
	}

	@Override
	public void handleEmailFormatException(EmailAddressFormatException e) {
		// TODO Auto-generated method stub
		emailA="";
		char [] e1 = e.getMessage().toCharArray();
		for(int i = 0; i < e1.length; i++) {
			if(e1[i]== '.' || e1[i] == '@') {
				emailA += e1[i];
			}else {
				if(Character.isLowerCase(e1[i])) {
					emailA += e1[i];
				}else if (!Character.isLowerCase(e1[i])) {
					emailA += Character.toLowerCase(e1[i]);
				}
			}
			 
		}
		System.out.println(emailA);
	}

	@Override
	public void handleNameFormatException(NameFormatException e) {
		// TODO Auto-generated method stub
		nameA="";
		char[]n = e.getMessage().toCharArray();
		for (int i = 0; i < n.length; i++) {
			
			if (n[i] == ' ') {
				nameA += n[i];
			}else if(Character.isLowerCase(n[i])) {
				nameA += n[i];
			}else if (!Character.isLowerCase(n[i])) {
				nameA += Character.toLowerCase(n[i]);
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
		System.out.println(nameA);
	}

}
