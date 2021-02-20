package net.sahet.designpatterns.structural.adapter;

import java.util.StringTokenizer;

public class CsvReport {

    private int id;
    private String name;
    private String surname;
    private String emailAddress;

    public CsvReport(String values) {
        StringTokenizer tokenizer = new StringTokenizer(values, ",");

        if (tokenizer.hasMoreElements()) {
            id = Integer.parseInt(tokenizer.nextToken());
        }
        if (tokenizer.hasMoreElements()) {
            name = tokenizer.nextToken();
        }
        if (tokenizer.hasMoreElements()) {
            surname = tokenizer.nextToken();
        }
        if (tokenizer.hasMoreElements()) {
            emailAddress = tokenizer.nextToken();
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
