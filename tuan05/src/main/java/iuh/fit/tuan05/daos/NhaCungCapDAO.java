package iuh.fit.tuan05.daos;

import iuh.fit.tuan05.entities.NhaCungCap;
import jakarta.persistence.EntityManager;

import java.util.List;

public interface NhaCungCapDAO {

    List<NhaCungCap> getAll();

    NhaCungCap getNhaCungCapById(int id);
}
