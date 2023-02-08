package com.bredex.teammanagement.rest.security.repository;

import com.bredex.teammanagement.rest.security.entity.TeamManagementUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<TeamManagementUser, String> {
}
