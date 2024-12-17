package ru.QA32.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.QA32.dao.OwnerDao;
import ru.QA32.dao.VetCardDao;
import ru.QA32.dao.VeterinarianDao;
import ru.QA32.model.Animal;
import ru.QA32.model.Owner;
import ru.QA32.model.VetCard;
import ru.QA32.model.Veterinarian;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class VeterinarianServiceTest {
    @Mock
    private VeterinarianDao veterinarianDao;
    @Mock
    private VetCardDao vetCardDao;
    @InjectMocks
    private VeterinarianService veterinarianService;
    @Test
    void createVeterinarian() {
        Veterinarian veterinarian = veterinarianService.createVeterinarian("Иван",
                "Иванов",
                "1985-09-09",
                "8904555",
                "ветеринар");

        assertEquals("Иван", veterinarian.getFirstName());
        assertEquals("Иванов", veterinarian.getLastName());
        assertEquals("1985-09-09", veterinarian.getBirthDay());
        assertEquals("8904555", veterinarian.getPhoneNumber());
        assertEquals("ветеринар", veterinarian.getPosition());

    }

    @Test
    void readVeterinarian() {
        Veterinarian veterinarian = new Veterinarian("Иван",
                "Иванов",
                "1985-09-09",
                "8904555",
                "ветеринар");
        Mockito.when(veterinarianDao.readVeterinarian("Иванов")).thenReturn(veterinarian);
        assertEquals(veterinarian, veterinarianDao.readVeterinarian("Иванов"));
    }

    @Test
    void createVetCard() {
        VetCard vetCard = veterinarianService.createVetCard(12345,"2024-12-07",
                "кошачьи",
                "Муся",
                "Елена",
                "Вавилова","ветеринар",
                "Иванов",
                "-",
                "-");
                assertEquals(12345, vetCard.getCardNumber());
                assertEquals("2024-12-07", vetCard.getDate());
                assertEquals("кошачьи",vetCard.getSpecies());
                assertEquals("Муся",vetCard.getAnimalName());
                assertEquals("Елена", vetCard.getOwnerFirstName());
                assertEquals("Вавилова", vetCard.getOwnerLastName());
                assertEquals("ветеринар", vetCard.getVeterinarianPosition());
                assertEquals("Иванов", vetCard.getVeterinarianLastName());
                assertEquals("-", vetCard.getType());
                assertEquals("-", vetCard.getResult());
    }

    @Test
    void behave() {
        assertEquals("Идет осмотр....Питомец дрожит", veterinarianService.behave());
    }

    @Test
    void readVetCard() {
        VetCard vetCard = new VetCard(12345,"2024-12-07",
                "кошачьи",
                "Муся",
                "Елена",
                "Вавилова","ветеринар",
                "Иванов",
                "-",
                "-");
        Mockito.when(vetCardDao.readVetCard(12345)).thenReturn(vetCard);
        assertEquals(vetCard, veterinarianService.readVetCard(12345));

    }

    @Test
    void priem() {
        VetCard vetCard = new VetCard(12345,"2024-12-07",
                "кошачьи",
                "Муся",
                "Елена",
                "Вавилова","ветеринар",
                "Иванов",
                "осмотр",
                "здорова");
        Mockito.when(vetCardDao.readVetCard(12345)).thenReturn(vetCard);
        assertEquals(vetCard,veterinarianService.priem(12345, "здорова"));
    }

    @Test
    void priemVac() {
        VetCard vetCard = new VetCard(12345,"2024-12-07",
                "кошачьи",
                "Муся",
                "Елена",
                "Вавилова","ветеринар",
                "Иванов",
                "вакцинация",
                "Проведена вакцинация, вакцина: Вакцина");
        Mockito.when(vetCardDao.readVetCard(12345)).thenReturn(vetCard);
        assertEquals(vetCard,veterinarianService.priemVac(12345,"Вакцина"));
    }
}