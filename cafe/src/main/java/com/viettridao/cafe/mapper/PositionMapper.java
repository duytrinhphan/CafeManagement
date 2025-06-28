package com.viettridao.cafe.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.viettridao.cafe.dto.request.position.PositionCreateRequest;
import com.viettridao.cafe.dto.request.position.PositionUpdateRequest;
import com.viettridao.cafe.dto.response.position.PositionResponse;
import com.viettridao.cafe.model.PositionEntity;

@Mapper(componentModel = "spring")
public interface PositionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", constant = "false")
    @Mapping(target = "employees", ignore = true)
    PositionEntity toEntity(PositionCreateRequest request);

    PositionResponse toResponse(PositionEntity entity);

    PositionUpdateRequest toUpdateRequest(PositionEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    void updateFromRequest(PositionUpdateRequest request, @MappingTarget PositionEntity entity);
}
