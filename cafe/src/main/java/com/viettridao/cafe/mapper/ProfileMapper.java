package com.viettridao.cafe.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.viettridao.cafe.dto.response.profile.ProfileResponse;
import com.viettridao.cafe.model.AccountEntity;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

    @Mapping(source = "account.username", target = "username")
    @Mapping(source = "account.imageUrl", target = "imageUrl")
    @Mapping(source = "account.employee.fullName", target = "fullName")
    @Mapping(source = "account.employee.phoneNumber", target = "phoneNumber")
    @Mapping(source = "account.employee.address", target = "address")
    @Mapping(source = "account.employee.position.positionName", target = "positionName")
    @Mapping(source = "account.employee.position.salary", target = "salary")
    ProfileResponse toProfile(AccountEntity account);
}
