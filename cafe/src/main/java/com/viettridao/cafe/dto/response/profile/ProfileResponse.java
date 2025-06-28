package com.viettridao.cafe.dto.response.profile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileResponse {

    private Integer id;
    private String fullName;
    private String phoneNumber;
    private String address;
    private String positionName;
    private Double salary;
    private String username;
    private String imageUrl;

}
