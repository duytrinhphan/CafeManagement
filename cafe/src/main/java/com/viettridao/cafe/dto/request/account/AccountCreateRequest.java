package com.viettridao.cafe.dto.request.account;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountCreateRequest {

    private Integer id;

    private String fullName;

    private String phoneNumber;

    private String address;

    private String imageUrl;

    private Integer positionId;

    private String positionName;

    private Double salary;

    private String username;

    private String password;


}
