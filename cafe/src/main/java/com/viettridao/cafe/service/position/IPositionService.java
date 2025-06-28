package com.viettridao.cafe.service.position;

import java.util.List;

import com.viettridao.cafe.dto.request.position.PositionCreateRequest;
import com.viettridao.cafe.dto.request.position.PositionUpdateRequest;
import com.viettridao.cafe.dto.response.position.PositionResponse;
import com.viettridao.cafe.model.PositionEntity;

public interface IPositionService {

    List<PositionResponse> getPositionAll();

    PositionEntity getPositionById(Integer id);

    void createPosition(PositionCreateRequest request);

    PositionUpdateRequest getUpdateForm(Integer id);

    void updatePosition(Integer id, PositionUpdateRequest request);

    void deletePosition(Integer id);
}
