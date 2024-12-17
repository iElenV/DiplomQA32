package ru.QA32.dao;

import ru.QA32.model.VetCard;

import java.util.HashMap;
import java.util.Map;

public class VetCardDao {
    private Map<Integer, VetCard> vetCards = new HashMap<>();

    public void saveVetCard(VetCard vetCard) {
        vetCards.put(vetCard.getCardNumber(), vetCard);
    }

    public VetCard readVetCard (int cardNumber) {
        return vetCards.get(cardNumber);
    }
}
