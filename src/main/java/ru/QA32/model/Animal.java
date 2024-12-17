package ru.QA32.model;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public  class Animal {

    private String species;
    private static int idPet;
    private String petName;
    private String sex;
    private  String dateOfBirth;
    private Double weight;

    private String breed;

    public Animal(String species, int idPet, String petName, String sex, String dateOfBirth, Double weight, String breed) {
        this.species = species;
        Animal.idPet = idPet;
        this.petName = petName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.breed = breed;
    }

    public Animal() {

    }

    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        Animal.idPet = idPet;
    }

    public String getPetName() {
        return petName;
    }

    public String getSpecies() {
        return species;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "\n" +
                "\u001b[34mN\u001b[0m "+ idPet +
                "\u001b[34m вид:\u001b[0m " + species +
                "\u001b[34m кличка:\u001b[0m " + petName +
                "\u001b[34m пол:\u001b[0m " + sex +
                "\u001b[34m дата рождения:\u001b[0m " + dateOfBirth +
                "\u001b[34m вес,кг:\u001b[0m " + weight +
                "\u001b[34m порода:\u001b[0m " + breed;
    }

    public String getSound() {
        return null;
    }
}
