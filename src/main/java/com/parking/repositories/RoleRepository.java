package com.parking.repositories;

import com.parking.models.security.constant.ERoleName;
import com.parking.models.security.utils.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByRoleName(ERoleName roleName);

}
