public class Library {
    public static void main(String[] args){
        final String appName="Biblioteka v.03";

        Book book1 = new Book("W pustyni i w puszczy", "Henryk Sienkiewicz", 2010, 223,"Greg", "9788373271890");
        Book book2 = new Book("Java. Efektywne programowanie. Wydanie II", "Josh" ,  2010,352, "Helion", "9788324620845");
        Book book3 = new Book("SCJP Sun Certied Programmer for Java 6",   "Bert Bates, Katherine Sierra", 2008, 851, "McGraw-Hill Osborne Media","9780071591065");

        System.out.print(appName);
        System.out.println("Książki dostępne w bibliotece:");
        book1.printInfo();   book2.printInfo();
        book3.printInfo();
    }
}
