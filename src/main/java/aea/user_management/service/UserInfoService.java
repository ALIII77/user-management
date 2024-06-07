package aea.user_management.service;

import aea.user_management.entity.UserInfo;
import aea.user_management.entity.dto.UserInfoDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public interface UserInfoService {

    UserInfo save(UserInfo userInfo);

    UserInfo save(UserInfoDto userInfoDto, Long id, String username, MultipartFile avatar);

    List<UserInfo> findAll();
    Optional<UserInfo> findById(Long id);
    void deleteById(Long id);
    UserInfo update(UserInfo userInfo);


}
