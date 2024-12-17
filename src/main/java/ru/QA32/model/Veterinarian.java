package ru.QA32.model;

import java.util.Objects;

public class Veterinarian extends Person {
    private String firstname;
    private String lastName;
    private String birthDay;
    private String phoneNumber;
    private String position;


    public Veterinarian(String firstname,
                        String lastName,
                        String birthDay,
                        String phoneNumber,
                        String position) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.position = position;
    }

    @Override
    public String getFirstName() {
        return firstname;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veterinarian that = (Veterinarian) o;
        return Objects.equals(firstname, that.firstname) && Objects.equals(lastName, that.lastName) && Objects.equals(birthDay, that.birthDay) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastName, birthDay, phoneNumber, position);
    }

    @Override
    public String toString() {
        return position + " " + firstname + " " + lastName + "\u001b[34m дата рождения:\u001b[0m " +
                birthDay + "\u001b[34m тел.: \u001b[0m" + phoneNumber;
    }
}
