package data;

public class Library {
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
        if(publicationsNumber<MAX_PUBLICATIONS){
            publications[publicationsNumber]=pub;
            publicationsNumber++;
        }
        else
            System.out.println("Maksymalna liczba publikacji zostala osiagnieta");
    }
    //metoda wyswietlajaca dane ksiazek w bibliotece
    public void printBooks(){
        int countBooks=0;
        for (int i=0;i<publicationsNumber;i++){
            if (publications[i] instanceof Book){
                System.out.println(publications[i]);
                countBooks++;
            }
        }
        if (countBooks==0)
            System.out.println("Brak ksiazek w bibliotece");
    }

    public void addMagazines(Magazine magazine){
     addPublications(magazine);
    }
    public void addBooks(Book book){
        addPublications(book);
    }
    public void printMagazines(){
        int countMagazines=0;
        for (int i=0;i<publicationsNumber;i++){
            if (publications[i] instanceof Magazine){
                System.out.println(publications[i]);
                countMagazines++;
            }
        }
        if (countMagazines==0)
            System.out.println("Brak magazynow w bibliotece");
    }
}
