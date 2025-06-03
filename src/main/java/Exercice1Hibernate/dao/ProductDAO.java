package Exercice1Hibernate.dao;

import Exercice1Hibernate.entity.Product;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class ProductDAO {

private Session session;

    public ProductDAO(Session session) {
        this.session = session;
    }

    public Product save (Product product){

        session.getTransaction().begin();
        session.saveOrUpdate(product);
        session.getTransaction().commit();
        return product;
    }

    public boolean delete (Product product){
        session.getTransaction().begin();
        session.delete(product);
        session.getTransaction().commit();
        return true;
    }
    public Product get (int id){
        return session.get(Product.class, id);
    }

        public List<Product> getAllProduct (){
        return session.createQuery("select p from Product p", Product.class).getResultList();
    }

    public List<Product> getPriceOver100 (){
        TypedQuery<Product> query = session.createQuery("select p from Product p where p.price > 100", Product.class);

        return query.getResultList();
    }

    public List<Product> getPriceOver (){

    Scanner scanner = new Scanner(System.in);
        System.out.println("Afficher les prix au dessus de ");
    double lookedPrice = scanner.nextDouble();
        TypedQuery<Product> query = session.createQuery("select p from Product p where p.price < '?'", Product.class);
        query.setParameter(1,lookedPrice); // il ne trouve pas, il doit me manquer quelque chose
        return query.getResultList();
    }

    public List<Product> getDatebtw (){
        TypedQuery<Product> query = session.createQuery("select p from Product p where p.buyDate BETWEEN 1900-01-01 AND 2024-01-01", Product.class);
        return query.getResultList();
        // 1900 et 2024 mais j'ai eu des soucis avec la date tmtc
    }

}
