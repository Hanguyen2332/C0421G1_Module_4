package com.practice.model.repository;
import com.practice.model.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service,Integer> {
    @Query("SELECT s FROM Service s WHERE s.serviceType.id = 1 OR  s.serviceType.id = 2" )
    List<Service> findAllHouSeAndVilla();
}
