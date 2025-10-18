package iuh.fit.bai2.services;


import iuh.fit.bai2.entities.DienThoai;

import java.util.List;

public interface DienThoaiService {
    List<DienThoai> getAll();

    DienThoai getDienThoaiById(int id);

    void add(DienThoai dienThoai);

    void remove(int id);

    void update(DienThoai dienThoai);
}
