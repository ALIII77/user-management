package aea.user_management.entity.dto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UsersDto {

    private String username;
    private String password;

}
