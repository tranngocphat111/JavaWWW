package iuh.fit.bai1.daos.impl;

import iuh.fit.bai1.daos.AccountDAO;
import iuh.fit.bai1.entities.Account;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {
    private final DataSource datasource;

    public AccountDAOImpl(DataSource datasource) {
        this.datasource = datasource;
    }

    @Override
    public List<Account> findAll() {
        String sql = "SELECT firstName,lastName,email, password,dayOfBirth,gender FROM Account";
        List<Account> list = new ArrayList<>();
        try (
                Connection con = (Connection) this.datasource.getConnection();
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");
                String password = rs.getString("password");
                Date dob = rs.getDate("dayOfBirth");
                String gender = rs.getString("gender");
                list.add(new Account(firstName, lastName, email, password, dob, gender));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean addAccount(Account account) {
        String sql = "" +
                "INSERT INTO Account values (?,?,?,?,?,?)";
        try (
                Connection con = (Connection) this.datasource.getConnection();
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
        ) {
            ps.setString(1, account.getFirstName());
            ps.setString(2, account.getLastName());
            ps.setString(3, account.getEmail());
            ps.setString(4, account.getPassword());
            ps.setDate(5, new java.sql.Date(account.getDob().getTime()));

            ps.setString(6, account.getGender());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }
}
