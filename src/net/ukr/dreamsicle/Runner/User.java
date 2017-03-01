package net.ukr.dreamsicle.Runner;

/**
 * Created by Yura on 13.02.2017.
 */
public class User {
    private final String name;
    private final String surname;
    private final String email;
    private final long phone;

    public User(String name, String surname, String email, long phone) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public long getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "User [" +
                "n ame=[" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", my old trips" +
                " "+
                ']';
    }

    public String myOldTrips() {
        return null;
    }
}


