package com.example.bookYourShow.Dtos;

import lombok.Data;

import java.util.List;

@Data
public class TicketRequestDto {
    private List<String> RequestedSeat;
    private int userId;
    private int showId;
}
