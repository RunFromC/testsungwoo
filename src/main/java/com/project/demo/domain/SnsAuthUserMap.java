package com.project.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = "sns_auth_user_map")
public class SnsAuthUserMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sns_user_map_idx")
    private Integer idx;

    @Column(name = "user_idx")
    private Long userIdx;

    @Column(name = "auth_idx")
    private Integer authIdx;

}