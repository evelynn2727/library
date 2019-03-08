package app;

import data.Book;
import data.Library;
import utils.DataReader;

public class LibraryControl {
//zmienne do kontrolowania programu //stale
    public static final int EXIT=0;
    public static final int ADD_BOOK=1;
    public static final int PRINT_BOOKS=2;
    //zmienna do komunikacji z uzytkownikiem
    private DataReader dataReader;

    //"biblioteka" przechowujaca dane
    private Library library;

    //glowna petla programu, ktoa pozwala na wybor opcji i interakcje
    public void controlLoop(){
        int option;
        printOptions();

        while((option=dataReader.getInt())!=EXIT){
            switch (option)
            {
                case ADD_BOOK:
                    addBook();
                    break;
                case PRINT_BOOKS:
                    printBooks();
                    break;
                default:
                     System.out.println("nie ma takiej opcji, wprowadz ponownie");
            }
            printOptions();
        }
        //zamykamy strumien wejscia
        dataReader.close();
    }
    private void printOptions(){
        String[] menu={"0 - wyjscie z programu",
        "1 - dodanie nowej ksiazki",
        "2 - wyswietl dostepne ksiazki"};
        System.out.println("Wybierze opcję: ");
        for (String itemMenu: menu
             ) {
            System.out.println(itemMenu);
        }
    }
    private void addBook(){
        Book book= dataReader.readAndCreateBook();
        library.addBook(book);
    }
    private void printBooks(){
        library.printBooks();
    }
}
