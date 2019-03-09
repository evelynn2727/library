package data;

public class Library {
    public static final int MAX_BOOKS=1000; //maksymalna liczba ksiazek
    public static final int MAX_MAGAZINES=1000;
    private int booksNumber;//rzeczysiwsta liczba ksiazek w bibliotece
    private Book[] books;
    private int magazinesNumber;
    private Magazine[] magazines;

    public Library() {
        books= new Book[MAX_BOOKS];
        magazines=new Magazine[MAX_MAGAZINES];
    }

    public static int getMaxMagazines() {
        return MAX_MAGAZINES;
    }

    public int getMagazinesNumber() {
        return magazinesNumber;
    }

    public void setMagazinesNumber(int magazinesNumber) {
        this.magazinesNumber = magazinesNumber;
    }

    public Magazine[] getMagazines() {
        return magazines;
    }

    public void setMagazines(Magazine[] magazines) {
        this.magazines = magazines;
    }

    public int getMAX_BOOKS() {
        return MAX_BOOKS;
    }

    public int getBooksNumber() {
        return booksNumber;
    }

    public Book[] getBooks() {
        return books;
    }

    //pozwala dodawac nowe pozycje do istniejeacego zbioru

    public void addBook(Book book){
        if(booksNumber<MAX_BOOKS){
            books[booksNumber]=book;
            booksNumber++;
        }
        else
            System.out.println("Maksymalna liczba ksiazek zostala osiagnieta");
    }
    //metoda wyswietlajaca dane ksiazek w bibliotece
    public void printBooks(){
        if(booksNumber==0)
            System.out.println("Brak ksiazek w bibliotece");
        for (Book bookPrint: books) {
            bookPrint.printInfo();
        }
    }

    public void addMagazines(Magazine magazine){
        if(booksNumber<MAX_MAGAZINES){
            magazines[magazinesNumber]=magazine;
            magazinesNumber++;
        }
        else
            System.out.println("Maksymalna liczba gazet zostala osiagnieta");
    }
    public void printMagazines(){
        if(magazinesNumber==0)
            System.out.println("Brak ksiazek w bibliotece");
        for (Magazine magaz:magazines) {
            magaz.printInfo();
        }
    }
}
