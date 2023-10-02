package com.we8techi.platform.finance.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "roles")
public class Roles extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "details")
    private String details;

    @OneToMany(mappedBy = "role")
    private List<UserRoles> userRoles;

    @OneToMany(mappedBy = "role")
    private List<RolesPrivileges> rolesPrivileges;

}
