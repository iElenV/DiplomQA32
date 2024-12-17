package ru.QA32.model;


public class VetCard {

    private  int cardNumber;
    private  String date;
    private String species;
    private String animalName;
    private String ownerFirstName;
    private String ownerLastName;
    private String veterinarianPosition;
    private String veterinarianLastName;
    private String type;
    private String result;

    public VetCard(int cardNumber,
                   String date,
                   String species,
                   String animalName,
                   String ownerFirstName,
                   String ownerLastName,
                   String veterinarianPosition,
                   String veterinarianLastName,
                   String type,
                   String result) {
        this.cardNumber = cardNumber;
        this.date = date;
        this.species = species;
        this.animalName = animalName;
        this.ownerFirstName = ownerFirstName;
        this.ownerLastName = ownerLastName;
        this.veterinarianPosition = veterinarianPosition;
        this.veterinarianLastName = veterinarianLastName;
        this.type = type;
        this.result = result;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public String getDate() {
        return date;
    }

    public String getSpecies() {
        return species;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public String getVeterinarianPosition() {
        return veterinarianPosition;
    }

    public String getVeterinarianLastName() {
        return veterinarianLastName;
    }

    public String getType() {
        return type;
    }

    public String getResult() {
        return result;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setResult(String result) {
        this.result = result;
    }


    @Override
    public String toString() {
        return
                "\n" +
                "\u001b[34mN\u001b[0m "+ cardNumber + " " + date + " " +
                "\u001b[34m вид:\u001b[0m " + species +
                "\u001b[34m кличка:\u001b[0m " + animalName +
                "\u001b[34m владелец:\u001b[0m " + ownerFirstName + " " + ownerLastName + " " +
                "\u001b[34m Должность:\u001b[0m " + veterinarianPosition + ", " + veterinarianLastName +
                        "\n" + "\u001b[34mТип приема:\u001b[0m " + type + "\n"+
                "\u001b[34mДиагноз:\u001b[0m " + result;
    }
}
