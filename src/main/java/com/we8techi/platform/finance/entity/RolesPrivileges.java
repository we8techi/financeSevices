package com.we8techi.platform.finance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "roles_privileges")
public class RolesPrivileges implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roles_id", referencedColumnName = "id", nullable = false)
    private Roles role;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "privileges_id", referencedColumnName = "id", nullable = false)
    private Privilege privilege;
}
