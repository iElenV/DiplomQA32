package ru.QA32.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.QA32.model.Owner;

import static org.junit.jupiter.api.Assertions.*;

class OwnerDaoTest {

    private OwnerDao ownerDao = new OwnerDao();
    @Test
    void saveAndReadOwner() {
        Owner owner = new Owner("Lena", "Familia", "1986", "+799999999", null);
        ownerDao.saveOwner(owner);
        Owner owner2 = new Owner("Sveta", "Familia", "1986", "+799999999", null);
        ownerDao.saveOwner(owner);
        ownerDao.saveOwner(owner2);
        Owner ownerAfterRead = ownerDao.readOwner("Familia");

        Assertions.assertEquals(owner2, ownerAfterRead);
    }
}