package com.example.bookYourShow.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequestDto {

    private String movieName;
    private int duration;
    private Date releaseDate;
}
