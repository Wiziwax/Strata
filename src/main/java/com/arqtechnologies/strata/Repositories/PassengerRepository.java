package com.arqtechnologies.strata.Repositories;

import com.arqtechnologies.strata.Entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
}
