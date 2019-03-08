package utils;

import data.Book;

import java.util.Scanner;

public class DataReader {
    //pozwala na tworzenie nowych ksiazek na podstawie danych od uzytkownika
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
        int releaseDate = sc.nextInt();
        sc.nextLine();
        System.out.println("Ilość stron: ");
        int pages = sc.nextInt();
        sc.nextLine();

        return new Book(title,author,releaseDate,pages,publisher,isbn);
    }

    //pozwala na odczytanie pojedynczej liczby typu int
    public int getInt(){
        int number=sc.nextInt();
        sc.nextLine();
        return number;
    }
}
