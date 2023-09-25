package com.we8techi.platform.finance.entity;

import javax.persistence.*;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Users extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String userName;

    @Column(name = "pwd")
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserRoles> userRoles;

    @OneToOne(fetch = FetchType.EAGER)
    private CompanyDetails company;

}
