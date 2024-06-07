package aea.user_management.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserInfo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String firstName;
    private String lastName;
    private Long  age;
    private Long  nationalCode;
    private String email;
    private String description;


    @OneToMany(mappedBy ="userInfo")
    private List<Telephone>telephones;

    @OneToMany(mappedBy = "userInfo")
    private List<Address> addresses;

    @OneToMany(mappedBy = "userInfo")
    private List<UserLink> userLinks;

    @Lob
    private byte[] avatar;


}
