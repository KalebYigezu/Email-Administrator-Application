package emailapp;

import java.util.Scanner;

public class Email {
	
	// declaring all the needed variabls 
	private String firstName;
	private String lastName;
	private String passWord;
	private String email;
	private String department;
	private String alternateEmail;
	private String companeySuffix = "companey.com";
	private int mailboxCapacity = 50;
	private int defaultPasswordLength = 6;
	
	// Constructor to receive the first and the last name
	public Email(String fn, String ln) {
		this.firstName = fn;
		this.lastName = ln;
		
		// call a method asking for the department - return the department 
		this.department = setDepartment();
		
		// call a method that return a random password
		this.passWord = randomPassword(defaultPasswordLength);
		
		// combine elements to generate email
		email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + department + "." + companeySuffix;
	}
	
	// Ask for the department
	private String setDepartment() {
		System.out.print("Enter the department\n\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n\n");
		Scanner sc = new Scanner(System.in);
		int departmentChoise = sc.nextInt();
		if(departmentChoise == 1) {
			return "Sales";
		}
		else if(departmentChoise == 2) {
			return "Development";
		}
		else if(departmentChoise == 3) {
			return "Accounting";
		}
		else
			return "";
	}
	
	// Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "abcdefghijklmnopqrstuvwxyz!@#$%^&*()_+";
		char[] password = new char[length];
		for(int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);			
		}
		return new String(password);
	}
	
	// Set the mailbox capacity
	public void setMailBoxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	// Set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	// Change the password
	public void changePassword(String password) {
		this.passWord = password;
	}
	
	public int getMailBoxCapacity() {
		return mailboxCapacity;
	}
	
	public String getAlternateEmail() {
		return alternateEmail;
	}
	
	public String getPassword() {
		return passWord;
	}

	public String showInfo() {
		return "\nPrinted Name = " + firstName + " " + lastName +
			   "\nEmail = " + email + " \nMail box capacity " + mailboxCapacity + "\n" +
			   "Password =" + passWord;
	}
}
