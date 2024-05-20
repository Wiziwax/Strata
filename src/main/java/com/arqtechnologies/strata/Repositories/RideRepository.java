package com.arqtechnologies.strata.Repositories;

import com.arqtechnologies.strata.Entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RideRepository extends JpaRepository<Ride, String> {

    List<Ride> getAllByTravelPathAndCreatorRole(String travelPath, Integer role);

}
