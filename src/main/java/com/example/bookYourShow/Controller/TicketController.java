package com.example.bookYourShow.Controller;

import com.example.bookYourShow.Dtos.TicketRequestDto;
import com.example.bookYourShow.Repository.TicketRepository;
import com.example.bookYourShow.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;
    @Autowired
    private TicketRepository ticketRepository;

    @PostMapping("/add")
    public String  bookTicket(@RequestBody TicketRequestDto ticketRequestDto){
       try{
           return ticketService.bookTicket(ticketRequestDto);
       }catch(Exception e){
           return "Not enough seat is available";
       }
    }
}
