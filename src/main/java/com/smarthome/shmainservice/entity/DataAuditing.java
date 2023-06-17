package com.smarthome.shmainservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.time.Instant;

@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"create", "update"}, allowGetters = true)
public interface DataAuditing extends Serializable {

    @CreatedDate
    @JoinColumn(nullable = false, updatable = false)
    Instant created = null;

    @LastModifiedDate
    @JoinColumn (nullable = false, updatable = true)
    Instant updated = null;


}
