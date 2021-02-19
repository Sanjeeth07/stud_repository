package com.student.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.student.entity.EMP_DETAILS;

@Repository
public interface EMP_REPOSITORY  extends CrudRepository<EMP_DETAILS, Integer>{

}
