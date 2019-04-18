package utils;

import data.*;

import java.util.*;

public class LibraryUtils {

    //metoda wyswietlajaca dane ksiazek w bibliotece
    public static void printBooks(Library library){
//       3. List<Publication> publications=new ArrayList<>();
//        publications.addAll(library.getPublications().values());
        //2. Collection<Publication> publications= library.getPublications().values();
       //1. Arrays.sort(publications, new Library.AlphabeticalComparator());
       //3. int countBooks=0;
//       1.  for (int i=0;i<library.getPublicationsNumber();i++){
//            if (publications[i] instanceof Book){
//                System.out.println(publications[i]);
//                countBooks++;
//            }
//        }
// 3.       Collections.sort(publications,new Library.AlphabeticalComparator());
//        for(Publication p: publications){
//            if(p instanceof Book){
//                System.out.println(p);
//                countBooks++;
//            }
//        }

       printPublications(library,Magazine.class);
    }

    public static void printMagazines(Library library){
//    3.   List<Publication> publications= new ArrayList<>();
//       publications.addAll(library.getPublications().values());
//        //2. Collection<Publication> publications=library.getPublications().values();
      //1.  Arrays.sort(publications, new Library.AlphabeticalComparator());
      //3.  int countMagazines=0;
//        for (int i=0;i<library.getPublicationsNumber();i++){
//            if (publications[i] instanceof Magazine){
//                System.out.println(publications[i]);
//                countMagazines++;
//            }
//        }
//    3.    Collections.sort(publications, new Library.AlphabeticalComparator());
//        for(Publication p: publications){
//            if(p instanceof Magazine){
//                System.out.println(p);
//                countMagazines++;
//            }
//        }


        printPublications(library,Book.class);
    }
    public static void printUsers(Library lib){
//   3.     List<LibraryUser> users=new ArrayList<>();
//        users.addAll(lib.getUsers().values());
//        Collections.sort(users, new Comparator<LibraryUser>() {
//            @Override
//            public int compare(LibraryUser o1, LibraryUser o2) {
//                return o1.getLastName().compareTo(o2.getLastName());
//            }
//        });

      //1.  Collection<LibraryUser> users= lib.getUsers().values();

//     3.   for(LibraryUser u: users){
//            System.out.println(u);
//        }

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
