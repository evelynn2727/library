package app;

import data.Book;
import data.Library;
import data.Magazine;
import utils.DataReader;
import utils.LibraryUtils;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

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
        Option option= null;
        printOptions();

        while(option!=Option.EXIT){
            try {
                printOptions();
                option = Option.createFromInt(dataReader.getInt());

                switch (option) {
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
            }catch (InputMismatchException e){
                System.out.println("Wprowadzono niepoprawne dane");
            }catch (NumberFormatException | NoSuchElementException e){
                System.out.println("Wybrana opcja nie istnieje");
            }
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
        library.addPublications(book);
    }
    private void printBooks(){
        LibraryUtils.printBooks(library);
    }
    private void addMagazine(){
        Magazine magazine= dataReader.readAndCreateMagazie();
        library.addMagazines(magazine);
    }
    private void printMagazine()
    {
        LibraryUtils.printMagazines(library);
    }
}
