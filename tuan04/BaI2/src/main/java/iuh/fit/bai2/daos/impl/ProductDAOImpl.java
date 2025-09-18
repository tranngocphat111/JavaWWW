package iuh.fit.bai2.daos.Impl;

import iuh.fit.bai2.daos.ProductDAO;
import iuh.fit.bai2.entities.Product;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private EntityManager entityManager;

    public ProductDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Product> getAll(){
        try {
            return entityManager
                    .createQuery("SELECT p FROM Product p", Product.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;


    }

    @Override
    public Product getProductById(int id){
        try {
            return entityManager.find(Product.class, id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
