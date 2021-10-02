package com.practice.model.repository;

import com.practice.model.entity.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IEduDegreeRepository extends JpaRepository<EducationDegree,Integer> {

}
