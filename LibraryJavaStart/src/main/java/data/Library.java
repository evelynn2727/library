package data;

public class Library {
    public final int maxBooks=1000; //maksymalna liczba ksiazek
    private int booksNumber;//rzeczysiwsta liczba ksiazek w bibliotece
    private Book[] books;

    public Library() {
        books= new Book[maxBooks];
    }

    public int getMaxBooks() {
        return maxBooks;
    }

    public int getBooksNumber() {
        return booksNumber;
    }

    public Book[] getBooks() {
        return books;
    }

    //pozwala dodawac nowe pozycje do istniejeacego zbioru

    public void addBook(Book book){
        if(booksNumber<maxBooks){
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

}
