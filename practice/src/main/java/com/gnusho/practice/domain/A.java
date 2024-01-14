package com.gnusho.practice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;

@Entity
@Table(name = "a")
@NoArgsConstructor
@Getter
@DynamicInsert
@DynamicUpdate
public class A {

    @Id
    @Column(name = "pka")
    private Long pkA;

    @Column(name = "stringa")
    private String stringA;

    @Column(name = "datea")
    private LocalDate dateA;

    @Builder
    public A(Long pkA, String stringA, LocalDate dateA) {
        this.pkA = pkA;
        this.stringA = stringA;
        this.dateA = dateA;
    }

    public void updateA(String stringA, LocalDate dateA) {
        this.stringA = stringA;
        this.dateA = dateA;
    }
}
