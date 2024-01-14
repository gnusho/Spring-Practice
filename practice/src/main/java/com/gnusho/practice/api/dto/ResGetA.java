package com.gnusho.practice.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResGetA {
    private Long pkA;
    private String stringA;
    private LocalDate dateA;
}
