package fit.iuh.edu.vn.ongk.config;

import java.io.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            EntityManager entityManager = Persistence.createEntityManagerFactory("ongk").createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityTransaction.commit();
            System.out.println("ok");
        }catch (Exception exception){
            System.out.println("not ok");
        }
    }

    public void destroy() {
    }
}