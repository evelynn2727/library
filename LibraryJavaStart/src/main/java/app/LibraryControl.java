package app;

import data.Book;
import data.Library;
import data.Magazine;
import utils.DataReader;

public class LibraryControl {
//zmienne do kontrolowania programu //stale
    public static final int EXIT=0;
    public static final int ADD_BOOK=1;
    public static final int ADD_MAGAZINES=2;
    public static final int PRINT_BOOKS=3;
    public static final int PRINT_MAGAZINES=4;

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
                case ADD_MAGAZINES:
                    addMagazine();
                    break;
                case PRINT_BOOKS:
                    printBooks();
                    break;
                case PRINT_MAGAZINES:
                    printMagazine();
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
                "2 - dodanie nowego magazynu",
        "3 - wyswietl dostepne ksiazki",
        "4 - wyswietl dostepne magazyny"};
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
    private void addMagazine(){
        Magazine magazine= dataReader.readAndCreateMagazie();
        library.addMagazines(magazine);
    }
    private void printMagazine()
    {
        library.printMagazines();
    }
}
