package Exercice1Hibernate.dao;

import Exercice1Hibernate.entity.Comment;
import Exercice1Hibernate.util.SessionFactorySingleton;

import java.util.ArrayList;
import java.util.List;

public class CommentDAO extends BaseDAO<Comment> {

    public CommentDAO() {
        super(SessionFactorySingleton.getSessionFactory(), Comment.class);
    }

    @Override
    public List<Comment> get() {
        try {
            session = sessionFactory.openSession();
            return session.createQuery("select p from Comment p", Comment.class).getResultList();
        } catch (Exception ex) {
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }
}