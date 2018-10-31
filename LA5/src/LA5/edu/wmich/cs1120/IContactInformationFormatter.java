package LA5.edu.wmich.cs1120;

public interface IContactInformationFormatter {
	void readContactInformation(String[] filePaths);
	void formatContactInformation(String fileName);
	void formatEmail(String email) throws EmailAddressFormatException;
	void formatPhoneNumber(String phoneNumber) throws PhoneNumberFormatException;
	void formatName(String name) throws NameFormatException;
	
}

