package com.project.demo.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = "sns_authorization_data")
public class SnsAuthorizationData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auth_idx")
    private Integer idx;

    @Column(name = "sns_platform_idx")
    private Integer snsPlatformIdx;

    @Column(name = "platform_supplied_unique_id")
    private String platformSuppliedUniqueId;

    @Column(name = "platform_supplied_nickname")
    private String platformSuppliedUniqueNickname;

    @Column(name = "platform_supplied_profile_image")
    private String platformSuppliedProfileImage;

}
