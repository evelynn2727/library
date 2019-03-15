package app;

import java.util.NoSuchElementException;

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

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
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
