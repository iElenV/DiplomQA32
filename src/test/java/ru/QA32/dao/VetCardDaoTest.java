package ru.QA32.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.QA32.model.Owner;
import ru.QA32.model.VetCard;

import static org.junit.jupiter.api.Assertions.*;

class VetCardDaoTest {
    private VetCardDao vetCardDao = new VetCardDao();

    @Test
    void saveAndRaedVetCard() {
        VetCard vetCard = new VetCard(12345,"2024-12-07",
                "кошачьи",
                "Муся",
                "Елена",
                "Вавилова","ветеринар",
                "Иванов",
                "-",
                "-");
        vetCardDao.saveVetCard(vetCard);
        VetCard vetCardAfterRead = vetCardDao.readVetCard(12345);

        Assertions.assertEquals(vetCard, vetCardAfterRead);
    }

}