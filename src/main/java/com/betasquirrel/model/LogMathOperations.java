package com.betasquirrel.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Entity
@Table(name = "logmathoperations")
public class LogMathOperations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "userid")
    @NotNull
    private Integer userid;

    @Column(name = "email")
    private String email;

    @Column(name = "operation")
    @NotNull
    private String operation;

    @Column(name = "created_at")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Calendar createdAt;

    public LogMathOperations() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) { this.userid = userid; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
