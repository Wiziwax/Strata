package com.arqtechnologies.strata.Repositories;

import com.arqtechnologies.strata.Entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface DriverRepository extends JpaRepository<Driver, Integer> {

    //TODO CHANGE TO PAGEABLE
    List<Driver> getAllByIsAvailable(Boolean isAvailable);
    List<Driver> getAllByDes();
}
