package net.sahet.designpatterns.structural.adapter;

public class DbReportAdapter implements Report {

	private DbReport instance;

	public DbReportAdapter(DbReport instance) {
		this.instance = instance;
	}

	@Override
	public String getId() {
		return instance.getId();
	}

	@Override
	public String getFirstName() {
		return instance.getFirst_name();
	}

	@Override
	public String getLastName() {
		return instance.getLast_name();
	}

	@Override
	public String getEmail() {
		return instance.getEmail_address();
	}

}
