package com.viettridao.cafe.mapper;

import org.mapstruct.*;

import com.viettridao.cafe.dto.request.employee.EmployeeCreateRequest;
import com.viettridao.cafe.dto.request.employee.EmployeeUpdateRequest;
import com.viettridao.cafe.dto.response.employee.EmployeeResponse;
import com.viettridao.cafe.model.AccountEntity;
import com.viettridao.cafe.model.EmployeeEntity;
import com.viettridao.cafe.model.PositionEntity;
import com.viettridao.cafe.service.position.IPositionService;

@Mapper(componentModel = "spring", uses = {AccountMapper.class})
public interface EmployeeMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", constant = "false")
    @Mapping(target = "account", source = "accountId", qualifiedByName = "mapAccountId")
    @Mapping(target = "position", source = "positionId", qualifiedByName = "mapPositionId")
    EmployeeEntity toEntity(EmployeeCreateRequest request, @Context IPositionService positionService);

    EmployeeResponse toResponse(EmployeeEntity entity);

    EmployeeUpdateRequest toUpdateRequest(EmployeeEntity entity);

    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "deleted", ignore = true)
    void updateEntityFromRequest(EmployeeUpdateRequest request, @MappingTarget EmployeeEntity entity);

    @Named("mapAccountId")
    default AccountEntity mapAccountId(Integer accountId) {
        if (accountId == null) return null;
        AccountEntity account = new AccountEntity();
        account.setId(accountId);
        return account;
    }

    @Named("mapPositionId")
    default PositionEntity mapPositionId(Integer positionId, @Context IPositionService positionService) {
        if (positionId == null) return null;
        return positionService.getPositionById(positionId);
    }

}
