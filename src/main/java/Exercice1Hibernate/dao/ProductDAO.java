package Exercice1Hibernate.dao;

import Exercice1Hibernate.entity.Product;
import Exercice1Hibernate.util.SessionFactorySingleton;
import org.hibernate.SessionFactory;

import javax.management.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends BaseDAO<Product> {

    public ProductDAO() {
        super(SessionFactorySingleton.getSessionFactory(), Product.class);
    }

    @Override
    public List<Product> get() {
        try{
            session = sessionFactory.openSession();
            return session.createQuery("select p from Product p", Product.class).getResultList();
        }catch (Exception ex){
            return new ArrayList<>();
        }finally {
            session.close();
        }
    }

    public List<Product> getAllProductOverThePrice (double price){
        try{
            session = sessionFactory.openSession();
            TypedQuery<Product> query = session.createQuery("select p from Product p where p.price >= :price", Product.class);
            query.setParameter("price",price);
            return query.getResultList();
        }catch (Exception ex){
            return new ArrayList<>();
        }finally {
            session.close();
        }
    }

    public List<Product> getAllProductBetween2Date (LocalDate start , LocalDate end){
        try{
            session = sessionFactory.openSession();
            TypedQuery<Product> query = session.createQuery("select p from Product p where p.purchaseDate between :start and :end", Product.class);
            query.setParameter("start",start);
            query.setParameter("end",end);
            return query.getResultList();
        }catch (Exception ex){
            return new ArrayList<>();
        }finally {
            session.close();
        }
    }
}
