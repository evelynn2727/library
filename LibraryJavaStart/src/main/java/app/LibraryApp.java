package app;

public class LibraryApp{

    public static final String appName="Biblioteka v01.00";
    public static void main(String[] args){
        System.out.println(appName);
        LibraryControl libraryControl= new LibraryControl();
        libraryControl.controlLoop();
    }
}
