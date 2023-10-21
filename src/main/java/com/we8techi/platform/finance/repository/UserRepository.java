package com.we8techi.platform.finance.repository;

import com.we8techi.platform.finance.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @Query("from Users u where u.userName=:userName")
    Optional<Users> getByUserName(String userName);
}
