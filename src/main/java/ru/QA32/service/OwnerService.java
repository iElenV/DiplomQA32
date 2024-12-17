package ru.QA32.service;

import ru.QA32.dao.OwnerDao;
import ru.QA32.model.Animal;
import ru.QA32.model.Cat;
import ru.QA32.model.Dog;
import ru.QA32.model.Owner;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class OwnerService implements PetsBehavior {
    Owner owner;

    private OwnerDao ownerDao = new OwnerDao();
    private int idPet = 0;

    public Owner createOwner(String firstname,
                             String lastName,
                             String birthDay,
                             String phoneNumber) {
        ArrayList<Animal> myPets = new ArrayList<>();


        Owner owner = new Owner(firstname, lastName, birthDay, phoneNumber, myPets);
        ownerDao.saveOwner(owner);

        return owner;
    }

    public Owner readOwner(String inputLastName) {
        if (inputLastName == null) {
            throw new IllegalArgumentException(" не должен быть пустым");
        }
        return ownerDao.readOwner(inputLastName);
    }

    public void setOwnerDao(OwnerDao ownerDao) {
        this.ownerDao = ownerDao;
    }


    public Owner addPet(String inputLastName, String inputspecies, String inputBreed,
                        String inputPetName, String inputSex,
                        String inputDateOfBirth, Double inputWeight) {
        owner = ownerDao.readOwner(inputLastName);
        if ("кошачьи".equals(inputspecies)) {
            idPet ++;
            Animal Cat = new Cat(inputspecies, idPet, inputBreed,
                    inputPetName, inputSex, inputDateOfBirth, inputWeight);
            owner.myPets.add(Cat);
        } else if ("собаки".equals(inputspecies)) {
            idPet ++;
            Animal Dog = new Dog(inputspecies, idPet, inputBreed,
                    inputPetName, inputSex, inputDateOfBirth, inputWeight);
            owner.myPets.add(Dog);
        } else System.out.println("Порода введена неверно");
        ownerDao.saveOwner(owner);
        return owner;
    }


    public Owner deletePet(String inputLastName, int inputidPet) {
        owner = ownerDao.readOwner(inputLastName);
        Animal animal = null;
        for (int i = 0; i < owner.myPets.size(); i++) {
            if (owner.myPets.get(i).getIdPet() == inputidPet) {
                System.out.print("\u001b[34mСледующий питомец отдан:\u001b[0m\n "
                        + owner.myPets.get(i) + "\n");
                animal = owner.myPets.remove(i);
            }
        }
        if (animal == null) {
            System.out.println("\u001b[31mПитомца с таким идентификатором нет\u001b[0m\n");
        }
        ownerDao.saveOwner(owner);
        return owner;
    }

    public String feedPet(String inputLastName, int inputidPet, String inputPetFood) {
        owner = ownerDao.readOwner(inputLastName);
        String str = "";
        Animal animal = null;
        for (int i = 0; i < owner.myPets.size(); i++) {
            if (owner.myPets.get(i).getIdPet() == inputidPet) {
                 str = owner.myPets.get(i).getSound() + "\n" +
                        owner.getFirstName() + " кормит питомца " +
                        owner.myPets.get(i).getPetName() + " кормом " + inputPetFood + "\n" +
                behave();
                animal = owner.myPets.get(i);
            }

        }
        if (animal==null)
            str = "\u001b[31mПитомца с " +
                "таким идентификатором нет\u001b[0m\n";
    return str;}

    public float calculateAgePet(String inputLastName, int inputidPet) {
        owner = ownerDao.readOwner(inputLastName);
        float calculateAge = 0;
        Animal animal = null;
        for (int i = 0; i < owner.myPets.size(); i++) {
            if (owner.myPets.get(i).getIdPet() == inputidPet) {
                String dateOfBirth = owner.myPets.get(i).getDateOfBirth();
                //Define a DateTimeFormatter for the input format
                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                // Convert input to LocalDate
                LocalDate dateOfBirthPet = LocalDate.parse(dateOfBirth, format);
                //Define current LocalDate
                LocalDate currentDay = LocalDate.now();
                Period period = Period.between(dateOfBirthPet,currentDay);
                calculateAge = period.getYears();
                animal = owner.myPets.get(i);
            }

        }
        if (animal==null) System.out.println("\u001b[31mПитомца с таким идентификатором нет\u001b[0m\n");
        return calculateAge;
    }

    public String viewPets (String inputLastName) {
        owner = ownerDao.readOwner(inputLastName);
        return "\u001b[34mПитомцы:\u001b[0m\n" + owner.printMyPets(owner.myPets);
    }



    @Override
    public String behave() {
        return "Довольный питомец ласкается\n";
    }
}
