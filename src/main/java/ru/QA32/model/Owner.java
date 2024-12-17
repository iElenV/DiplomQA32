package ru.QA32.model;



import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class Owner extends Person {
    private String firstname;
    private String lastName;
    private  String BirthDay;
    private String phoneNumber;



   public ArrayList<Animal> myPets;

    public Owner(String firstname, String lastName, String birthDay, String phoneNumber, ArrayList<Animal> myPets) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.BirthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.myPets = myPets;
    }

    public Owner(String firstname, String lastName, String birthDay, ArrayList<Animal> myPets) {
        super();
    }

    @Override
    public  String getFirstName() {
        return firstname;
    }

    @Override
    public  String getLastName() {
        return lastName;
    }

    public String getBirthDay() {
        return BirthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<Animal> getMyPets() {
        return myPets;
    }

    @Override
    public String toString() {

        return "\u001b[34mхозяин питомца:\u001b[0m " +
             firstname + ' ' +
             lastName +
             "\u001b[34m дата рождения:\u001b[0m " + BirthDay +
             "\n\u001b[34mПитомцы:\u001b[0m"+ "\n"+  printMyPets(myPets);
    }


     public String  printMyPets (ArrayList myPets) {
         String s1 = "";
        if (myPets.isEmpty()) {
            s1 = "Питомцев нет\n";
        } else {

            for (Object myPet : myPets
            ) {
                String string = myPet.toString();
                s1 = s1 + string;
            }
        }

        return s1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(firstname, owner.firstname) && Objects.equals(lastName, owner.lastName) && Objects.equals(BirthDay, owner.BirthDay) && Objects.equals(phoneNumber, owner.phoneNumber) && Objects.equals(myPets, owner.myPets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastName, BirthDay, phoneNumber, myPets);
    }
}
