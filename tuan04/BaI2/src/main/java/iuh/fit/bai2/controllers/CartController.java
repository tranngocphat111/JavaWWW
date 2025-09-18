package iuh.fit.bai2.controllers;

import iuh.fit.bai2.daos.Impl.ProductDAOImpl;
import iuh.fit.bai2.daos.ProductDAO;
import iuh.fit.bai2.entities.ItemCart;
import iuh.fit.bai2.entities.Product;
import iuh.fit.bai2.utils.EntityManagerFactoryUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Fetch;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "cart", urlPatterns = {"/cart", "/cart*"})
public class CartController extends HttpServlet {
    private ProductDAO productDAO;


    @Override
    public void init(ServletConfig config) throws ServletException {
        productDAO = new ProductDAOImpl(EntityManagerFactoryUtil.getEntityManager());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("view/cart/index.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) action = "";

        switch (action) {
            case "add":
                handleAddProductToCart(req, resp);
                resp.sendRedirect(req.getContextPath() + "/products");
                break;
            case "increase":
                handleUpdateQuantity(req, resp, "increase");
                resp.sendRedirect(req.getContextPath() + "/cart");
                break;
            case "decrease":
                handleUpdateQuantity(req, resp, "decrease");
                resp.sendRedirect(req.getContextPath() + "/cart");
                break;
            case "delete":
                handleRemoveProduct(req, resp);
                resp.sendRedirect(req.getContextPath() + "/cart");
                break;

            default: {
                req.getRequestDispatcher("view/cart/index.jsp").forward(req, resp);
            }
        }
    }

    public boolean handleAddProductToCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        List<ItemCart> cartList = null;

        if (session.getAttribute("cart") == null) {
            cartList = new ArrayList<>();
        } else {
            cartList = (List<ItemCart>) session.getAttribute("cart");
        }

        int id = Integer.parseInt(req.getParameter("id"));

        int index = findProductIndex(id, cartList);

        if (index == -1) {
            cartList.add(new ItemCart(productDAO.getProductById(id), 1));
        } else {
            int quantity = cartList.get(index).getQuantity();
            cartList.get(index).setQuantity(quantity + 1);
        }

        session.setAttribute("cart", cartList);


        return false;
    }

    public int findProductIndex(int id, List<ItemCart> carts) {
        for (int i = 0; i < carts.size(); i++) {
            if (carts.get(i).getProduct().getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public boolean handleUpdateQuantity(HttpServletRequest req, HttpServletResponse resp, String option) {
        HttpSession session = req.getSession();
        List<ItemCart> cartList = (List<ItemCart>) session.getAttribute("cart");
        int index = findProductIndex(Integer.parseInt(req.getParameter("id")), cartList);
        ItemCart itemCart = cartList.get(index);

        if (option.equals("increase")) {
            itemCart.setQuantity(itemCart.getQuantity() + 1);
            session.setAttribute("cart", cartList);
            return true;
        }

        if (itemCart.getQuantity() == 1) {
            handleRemoveProduct(req, resp);
        }else {
            itemCart.setQuantity(itemCart.getQuantity() - 1);
        }
        session.setAttribute("cart", cartList);
        return false;

    }

    public boolean handleRemoveProduct(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        List<ItemCart> cartList = (List<ItemCart>) session.getAttribute("cart");
        int index = findProductIndex(Integer.parseInt(req.getParameter("id")), cartList);
        if (index == -1) return false;
        cartList.remove(index);
        return true;
    }
}

