package com.runtastic.level1.repository;
import com.runtastic.level1.domain.GPS;


import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GPSRepository extends CrudRepository<GPS, Serializable> {

}
/*
public interface GPSRepository extends CrudRepository<GPS,Long>{
}*/
