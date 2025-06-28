package com.viettridao.cafe.dto.request.account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountUpdateRequest {

    private Integer id;

    private String username;

    private String password;

    private String permission;

    private String imageUrl;

}
