package iuh.fit.bai2.services;


import iuh.fit.bai2.entities.NhaCungCap;

import java.util.List;

public interface NhaCungCapService {

    List<NhaCungCap> getAll();

    NhaCungCap getNhaCungCapById(int id);
}
