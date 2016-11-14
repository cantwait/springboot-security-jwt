package com.svlada.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.svlada.entity.UserRole;
import com.svlada.entity.UserRole.Id;

public interface UserRoleRepository extends JpaRepository<UserRole, Id>{

}
