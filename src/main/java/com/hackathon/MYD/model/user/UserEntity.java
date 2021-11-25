package com.hackathon.MYD.model.user;

import lombok.*;
import javax.persistence.*;

/**
 * @author 이종은
 */
@Builder
@Getter
@Table(name = "user")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserEntity {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String nickname;
    private String password;
}
