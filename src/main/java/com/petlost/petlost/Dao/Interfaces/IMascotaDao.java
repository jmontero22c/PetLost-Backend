package com.petlost.petlost.Dao.Interfaces;

import com.petlost.petlost.Models.Mascota;
import java.util.List;

public interface IMascotaDao {
    public List<Mascota> getPet();
    public String createPet(Mascota pet);
    public String deletePet(Long id);
}