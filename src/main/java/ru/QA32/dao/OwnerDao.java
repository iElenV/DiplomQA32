package ru.QA32.dao;

import ru.QA32.model.Owner;

import java.util.HashMap;
import java.util.Map;

public class OwnerDao {
    private Map<String, Owner> owners = new HashMap<>();

    public void saveOwner(Owner owner) {
        owners.put(owner.getLastName(), owner);
    }

    public Owner readOwner (String lastName) {
        return owners.get(lastName);
    }
}
