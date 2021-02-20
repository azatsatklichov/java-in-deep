package net.sahet.designpatterns.structural.adapter;

public class DbReport {

	private String id;
	private String first_name;
	private String last_name;
	private String email_address;

	public DbReport(String id, String firstName, String lastName, String email) {
		this.id = id;
		this.first_name = firstName;
		this.last_name = lastName;
		this.email_address = email;
	}

	public String getId() {
		return id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getEmail_address() {
		return email_address;
	}

}
