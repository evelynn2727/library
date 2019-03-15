package utils;

import data.Book;
import data.Library;
import data.Magazine;
import data.Publication;

public class LibraryUtils {

    //metoda wyswietlajaca dane ksiazek w bibliotece
    public static void printBooks(Library library){
        Publication[] publications= library.getPublications();
        int countBooks=0;
        for (int i=0;i<library.getPublicationsNumber();i++){
            if (publications[i] instanceof Book){
                System.out.println(publications[i]);
                countBooks++;
            }
        }
        if (countBooks==0)
            System.out.println("Brak ksiazek w bibliotece");
    }

    public static void printMagazines(Library library){
        Publication[] publications=library.getPublications();
        int countMagazines=0;
        for (int i=0;i<library.getPublicationsNumber();i++){
            if (publications[i] instanceof Magazine){
                System.out.println(publications[i]);
                countMagazines++;
            }
        }
        if (countMagazines==0)
            System.out.println("Brak magazynow w bibliotece");
    }
}
