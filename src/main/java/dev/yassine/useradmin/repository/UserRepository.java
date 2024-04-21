package dev.yassine.useradmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.yassine.useradmin.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
