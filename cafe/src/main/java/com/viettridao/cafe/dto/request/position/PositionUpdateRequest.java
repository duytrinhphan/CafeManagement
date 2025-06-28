package com.viettridao.cafe.dto.request.position;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PositionUpdateRequest {

    private Integer id;

    private Double salary;

    private String positionName;

}
