package Exercice1Hibernate.dao;

import Exercice1Hibernate.entity.Product;
import org.hibernate.Session;

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
}
