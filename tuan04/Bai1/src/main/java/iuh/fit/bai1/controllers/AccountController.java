package iuh.fit.bai1.controllers;

import iuh.fit.bai1.daos.AccountDAO;
import iuh.fit.bai1.daos.impl.AccountDAOImpl;
import iuh.fit.bai1.entities.Account;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/accounts")
public class AccountController extends HttpServlet {
    @Resource(name = "jdbc/user")
    private DataSource dataSource;
    private AccountDAO accountDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.accountDAO = new AccountDAOImpl(dataSource);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Account account= null;

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String password = req.getParameter("password");
        String dobStr = req.getParameter("dob");
        Date dob =  Date.valueOf(dobStr);


        account = new Account(firstName,lastName,email,password,dob,gender);

        if(accountDAO.addAccount(account)){
            System.out.println("Thêm thành công");
        }else {
            System.out.println("Thêm thất bại!!!");
        }
        List<Account> list = accountDAO.findAll();
        req.setAttribute("accounts", list);
        req.getRequestDispatcher("views/accounts.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/accounts.jsp").forward(req,resp);
    }
}
