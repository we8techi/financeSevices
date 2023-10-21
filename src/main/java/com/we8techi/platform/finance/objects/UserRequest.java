package com.we8techi.platform.finance.objects;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

    private String userName;
    private String password;
    private String email;
    private Long companyId;
    private Long roleId;
}
