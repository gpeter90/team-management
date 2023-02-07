package com.bredex.teammanagement.domain.security.repository;

import com.bredex.teammanagement.domain.security.entity.TeamManagementUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<TeamManagementUser, String> {
}
