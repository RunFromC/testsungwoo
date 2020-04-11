package com.project.demo.domain;

import lombok.Getter;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@DynamicUpdate
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate
    @Column(name = "created", insertable = false, updatable = false,
            columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP(3)")
    private LocalDateTime created;

    @LastModifiedDate
    @Column(name = "updated", insertable = false,
            columnDefinition = "TIMESTAMP default NULL on update CURRENT_TIMESTAMP(3)")
    private LocalDateTime updated;
}