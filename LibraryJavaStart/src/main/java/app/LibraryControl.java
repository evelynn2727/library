package app;

import data.Book;
import data.Library;
import data.LibraryUser;
import data.Magazine;
import utils.DataReader;
import utils.FileManager;
import utils.LibraryUtils;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class LibraryControl {

    private DataReader dataReader;
    private FileManager fileManager;


    private Library library;

    public LibraryControl(){
        dataReader=new DataReader();
        fileManager= new FileManager();
        try{
            library= fileManager.readLibraryFromFile();
            System.out.println("Wczytano dane do biblioteki z pliku");
        }catch (ClassNotFoundException | IOException e){
            library= new Library();
            System.out.println("Utworzono nową baze biblioteki");
        }
    }

    public void controlLoop(){
        Option option= null;
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
                    case ADD_USER:
                        addUser();
                        break;
                    case PRINT_USERS:
                        printUsers();
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

    private void addUser(){
        LibraryUser user= dataReader.readAndCreateLibraryUser();
        library.addUsers(user);
    }
    private void printUsers(){
        LibraryUtils.printUsers(library);
    }
    private void exit(){
        fileManager.writeLibraryToFile(library);
    }
    public enum Option {
        EXIT(0, "Wyjscie z programu"),
        ADD_BOOK(1,"Dodanie ksiazki"),
        ADD_MAGAZINES(2, "Dodanie magazynu/gazety"),
        PRINT_BOOKS(3, "Wyswietlanie dostepych ksiazek"),
        PRINT_MAGAZINES(4,"Wyswietlanie dostepnych magazynow/gazet"),
        ADD_USER(5, "Dodanie nowego uzytkownika"),
        PRINT_USERS(6, "Wyswietlenie listy uzytkownikow");

        private int value;
        private String description;

        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        @Override
        public String toString() {
            return  value + " - " + description;
        }
        public static Option createFromInt(int option) throws NoSuchElementException {
            Option result=null;
            try{
                result=Option.values()[option];
            }catch (ArrayIndexOutOfBoundsException e){
                throw new NoSuchElementException("Brak elementu o wskazanym id");
            }
            return result;
        }
    }

}
