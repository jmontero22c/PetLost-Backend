package com.petlost.petlost.Dao.Interfaces;

import com.petlost.petlost.Models.Mascota;
import com.petlost.petlost.Models.Usuario;

import java.util.List;

public interface IMascotaDao {
    public List<Mascota> getPet();
    public String createPet(Mascota pet);
    public String deletePet(Long id);
    public List<Mascota> getPetsxPerson(Usuario user);
    public List<Mascota> getPetsByKind(Long id);
}
