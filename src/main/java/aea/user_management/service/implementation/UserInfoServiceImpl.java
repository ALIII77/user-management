package aea.user_management.service.implementation;


import aea.user_management.entity.UserInfo;
import aea.user_management.entity.dto.UserInfoDto;
import aea.user_management.mapper.UserInfoMapper;
import aea.user_management.repository.UserInfoRepository;
import aea.user_management.service.UserInfoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo save(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

    @Override
    public UserInfo save(UserInfoDto userInfoDto, Long id, String username, MultipartFile avatar) {
        UserInfo userInfo = UserInfoMapper.INSTANCE.toEntity(userInfoDto);
        userInfo.setId(id);
        userInfo.setUsername(username);

        try {
            byte[] avatarBytes = avatar.getBytes();
            userInfo.setAvatar(avatarBytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return userInfoRepository.save(userInfo);
    }
    @Override
    public List<UserInfo> findAll() {
        return userInfoRepository.findAll();
    }

    @Override
    public Optional<UserInfo> findById(Long id) {
        return userInfoRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        userInfoRepository.deleteById(id);
    }

    @Override
    public UserInfo update(UserInfo userInfo) {
        if (userInfo.getId() == null || !userInfoRepository.existsById(userInfo.getId())) {
            throw new IllegalArgumentException("UserInfo not found");
        }
        return userInfoRepository.save(userInfo);
    }
}