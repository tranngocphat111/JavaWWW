package iuh.fit.bai2.daos;

import iuh.fit.bai2.entities.Product;

import java.util.List;

public interface ProductDAO {
    public List<Product> getAll();
    public Product getProductById(int id);
}
