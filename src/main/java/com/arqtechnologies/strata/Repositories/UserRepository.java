package com.arqtechnologies.strata.Repositories;

import com.arqtechnologies.strata.Entities.User;
import com.arqtechnologies.strata.Enums.EnumRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    Page<User> getUserByUserRole(EnumRole enumRole, Pageable pageable);
}
