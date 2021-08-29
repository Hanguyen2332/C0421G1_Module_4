package com.codegym.model.repository;

import com.codegym.model.bean.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.*;

@Repository
@Transactional  // update/create/...
public class ProductReposImpl implements IProductRepos {
    @PersistenceContext  // --> framework tạo object cho EntityManager?
    private EntityManager em;

    //update or create:
    @Override
    public void save(Product product) {
        if (product.getId() != null && findById(product.getId()) != null) {  // check: row!= null (đối tượng đã tồn tại)
            em.merge(product);
        } else {
            em.persist(product);
        }
    }

    //select*
    @Override
    public List<Product> findAll() {
        //cau lenh query:
        String selectSql = "SELECT p FROM Product p";

        TypedQuery<Product> query = em.createQuery(selectSql, Product.class);

        return query.getResultList();
    }

    //ham bổ trợ:
    @Override
    public Product findById(Integer id) {
        return em.find(Product.class, id);
//        String selectSql = "SELECT p FROM Product AS p WHERE p.id=:id";
//        TypedQuery<Product> query = em.createQuery(selectSql, Product.class);
//        query.setParameter("id", id);

//     try{
//         return query.getSingleResult();
//     }catch (NoResultException e) {
//         return null;
//     }
    }

    //delete:
    @Override
    public void delete(Integer id) {
        Product product = findById(id);
        if (findById(id) != null) {
            em.remove(product);   // xóa - tham số: object
        }
    }

    @Override
    public List<Product> findByName(String nameChar) {
//        String selectSql = "SELECT p FROM Product AS p WHERE p.name=:name";
//        String selectSql = "SELECT p FROM Product AS p WHERE p.name= ?1";
//        String selectSql = "SELECT p FROM Product AS p WHERE p.name LIKE :name";

          String selectSql = "SELECT p FROM Product AS p WHERE p.name LIKE ?1";



        TypedQuery<Product> query = em.createQuery(selectSql, Product.class);
        try {
            query.setParameter(1, '%'+nameChar+'%');  //set giá trị cho biến
            return query.getResultList();
        } catch (NoResultException e) {   //NoResultException: khi KHÔNG có kết quả trả về
            return null;
        }
    }
}
