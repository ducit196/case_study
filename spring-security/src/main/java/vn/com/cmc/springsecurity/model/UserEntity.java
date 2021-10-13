package vn.com.cmc.springsecurity.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "USER")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASS_WORD")
    private String passWord;

    @Column(name = "ACTIVE")
    private boolean active;

    @Column(name = "ROLES")
    private String roles;
}
