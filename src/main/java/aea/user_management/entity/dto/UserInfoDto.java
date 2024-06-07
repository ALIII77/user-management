package aea.user_management.entity.dto;


import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserInfoDto {

    private String firstName;
    private String lastName;
    private Long age;
    private Long nationalCode;
    private String email;
    private String description;
    private List<TelephoneDto> telephones;
    private List<AddressDto> addresses;
    private UsersDto user;



}
