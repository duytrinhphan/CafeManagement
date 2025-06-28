package com.viettridao.cafe.dto.response.employee;

import lombok.Getter;
import lombok.Setter;

import com.viettridao.cafe.dto.response.position.PositionResponse;

@Getter
@Setter
public class EmployeeResponse {

    private Integer id;

    private String fullName;

    private String phoneNumber;

    private String address;

    private Boolean deleted;

    private PositionResponse position;

}
