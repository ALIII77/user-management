package aea.user_management.controller;

import aea.user_management.entity.UserInfo;
import aea.user_management.entity.dto.UserInfoDto;
import aea.user_management.exception.ResourceNotFoundException;
import aea.user_management.mapper.UserInfoMapper;
import aea.user_management.service.UserInfoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/userinfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/add")
    public ResponseEntity<UserInfo> createUserInfo(@RequestBody UserInfo userInfo) {
        UserInfo savedUserInfo = userInfoService.save(userInfo);
        return new ResponseEntity<>(savedUserInfo, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserInfo>> getAllUserInfo() {
        List<UserInfo> userInfos = userInfoService.findAll();
        return new ResponseEntity<>(userInfos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserInfo> getUserInfoById(@PathVariable Long id) {
        UserInfo userInfo = userInfoService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserInfo not found with id: " + id));
        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserInfo> updateUserInfo(@PathVariable Long id, @RequestBody UserInfo userInfoDetails) {
        userInfoDetails.setId(id);
        UserInfo updatedUserInfo = userInfoService.update(userInfoDetails);
        return new ResponseEntity<>(updatedUserInfo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserInfo(@PathVariable Long id) {
        userInfoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //-----------------------------------------------------



    @PostMapping("/add/{id}/{username}")
    public ResponseEntity<UserInfo> createUserInfo(
            @PathVariable Long id,
            @PathVariable String username,
            @RequestPart("userInfo") String userInfoString,
            @RequestPart("avatar") MultipartFile avatar) {
        try {
            UserInfoDto userInfoDto = objectMapper.readValue(userInfoString, UserInfoDto.class);
            UserInfo savedUserInfo = userInfoService.save(userInfoDto, id, username, avatar);
            return new ResponseEntity<>(savedUserInfo, HttpStatus.CREATED);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse UserInfoDto", e);
        }
    }

}
