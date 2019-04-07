package data;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private static final long serialVersionUID = 3187078139801519107L;

    private String firstName, lastName, pesel;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
    //Constructor

    public User(String firstName, String lastName, String pesel) {
        super();
        setFirstName(firstName);
        setLastName(lastName);
        setPesel(pesel);
    }
    //methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getFirstName().equals(user.getFirstName()) &&
                getLastName().equals(user.getLastName()) &&
                getPesel().equals(user.getPesel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getPesel());
    }

    @Override
    public String toString() {
        return firstName + " "+ lastName + " "+ pesel;
    }
}
