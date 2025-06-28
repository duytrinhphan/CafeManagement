package com.viettridao.cafe.dto.request.employee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeCreateRequest {

    private String fullName;

    private String phoneNumber;

    private String address;

    private Integer accountId;

    private Integer positionId;

    private Double salary;

}
