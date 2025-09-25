package iuh.fit.tuan05.daos.Impl;

import iuh.fit.tuan05.daos.DienThoaiDAO;
import iuh.fit.tuan05.entities.DienThoai;
import iuh.fit.tuan05.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class DienThoaiDAOImpl implements DienThoaiDAO {
    private EntityManager entityManager;

    public DienThoaiDAOImpl(){
        entityManager = JPAUtil.getEntityManager();
    }

    @Override
    public List<DienThoai> getAll(){
        try {
            return entityManager.createQuery("select n from DienThoai n", DienThoai.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public DienThoai getDienThoaiById(int id){

        try {
            return entityManager.find(DienThoai.class,id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean add(DienThoai dienThoai){
        if(dienThoai == null) {
            return false;
        }

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(dienThoai);
        entityTransaction.commit();
        return true;
    }

    @Override
    public boolean remove(int id){
        DienThoai dienThoai = entityManager.find(DienThoai.class, id);
        if(dienThoai == null) {
            return false;
        }

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.remove(dienThoai);
        entityTransaction.commit();
        return true;
    }

    @Override
    public boolean update(DienThoai dienThoai){
        if(dienThoai == null) {
            return false;
        }

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(dienThoai);
        entityTransaction.commit();
        return true;
    }





}
