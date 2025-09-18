package iuh.fit.bai1.daos;

import iuh.fit.bai1.entities.Account;

import java.util.List;

public interface AccountDAO {
    List<Account> findAll();
    boolean addAccount(Account account);
}
