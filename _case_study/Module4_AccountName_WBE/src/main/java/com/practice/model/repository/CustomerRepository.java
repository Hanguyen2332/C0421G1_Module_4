package com.practice.model.repository;

import com.practice.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // cẩn thận: - tên cột : giống trong database (vì SQL thuần)

    @Query(value = "SELECT id,`name`, `code`,address,day_of_birth, email, gender, id_card, phone,customer_type_type_id\n" +
            "FROM customer c\n" +
            "WHERE (?1 IS NULL OR c.name LIKE %?1% )\n" +
            "AND (?2 IS NULL OR customer_type_type_id = ?2)",

            countQuery = "SELECT id,`name`, `code`,address,day_of_birth, email, gender, id_card, phone,customer_type_type_id\n" +
                    "FROM customer c\n" +
                    "WHERE (?1 IS NULL OR c.name LIKE %?1% )\n" +
                    "AND (?2 IS NULL OR customer_type_type_id = ?2)",
            nativeQuery = true)
    Page<Customer> findAll(String name, Integer cusTypeId, Pageable pageable);

//    Page<Customer> findByNameContains(String name, Pageable pageable);
//
//    Page<Customer> findAllByCustomerTypeTypeNameContains(String cusType,Pageable pageable);
//
//    Page<Customer> findByNameContainsAndCustomerTypeTypeNameContains(String name, String cusType,Pageable pageable);
//
//    Page<Customer> findAllByCustomerTypeTypeName(String cusType,Pageable pageable);
//
//    Page<Customer> findByNameContainsAndCustomerTypeTypeName(String name, String cusType,Pageable pageable);

}
