package com.codegym.model.repository;

import com.codegym.model.bean.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.*;

@Repository
public class ProductReposImpl implements IProductRepos {
    @PersistenceContext  // --> framework tạo object cho EntityManager?
            EntityManager em;

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
        String selectSql = "SELECT p FROM Product AS p";

        TypedQuery<Product> query = ConnectionUtil.entityManager.createQuery(selectSql, Product.class);

        return query.getResultList();
    }

    //ham bổ trợ:
    @Override
    public Product findById(Integer id) {
        Product product = null;

        String selectSql = "SELECT p FROM Product AS p WHERE p.id=:id";
        TypedQuery<Product> query = ConnectionUtil.entityManager.createQuery(selectSql, Product.class);
        query.setParameter("id", id);
        product = query.getSingleResult();

        return  product;
    }

    //delete:
    @Override
    public void delete(Integer id) {
        if (id!=null) {
            em.remove(id);
        }
    }

    @Override
    public Product findByName(String nameChar) {
//        TypedQuery<Product> combinedQuery = queryBuilder
//                .bool().must(queryBuilder.phrase()
//                                .onField("productName).sentence("samsung galaxy s8")
//                                        .createQuery());
        String selectSql = "SELECT p FROM Product AS p WHERE p.name=:name";
        TypedQuery<Product> query = ConnectionUtil.entityManager.createQuery(selectSql, Product.class);


        return query.getSingleResult();
    }
}
