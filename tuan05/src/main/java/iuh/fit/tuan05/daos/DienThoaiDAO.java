package iuh.fit.tuan05.daos;

import iuh.fit.tuan05.entities.DienThoai;

import java.util.List;

public interface DienThoaiDAO {
    List<DienThoai> getAll();

    DienThoai getDienThoaiById(int id);

    boolean add(DienThoai dienThoai);

    boolean remove(int id);

    boolean update(DienThoai dienThoai);
}
