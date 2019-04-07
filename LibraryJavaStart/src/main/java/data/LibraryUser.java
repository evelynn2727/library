package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibraryUser extends User {
    private static final long serialVersionUID = 1704976407311180890L;

    private List<Publication> publicationHistory;
    private List<Publication> borrowedPublications;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<Publication> getPublicationHistory() {
        return publicationHistory;
    }

    public void setPublicationHistory(List<Publication> publicationHistory) {
        this.publicationHistory = publicationHistory;
    }

    public List<Publication> getBorrowedPublications() {
        return borrowedPublications;
    }

    public void setBorrowedPublications(List<Publication> borrowedPublications) {
        this.borrowedPublications = borrowedPublications;
    }

    public LibraryUser(String firstName, String lastName, String pesel) {
        super(firstName, lastName, pesel);
        publicationHistory=new ArrayList<>();
        borrowedPublications= new ArrayList<>();
    }

    public void addPublicationToHistory(Publication pub){
        publicationHistory.add(pub);
    }

    public void borrowPublication(Publication pub){
        borrowedPublications.add(pub);
    }

    public boolean returnPublication(Publication pub){
        boolean result=false;
        if(borrowedPublications.remove(pub)){
            result=true;
            addPublicationToHistory(pub);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibraryUser)) return false;
        if (!super.equals(o)) return false;
        LibraryUser that = (LibraryUser) o;
        return getPublicationHistory().equals(that.getPublicationHistory()) &&
                getBorrowedPublications().equals(that.getBorrowedPublications());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPublicationHistory(), getBorrowedPublications());
    }
}
