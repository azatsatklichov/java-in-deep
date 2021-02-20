package net.sahet.designpatterns.structural.adapter;

public class CsvReportAdapter implements Report {

    private CsvReport instance;

    public CsvReportAdapter(CsvReport instance) {
        this.instance = instance;
    }

    @Override
    public String getId() {
        return String.valueOf(instance.getId());
    }

    @Override
    public String getFirstName() {
        return instance.getName();
    }

    @Override
    public String getLastName() {
        return instance.getSurname();
    }

    @Override
    public String getEmail() {
        return instance.getEmailAddress();
    }
     
}
