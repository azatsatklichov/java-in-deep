package net.sahet.designpatterns.structural.adapter;

public class LdapReportAdapter implements Report {

	private LdapReport instance;

	public LdapReportAdapter(LdapReport instance) {
		this.instance = instance;
	}

	@Override
	public String getId() {
		return instance.getCn();
	}

	@Override
	public String getFirstName() {
		return instance.getGivenName();
	}

	@Override
	public String getLastName() {
		return instance.getSurname();
	}

	@Override
	public String getEmail() {
		return instance.getMail();
	}
}