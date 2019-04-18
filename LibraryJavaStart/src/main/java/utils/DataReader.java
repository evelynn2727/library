package utils;

import data.Book;
import data.LibraryUser;
import data.Magazine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {

    private Scanner sc;

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public DataReader() {
        sc= new Scanner(System.in);
    }

    public DataReader(Scanner sc) {
        setSc(sc);
    }
    public void close()
    {
        sc.close();
    }
    public Book readAndCreateBook(){
        System.out.println("Tytuł: ");
        String title= sc.nextLine();
        System.out.println("Autor: ");
        String author = sc.nextLine();
        System.out.println("Wydawnictwo: ");
        String publisher = sc.nextLine();
        System.out.println("ISBN: ");
        String isbn = sc.nextLine();
        System.out.println("Rok wydania: ");
        int releaseDate =0;
        int pages = 0;
        try{
            releaseDate=sc.nextInt();
            sc.nextLine();
            System.out.println("Ilość stron: ");
            pages=sc.nextInt();
            sc.nextLine();
        }catch (InputMismatchException e){
            sc.nextLine();
            throw e;
        }

        return new Book(title,author,releaseDate,pages,publisher,isbn);
    }
    public Magazine readAndCreateMagazie(){
        System.out.println("Tytuł: ");
        String title= sc.nextLine();
        System.out.println("Wydawnictwo: ");
        String publisher = sc.nextLine();
        System.out.println("Jezyk ");
        String language= sc.nextLine();
        System.out.println("Rok wydania: ");
        int year = 0;
        int month = 0;
        int day=0;
        try{
            year=sc.nextInt();
            sc.nextLine();
            System.out.println("Miesiac: ");
            month=sc.nextInt();
            sc.nextLine();
            System.out.println("Dzien: ");
            day=sc.nextInt();
            sc.nextLine();
        }catch (InputMismatchException e){
            sc.nextLine();
            throw e;
        }
        return new Magazine(title,publisher,language,year,month,day);
    }


    public int getInt(){
        int number=0;
        try{
            number=sc.nextInt();
        }catch (InputMismatchException e){
            throw new NumberFormatException("Liczba wprowadzona jest nie rpawidolowa");
        }finally {
            sc.nextLine();
        }
        return number;
    }

    public LibraryUser readAndCreateLibraryUser(){
        System.out.println("Imie: ");
        String firstName= sc.nextLine();
        System.out.println("Nazwisko: ");
        String lastName=sc.nextLine();
        System.out.println("PESEL: ");
        String pesel= sc.nextLine();

        return new LibraryUser(firstName, lastName,pesel);
    }
}
