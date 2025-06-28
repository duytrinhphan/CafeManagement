package com.viettridao.cafe.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


import com.viettridao.cafe.dto.request.account.AccountCreateRequest;
import com.viettridao.cafe.dto.request.account.AccountUpdateRequest;
import com.viettridao.cafe.dto.response.account.AccountResponse;
import com.viettridao.cafe.model.AccountEntity;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", constant = "false")
    @Mapping(target = "employee", ignore = true)
    @Mapping(target = "expenses", ignore = true)
    AccountEntity toEntity(AccountCreateRequest request);


    AccountResponse toResponse(AccountEntity entity);

    AccountUpdateRequest toUpdateRequest(AccountEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    void updateEntityFromRequest(AccountUpdateRequest request, @MappingTarget AccountEntity entity);
}
