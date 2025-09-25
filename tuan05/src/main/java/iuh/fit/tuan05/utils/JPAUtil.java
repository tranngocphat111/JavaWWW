package iuh.fit.tuan05.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory entityManagerFactory;

    static {
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("default");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static EntityManager getEntityManager(){
        try {
            return entityManagerFactory.createEntityManager();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        getEntityManager();
    }



}
