package utils;

import data.*;

public class LibraryUtils {

    public static void printBooks(Library library){
       printPublications(library,Magazine.class);
    }

    public static void printMagazines(Library library){
        printPublications(library,Book.class);
    }
    public static void printUsers(Library lib){
        lib.getUsers()
                .values()
                .stream()
                .sorted((a,b)->a.getLastName().compareTo(b.getLastName()))
                .forEach(System.out::println);
    }
    private static void printPublications(Library lib, Class cl){
        long countBooks=lib.getPublications()
                .values()
                .stream()
                .filter(cl::isInstance)
                .sorted(new Library.AlphabeticalComparator())
                .peek(System.out::println)
                .count();

        if (countBooks==0)
            System.out.println("W bibliotece nie znaleziono publikacji typo"+cl.getSimpleName());
    }

}
