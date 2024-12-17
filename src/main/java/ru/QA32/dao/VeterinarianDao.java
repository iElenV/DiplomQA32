package ru.QA32.dao;

import ru.QA32.model.Veterinarian;

import java.util.HashMap;
import java.util.Map;

public class VeterinarianDao {
    private Map<String, Veterinarian> veterinarians = new HashMap<>();

    public void saveVeterinarian(Veterinarian veterinarian) {
        veterinarians.put(veterinarian.getLastName(), veterinarian);
    }

    public Veterinarian readVeterinarian (String lastName) {
        return veterinarians.get(lastName);
    }
}
