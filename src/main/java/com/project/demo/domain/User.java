package com.project.demo.domain;


import com.project.demo.domain.converter.StringCryptoConverter;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Slf4j
@Table(name = "user")
@DynamicUpdate
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_idx")
    private Long idx;

    @Column(name = "id")
    private String id;

    @ToString.Exclude
    @Convert(converter = StringCryptoConverter.class)
    private String pw;

    @Column(name = "email")
    private String email;

    @Column(name = "cert_idx")
    private Long certIdx;

    @Column(name = "recent_date")
    private LocalDateTime recentDate;

    @Column(name = "exit_date")
    private LocalDateTime exitDate;

    @Column(name = "isExit")
    private Boolean isExit;

    public Boolean matchesPassword (String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password, pw);
    }
}
