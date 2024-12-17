package ru.QA32.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.QA32.model.Owner;
import ru.QA32.model.Veterinarian;

import static org.junit.jupiter.api.Assertions.*;

class VeterinarianDaoTest {
    private VeterinarianDao veterinarianDao = new VeterinarianDao();
    @Test
    void saveAndReadVeterinarian() {
        Veterinarian veterinarian = new Veterinarian("Иван",
                "Иванов",
                "1985-09-09",
                "8904555",
                "ветеринар");
        veterinarianDao.saveVeterinarian(veterinarian);
        Veterinarian veterinarianAfterRead = veterinarianDao.readVeterinarian("Иванов");

            Assertions.assertEquals(veterinarian, veterinarianAfterRead);
        }
    }
