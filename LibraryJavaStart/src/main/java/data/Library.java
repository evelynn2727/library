package data;

import java.io.Serializable;

public class Library implements Serializable {
    private static final long serialVersionUID = 2995794334600947814L;
    public static final int MAX_PUBLICATIONS=2000; //maksymalna liczba ksiazek I MAGAZYNOW
    private Publication[] publications;
    private int publicationsNumber;

    public static int getMaxPublications() {
        return MAX_PUBLICATIONS;
    }

    public Publication[] getPublications() {
        return publications;
    }

    public void setPublications(Publication[] publications) {
        this.publications = publications;
    }

    public int getPublicationsNumber() {
        return publicationsNumber;
    }

    public void setPublicationsNumber(int publicationsNumber) {
        this.publicationsNumber = publicationsNumber;
    }

    public Library() {
        publications= new Publication[MAX_PUBLICATIONS];
    }

    public void addPublications(Publication pub){
        if(publicationsNumber==MAX_PUBLICATIONS){
            throw new ArrayIndexOutOfBoundsException("skonczylo sie miejsce");
        }
        publications[publicationsNumber]=pub;
        publicationsNumber++;
    }


    public void addMagazines(Magazine magazine){
     addPublications(magazine);
    }
    public void addBooks(Book book){
        addPublications(book);
    }

}
