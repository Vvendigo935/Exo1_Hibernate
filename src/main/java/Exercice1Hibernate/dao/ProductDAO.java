package Exercice1Hibernate.dao;

import Exercice1Hibernate.entity.Product;
import Exercice1Hibernate.util.SessionFactorySingleton;
import org.hibernate.SessionFactory;

import javax.management.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
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
    public List<Product> getAllProductUnderTheStock (int stock){
        try{
            session = sessionFactory.openSession();
            TypedQuery<Product> query = session.createQuery("select p from Product p where p.stock <= :stock", Product.class);
            query.setParameter("stock",stock);
            return query.getResultList();
        }catch (Exception ex){
            return new ArrayList<>();
        }finally {
            session.close();
        }
    }

    public long getAllBrandValue(String brand){

        try{
            session = sessionFactory.openSession();
            TypedQuery<Product> query = session.createQuery("select SUM(price) as total from Product p where p.brand = :brand", Product.class);
            query.setParameter("brand",brand);
            return query.getFirstResult();
        }catch (Exception ex){
            return session.createQuery("select SUM(price) as totalForThisBrand from Product p WHERE p.brand = :brand", Long.class).getSingleResult();
        }finally {
            session.close();
        }

    }
    public double getAvgPrice(){

  //      return session.createQuery("select AVG(price) from Product p", Double.class).getSingleResult();
        try{
            session = sessionFactory.openSession();
            TypedQuery<Product> query = session.createQuery("select AVG(price) from Product p", Product.class);

            return query.getFirstResult();
        }catch (Exception ex){
            return session.createQuery("select AVG(price) from Product p", Double.class).getSingleResult();
        }finally {
            session.close();
        }

    }



}
