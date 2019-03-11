package app;

import data.Book;
import data.Library;
import data.Magazine;
import utils.DataReader;

public class LibraryControl {
    //zmienna do komunikacji z uzytkownikiem
    private DataReader dataReader;

    //"biblioteka" przechowujaca dane
    private Library library;

    public LibraryControl(){
        dataReader=new DataReader();
        library= new Library();
    }

    //glowna petla programu, ktoa pozwala na wybor opcji i interakcje
    public void controlLoop(){
        Option option;
        printOptions();

        while((option=Option.createFromInt(dataReader.getInt()))!=Option.EXIT){
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
        System.out.println("Wybierz opcje: ");
        for (Option o:Option.values()
             ) {
            System.out.println(o);
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
