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

    public enum Option {
        EXIT(0, "Wyjscie z programu"),
        ADD_BOOK(1,"Dodanie ksiazki"),
        ADD_MAGAZINES(2, "Dodanie magazynu/gazety"),
        PRINT_BOOKS(3, "Wyswietlanie dostepych ksiazek"),
        PRINT_MAGAZINES(4,"Wyswietlanie dostepnych magazynow/gazet");

        //przechowuje informacje o dwoch wartosciach
        private int value;//przechowuje mozliwa do wprowadzenia przez uzytkownika wartosc
        private String description;//opis tego za co odpowiada dana wartosc

        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        @Override
        public String toString() {
            return  value + " - " + description;
        }

        //pozwala przeksztalcic wartosc typi int na odpowiednia wartosc typu Option
        //metoda ta dzieki values() zwraca tablice wszystkich wartosic, a poniewaz kolejne elementy numerujemy od 0, to zwracamy po prostu odpowiedni element tej tablicy
        public static Option createFromInt(int option) throws NoSuchElementException {
            Option result=null;
            try{
                result=Option.values()[option];
            }catch (ArrayIndexOutOfBoundsException e){
                //thr - throw new +Tab
                throw new NoSuchElementException("Brak elementu o wskazanym id");
            }
            return result;
        }
    }

}
