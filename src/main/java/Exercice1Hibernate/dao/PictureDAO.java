package Exercice1Hibernate.dao;

import Exercice1Hibernate.entity.Picture;
import Exercice1Hibernate.util.SessionFactorySingleton;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class PictureDAO extends BaseDAO<Picture> {

    public PictureDAO() {
        super(SessionFactorySingleton.getSessionFactory(), Picture.class);
    }

    @Override
    public List<Picture> get() {
        try {
            session = sessionFactory.openSession();
            return session.createQuery("select p from Picture p", Picture.class).getResultList();
        } catch (Exception ex) {
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }



}