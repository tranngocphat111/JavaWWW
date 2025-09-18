package iuh.fit.bai2.controllers;

import iuh.fit.bai2.daos.Impl.ProductDAOImpl;
import iuh.fit.bai2.daos.ProductDAO;
import iuh.fit.bai2.entities.Product;
import iuh.fit.bai2.utils.EntityManagerFactoryUtil;
import jakarta.persistence.EntityManager;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet( name = "products", urlPatterns = {"/products"})
public class ProductController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (EntityManager entityManager = EntityManagerFactoryUtil.getEntityManager()) {
            ProductDAO productDAO = new ProductDAOImpl(entityManager);
            List<Product> products = productDAO.getAll();
            req.setAttribute("products", products);
            req.getRequestDispatcher("view/product/index.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
