package ru.QA32.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.QA32.dao.OwnerDao;
import ru.QA32.model.Animal;
import ru.QA32.model.Cat;
import ru.QA32.model.Dog;
import ru.QA32.model.Owner;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class OwnerServiceTest {

    @Mock
    private OwnerDao ownerDao;
    @InjectMocks
    private OwnerService ownerService;


    @Test
    void createOwner() {
        Owner owner = ownerService.createOwner("Елена",
                "Вавилова",
                "1985-09-28",
                "89043333333");
        ArrayList<Animal> myPets = new ArrayList<>();
        assertEquals("Вавилова", owner.getLastName());
        assertEquals("Елена", owner.getFirstName());
        assertEquals("1985-09-28", owner.getBirthDay());
        assertEquals("89043333333", owner.getPhoneNumber());
        assertEquals(myPets, owner.getMyPets());


    }

    @Test
    void readOwner() {
        ArrayList<Animal> myPets = new ArrayList<>();
        Owner owner = new Owner ("Елена",
                "Вавилова",
                "1985-09-28",
                "89043333333",myPets);
        Mockito.when(ownerDao.readOwner("Вавилова")).thenReturn(owner);
        assertEquals(owner, ownerService.readOwner("Вавилова"));
    }

    @Test
    void addPetTest() {
        Cat cat = new Cat("кошачьи",
                1,
                "метис",
                "Муся",
                "ж",
                "2002-01-01",
                2.0);
        Dog dog = new Dog("собаки",
                2,
                "бульдог",
                "Бобик",
                "м",
                "2004-01-01",
                4.0);
        ArrayList<Animal> myPet = new ArrayList<>();
        myPet.add(cat);
        Owner owner = new Owner("Елена",
                "Вавилова",
                "1985-09-28",
                "89043333333", myPet);
        Mockito.when(ownerDao.readOwner("Вавилова")).thenReturn(owner);
        assertEquals(owner, ownerService.addPet("Вавилова", "кошачьи", "метис",
                "Муся", "ж",
                "2002-01-01",
                2.0));
       owner.getMyPets().add(dog);
        Mockito.when(ownerDao.readOwner("Вавилова")).thenReturn(owner);
        assertEquals(owner, ownerService.addPet("Вавилова", "собаки", "бульдог",
                "Бобик", "м",
                "2004-01-01", 4.0));
    }

    @Test
    void deletePet() {
        Cat cat = new Cat("кошачьи",
                1,
                "метис",
                "Муся",
                "ж",
                "2002-01-01",
                2.0);
        Dog dog = new Dog("собаки",
                2,
                "бульдог",
                "Бобик",
                "м",
                "2004-01-01",
                4.0);
        ArrayList<Animal> myPet = new ArrayList<>();
        myPet.add(cat);
        myPet.add(dog);
        Owner owner = new Owner("Елена",
                "Вавилова",
                "1985-09-28",
                "89043333333", myPet);
        Mockito.when(ownerDao.readOwner("Вавилова")).thenReturn(owner);
        owner.myPets.remove(dog);
        assertEquals(owner, ownerService.deletePet("Вавилова",2));

    }

    @Test
    void feedPet() {
        Cat cat = new Cat("кошачьи",
                1,
                "метис",
                "Муся",
                "ж",
                "2002-01-01",
                2.0);
        Dog dog = new Dog("собаки",
                2,
                "бульдог",
                "Бобик",
                "м",
                "2004-01-01",
                4.0);
        ArrayList<Animal> myPet = new ArrayList<>();
        myPet.add(cat);
        myPet.add(dog);
        Owner owner = new Owner("Елена",
                "Вавилова",
                "1985-09-28",
                "89043333333", myPet);
        Mockito.when(ownerDao.readOwner("Вавилова")).thenReturn(owner);
        String str ="Гав" + "\n"+ "Елена кормит питомца Бобик кормом Чаппи"  + "\n" + "Довольный питомец ласкается\n";
        assertEquals(str, ownerService.feedPet("Вавилова", 2,"Чаппи"));
        Owner owner2 = new Owner("Елена",
                "Петрова",
                "1985-09-28",
                "89043333333", null);
    }

    @Test
    void calculateAgePet() {
        Cat cat = new Cat("кошачьи",
                1,
                "метис",
                "Муся",
                "ж",
                "2022-01-01",
                2.0);
        ArrayList<Animal> myPet = new ArrayList<>();
        myPet.add(cat);
        Owner owner = new Owner("Елена",
                "Вавилова",
                "1985-09-28",
                "89043333333", myPet);
        Mockito.when(ownerDao.readOwner("Вавилова")).thenReturn(owner);
        assertEquals(2.0, ownerService.calculateAgePet("Вавилова", 1));
    }

    @Test
    void viewPets() {
        Cat cat = new Cat("кошачьи",
                1,
                "метис",
                "Муся",
                "ж",
                "2002-01-01",
                2.0);
        Dog dog = new Dog("собаки",
                2,
                "бульдог",
                "Бобик",
                "м",
                "2004-01-01",
                4.0);
        ArrayList<Animal> myPet = new ArrayList<>();
        myPet.add(cat);
        myPet.add(dog);
        Owner owner = new Owner("Елена",
                "Вавилова",
                "1985-09-28",
                "89043333333", myPet);
        Mockito.when(ownerDao.readOwner("Вавилова")).thenReturn(owner);
        String str = "\u001b[34mПитомцы:\u001b[0m\n" +
                "\u001b[34mN\u001b[0m "+ "1" +
                "\u001b[34m вид:\u001b[0m " + "кошачьи" +
                "\u001b[34m кличка:\u001b[0m " + "Муся" +
                "\u001b[34m пол:\u001b[0m " + "ж" +
                "\u001b[34m дата рождения:\u001b[0m " + "2002-01-01" +
                "\u001b[34m вес,кг:\u001b[0m " + "2.0" +
                "\u001b[34m порода:\u001b[0m " + "метис" + "\n" +
                "\u001b[34mN\u001b[0m "+ "2" +
                "\u001b[34m вид:\u001b[0m " + "собаки" +
                "\u001b[34m кличка:\u001b[0m " + "Бобик" +
                "\u001b[34m пол:\u001b[0m " + "м" +
                "\u001b[34m дата рождения:\u001b[0m " + "2004-01-01" +
                "\u001b[34m вес,кг:\u001b[0m " + "4.0" +
                "\u001b[34m порода:\u001b[0m " + "бульдог" + "\n";
        assertEquals(str, ownerService.viewPets("Вавилова"));

    }

    @Test
    void behave() {
        assertEquals("Довольный питомец ласкается\n", ownerService.behave());
    }

}