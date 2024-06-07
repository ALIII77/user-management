package aea.user_management.mapper;

import aea.user_management.entity.UserInfo;
import aea.user_management.entity.dto.UserInfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel ="spring")
public interface UserInfoMapper {

    UserInfoMapper INSTANCE = Mappers.getMapper(UserInfoMapper.class);


    @Mapping(target = "user", source = "user")
    @Mapping(target = "telephones", source = "telephones")
    @Mapping(target = "addresses", source = "addresses")
    UserInfo toEntity(UserInfoDto userInfoDto);




}
