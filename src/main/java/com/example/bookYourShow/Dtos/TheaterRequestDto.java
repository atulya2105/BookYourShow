package com.example.bookYourShow.Dtos;

//import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheaterRequestDto {
    @Column(unique = true,nullable = false)
    private String name;
    private String city;
    private String address;
}
