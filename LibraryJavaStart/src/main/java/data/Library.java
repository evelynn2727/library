package data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Library implements Serializable {
    private static final long serialVersionUID = 2995794334600947814L;
    private Map<String,Publication> publications;
    private int publicationsNumber;
    public static final int INITIAL_CAPACITY=1;
    private Map<String,LibraryUser> users;

    public Map<String, Publication> getPublications() {
        return publications;
    }

    public void setPublications(Map<String, Publication> publications) {
        this.publications = publications;
    }

    public Map<String, LibraryUser> getUsers() {
        return users;
    }

    public void setUsers(Map<String, LibraryUser> users) {
        this.users = users;
    }

    public int getPublicationsNumber() {
        return publicationsNumber;
    }

    public void setPublicationsNumber(int publicationsNumber) {
        this.publicationsNumber = publicationsNumber;
    }

    public Library() {

        publications= new HashMap<>();
        users= new HashMap<>();
    }

    public void addPublications(Publication pub){
       publications.put(pub.getTitle(),pub);
    }

    public void removePublication(Publication pub){
        // remove() pozwala na usunięcie obiektu Publication z tablicy jednocześnie nie
        //pozostawiając w niej pustych miejsc, ponieważ wszystkie elementy, które znajdowały się "na
        //prawo" od usuniętego elementu zostają dosunięte w puste miejsce za pomocą metody
        //System.arraycopy()
//        if(pub==null){
//            return;
//        }
//
//        final int NOT_FOUND=-1;
//        int found= NOT_FOUND;
//        int i=0;
//        while (i<publications.length && found==NOT_FOUND){
//            if (pub.equals(publications[i])){
//                found=i;
//            }else{
//                i++;
//            }
//        }
//        if(found!=NOT_FOUND){
//            System.arraycopy(publications, found+1,publications,found, publications.length);
//            publicationsNumber--;
//        } //to juz nie bo uzywamy map
        if(publications.containsValue(pub)){
            publications.remove(pub.getTitle());
        }
    }

    public void addMagazines(Magazine magazine){
     addPublications(magazine);
    }
    public void addBooks(Book book){
        addPublications(book);
    }
    public void addUsers(LibraryUser user){
        users.put(user.getPesel(),user);
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

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        for (Publication p: publications.values()){
            builder.append(p);
            builder.append("\n");

        }
        return builder.toString();
    }
}
