package net.sahet.designpatterns.structural.bridge;

import java.util.ArrayList;
import java.util.List;

public class MovieBanner extends Banner {

    private Movie movie;

    public MovieBanner(Movie movie) {
        this.movie = movie;
    }

    @Override
    protected String getHeader() {
        return movie.getClassification();
    }

    @Override
    protected List<Element> getElements() {
        List<Element> details = new ArrayList<>();
        details.add(new Element("Title", movie.getTitle()));
        details.add(new Element("Year", movie.getYear()));
        details.add(new Element("Runtime", movie.getRuntime()));
        return details;
    }
}
