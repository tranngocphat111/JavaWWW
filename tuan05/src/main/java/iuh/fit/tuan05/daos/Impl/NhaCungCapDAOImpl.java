package iuh.fit.tuan05.daos.Impl;

import iuh.fit.tuan05.daos.NhaCungCapDAO;
import iuh.fit.tuan05.entities.NhaCungCap;
import iuh.fit.tuan05.utils.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class NhaCungCapDAOImpl implements NhaCungCapDAO {
    private EntityManager entityManager;

    public NhaCungCapDAOImpl(){
        entityManager = JPAUtil.getEntityManager();
    }

    @Override
    public List<NhaCungCap> getAll(){
        try {
            return entityManager.createQuery("select n from NhaCungCap n", NhaCungCap.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public NhaCungCap getNhaCungCapById(int id){

        try {
            return entityManager.find(NhaCungCap.class,id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
