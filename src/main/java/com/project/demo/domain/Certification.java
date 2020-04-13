package com.project.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "certification")
public class Certification extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cert_idx")
    private Long idx;
    private String name;
    private String gender;
    @Column(name = "phone_corp")
    private String phoneCorp;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "is_nation")
    private Boolean isNation;
    @Column(name = "is_minor")
    private Boolean isMinor;
    private String birthday;
    private String address;
    private String zipcode;
    private Boolean certified;


    @Builder
    public Certification(Long idx, String name, String gender, String phoneCorp, String phoneNumber, Boolean isNation, Boolean isMinor, String birthday, String address, String zipcode, Boolean certified) {
        this.idx = idx;
        this.name = name;
        this.gender = gender;
        this.phoneCorp = phoneCorp;
        this.phoneNumber = phoneNumber;
        this.isNation = isNation;
        this.isMinor = isMinor;
        this.birthday = birthday;
        this.address = address;
        this.zipcode = zipcode;
        this.certified = certified;
    }

    @Override
    public String toString() {
        return "Certification{" +
                "idx=" + idx +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneCorp='" + phoneCorp + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", isNation=" + isNation +
                ", isMinor=" + isMinor +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", certified=" + certified +
                '}';
    }
}
