package iuh.fit.bai2.services.impl;

import iuh.fit.bai2.entities.NhaCungCap;
import iuh.fit.bai2.repositories.NhaCungCapRepository;
import iuh.fit.bai2.services.NhaCungCapService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhaCungCapServiceImpl implements NhaCungCapService {
    private NhaCungCapRepository nhaCungCapRepository;

    public  NhaCungCapServiceImpl(NhaCungCapRepository nhaCungCapRepository){
        this.nhaCungCapRepository = nhaCungCapRepository;
    }
    @Override
    public List<NhaCungCap> getAll() {
        return nhaCungCapRepository.findAll();
    }

    @Override
    public NhaCungCap getNhaCungCapById(int id) {
        return nhaCungCapRepository.findById(id).orElse(null);
    }
}
