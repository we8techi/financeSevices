package com.we8techi.platform.finance.repository;

import com.we8techi.platform.finance.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    @Query(value = "select p.* from financedb.users u inner join financedb.user_roles ur on u.id = ur.users_id \n" +
            "inner join financedb.roles r on ur.role_id = r.id inner join financedb.roles_privileges rp on r.id = rp.roles_id  \n" +
            "inner join financedb.privilege p on rp.privileges_id  = p.id  and u.email = :email", nativeQuery = true)
    List<Privilege> getPrivilegeByEmail(@Param("email") String email);
}
