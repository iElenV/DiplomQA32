package ru.QA32.service;
import ru.QA32.dao.VetCardDao;
import ru.QA32.dao.VeterinarianDao;
import ru.QA32.model.*;

import java.util.Scanner;

public class VeterinarianService implements PetsBehavior {
    Veterinarian veterinarian;
    VetCard vetCard;

    private VeterinarianDao veterinarianDao = new VeterinarianDao();
    private VetCardDao vetCardDao = new VetCardDao();

    public Veterinarian createVeterinarian(String firstname,
                                           String lastName,
                                           String BirthDay,
                                           String phoneNumber,
                                           String position) {
        Veterinarian veterinarian = new Veterinarian(firstname, lastName, BirthDay, phoneNumber, position);
        veterinarianDao.saveVeterinarian(veterinarian);

        return veterinarian;
    }

    public Veterinarian readVeterinarian(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException(" не должен быть пустым");
        }
        return veterinarianDao.readVeterinarian(lastName);
    }

    public void setVeterinarianDao(VeterinarianDao veterinarianDao) {
        this.veterinarianDao = veterinarianDao;
    }

    public VetCard createVetCard(int cardNumber,
                              String date,
                              String species,
                              String animalName,
                              String ownerFirstName,
                              String ownerLastName,
                              String veterinarianPosition,
                              String veterinarianLastName,
                              String type,
                              String result) {

       VetCard vetCard = new VetCard(cardNumber,
               date,
               species,
               animalName,
               ownerFirstName,
               ownerLastName,veterinarianPosition,
               veterinarianLastName,
               type,
               result);
        vetCardDao.saveVetCard(vetCard);
        return vetCard;
    }

    public VetCard readVetCard(int inputCardNumber) {

        return vetCardDao.readVetCard(inputCardNumber);
    }

    public void setVetCardDao(VetCardDao vetCardDao) {
        this.vetCardDao = vetCardDao;
    }

    public VetCard priem(int inputCardNumber, String inputResult) {
        System.out.println(behave());
        vetCard = vetCardDao.readVetCard(inputCardNumber);
        String inputType = "осмотр";
        vetCard.setType(inputType);
        vetCard.setResult(inputResult);
        return vetCard;
    }

    public VetCard priemVac (int inputCardNumber,String inputVac) {
        vetCard = vetCardDao.readVetCard(inputCardNumber);
        System.out.println(behave());
        String result = "Проведена вакцинация, вакцина: " + inputVac;
        String inputType = "вакцинация";
        vetCard.setType(inputType);
        vetCard.setResult(result);

        return vetCard;
    }


    @Override
    public String behave() {
        return "Идет осмотр....Питомец дрожит";

    }
}
