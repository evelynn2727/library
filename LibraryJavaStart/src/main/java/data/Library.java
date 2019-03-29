package data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

public class Library implements Serializable {
    private static final long serialVersionUID = 2995794334600947814L;
    private Publication[] publications;
    private int publicationsNumber;
    public static final int INITIAL_CAPACITY=1;

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
        publications= new Publication[INITIAL_CAPACITY];
    }

    public void addPublications(Publication pub){
        if(publicationsNumber==publications.length){
            publications= Arrays.copyOf(publications,publications.length*2);
              }
        publications[publicationsNumber]=pub;
        publicationsNumber++;
    }

    public void removePublication(Publication pub){
        // remove() pozwala na usunięcie obiektu Publication z tablicy jednocześnie nie
        //pozostawiając w niej pustych miejsc, ponieważ wszystkie elementy, które znajdowały się "na
        //prawo" od usuniętego elementu zostają dosunięte w puste miejsce za pomocą metody
        //System.arraycopy()
        if(pub==null){
            return;
        }

        final int NOT_FOUND=-1;
        int found= NOT_FOUND;
        int i=0;
        while (i<publications.length && found==NOT_FOUND){
            if (pub.equals(publications[i])){
                found=i;
            }else{
                i++;
            }
        }
        if(found!=NOT_FOUND){
            System.arraycopy(publications, found+1,publications,found, publications.length);
            publicationsNumber--;
        }
    }

    public void addMagazines(Magazine magazine){
     addPublications(magazine);
    }
    public void addBooks(Book book){
        addPublications(book);
    }

    public static class AlphabeticalComparator implements Comparator<Publication>{
//dzieki temu, ze sa statyczne nie trzeba tworzyc instancji kalsy Library do poslugiwania sie nimi
        @Override
        public int compare(Publication o1, Publication o2) {
            if(o1==null && o2==null)
                return 0;
            if(o1==null)
                return 1;
            if(o2==null)
                return -1;
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }
    public static class DateComparator implements Comparator<Publication>{

        @Override
        public int compare(Publication o1, Publication o2) {
            if(o1==null && o2==null)
                return 0;
            if(o1==null)
                return 1;
            if(o2==null)
                return -1;
            Integer i1=o1.getYear();
            Integer i2=o2.getYear();
            return -i1.compareTo(i2);
        }
    }
}
