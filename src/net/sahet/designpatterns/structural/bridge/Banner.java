package net.sahet.designpatterns.structural.bridge;

import java.util.List;

public abstract class Banner {

    public String print(Formatter formatter) {
        return formatter.format(getHeader(), getElements());
    }

    protected abstract String getHeader();

    protected abstract List<Element> getElements();

}
