package ru.QA32.model;
public class Dog extends Animal {
    private int  idPet;
    private  String species;
    private String breed;
    private String petName;
    private String sex;
    private  String dateOfBirth;
    private Double weight;


    public Dog(String species,int idPet, String breed, String petName, String sex,String dateOfBirth, Double weight) {

        this.species = species;
        this.idPet=idPet;
        this.breed = breed;
        this.petName = petName;
        this.sex = sex;
        this.dateOfBirth=dateOfBirth;
        this.weight = weight;
    }

    @Override
    public int getIdPet() {
        return idPet;
    }

    @Override
    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    @Override
    public String getSpecies() {
        return species;
    }

    public String getSound() {

    return "Гав";}

    @Override
    public String getPetName() {
        return petName;
    }

    @Override
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return
                "\u001b[34mN\u001b[0m "+ idPet +
                "\u001b[34m вид:\u001b[0m " + species +
                "\u001b[34m кличка:\u001b[0m " + petName +
                "\u001b[34m пол:\u001b[0m " + sex +
                "\u001b[34m дата рождения:\u001b[0m " + dateOfBirth +
                "\u001b[34m вес,кг:\u001b[0m " + weight +
                "\u001b[34m порода:\u001b[0m " + breed  + "\n";
    }
}

