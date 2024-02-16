package com.arqtechnologies.strata.Repositories;

import com.arqtechnologies.strata.Entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<Ride, Integer> {

}
