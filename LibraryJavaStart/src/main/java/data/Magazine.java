package data;

import java.util.Objects;

public class Magazine extends Publication {
    private static final long serialVersionUID = 2061400934707882805L;
    private int month;
    private int day;
    private String language;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Magazine(String title, String publisher, String language, int year, int month, int day){
        super(year,title,publisher);

        setLanguage(language);
        setMonth(month);
        setDay(day);
    }

    @Override
    public String toString() {
        StringBuilder print= new StringBuilder(32);//rozmiar wykorzystywanego bufora w wewnetrznej rezentacji tej klasy,
        //32 oznacza ilosc znakow, ktore sie zmieszcza w pojedynczym napisie przekazywanym w metodach append()
        //w przypadku gdy napis bedzie dluzszy bufor zostaje podwojony - lepiej mu zapewnic rozmiar niz zrzucac te czynnosc na wirtualna maszyne
        print.append(getTitle());
        print.append("; ");
        print.append(getPublisher());
        print.append("; ");
        print.append(getYear());
        print.append("; ");
        print.append(getMonth());
        print.append("; ");
        print.append(getDay());
        print.append("; ");
        print.append(getLanguage());

        return print.toString();
       }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Magazine))
            return false;
        if (!super.equals(o))
            return false;

        Magazine magazine = (Magazine) o;

        return getMonth() == magazine.getMonth() &&
                getDay() == magazine.getDay() &&
                getLanguage().equals(magazine.getLanguage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMonth(), getDay(), getLanguage());
    }
}
