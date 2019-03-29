package data;

import java.io.Serializable;

public class Publication implements Serializable, Comparable<Publication> {
    private static final long serialVersionUID = 7910452641164094454L;
    private int year;
    private String title;
    private String publisher;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Publication))
            return false;
        Publication that = (Publication) o;

        return getYear() == that.getYear() &&
                getTitle().equals(that.getTitle()) &&
                getPublisher().equals(that.getPublisher());
    }

    @Override
    public int hashCode() {
       final int prime= 31;
       int result=1;
       result=prime*result+((publisher==null)?0: publisher.hashCode());
        result=prime*result+((title==null)?0:title.hashCode());
        result=prime*result+year;
        return result;
    }

    protected Publication(int year, String title, String publisher) {
        setYear(year);
        setTitle(title);
        setPublisher(publisher);
    }

    @Override
    public int compareTo(Publication o) {
        return title.compareTo(o.getTitle());
    }
}
