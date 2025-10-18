package iuh.fit.bai2.services.impl;

import iuh.fit.bai2.entities.DienThoai;
import iuh.fit.bai2.repositories.DienThoaiRepository;
import iuh.fit.bai2.services.DienThoaiService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DienThoaiServiceImpl implements DienThoaiService {

    private DienThoaiRepository dienThoaiRepository;

    public DienThoaiServiceImpl(DienThoaiRepository repository){
        dienThoaiRepository = repository;
    }

    @Override
    public List<DienThoai> getAll() {
        return dienThoaiRepository.findAll();
    }

    @Override
    public DienThoai getDienThoaiById(int id) {
        return dienThoaiRepository.findById(id).orElse(null);
    }

    @Override
    public void add(DienThoai dienThoai) {
        dienThoaiRepository.save(dienThoai);
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public void update(DienThoai dienThoai) {
        dienThoaiRepository.save(dienThoai);

    }
}
