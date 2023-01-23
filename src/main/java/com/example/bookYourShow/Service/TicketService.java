package com.example.bookYourShow.Service;

import com.example.bookYourShow.Dtos.TicketRequestDto;
import com.example.bookYourShow.Dtos.UserRequestDto;
import com.example.bookYourShow.Modals.*;
import com.example.bookYourShow.Repository.MovieRepository;
import com.example.bookYourShow.Repository.ShowRepository;
import com.example.bookYourShow.Repository.TicketRepository;
import com.example.bookYourShow.Repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
@Service
public class TicketService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ShowRepository showRepository;

    @Autowired
    TicketRepository ticketRepository;
    public String bookTicket(TicketRequestDto ticketRequestDto)  {
        List<String> requestSeat = ticketRequestDto.getRequestedSeat();
        UserEntity userEntity = userRepository.findById(ticketRequestDto.getUserId()).get();
        ShowEntity showEntity = showRepository.findById(ticketRequestDto.getShowId()).get();



        for(String seat : requestSeat){
            System.out.println(seat +" -->");
        }

//        ticketEntity.setUser(userEntity);
//        ticketEntity.setShow(showEntity);

        //get the list from the show
        List<ShowSeatEntity> seatEntityList = showEntity.getListOfSeats();
        List<ShowSeatEntity> bookedSeat = new ArrayList<>();
        for (ShowSeatEntity seat : seatEntityList){
            String seatNo = seat.getSeatNo();
            System.out.println(seatNo+" --->");
            if(seat.isBooked()==false && requestSeat.contains(seatNo)){
                bookedSeat.add(seat);
            }
        }



        if(requestSeat.size() != bookedSeat.size()){
            return "Enough seat is not available";
        }



        TicketEntity ticketEntity = new TicketEntity();
        double totalAmount = 0;
        double multiplier = showEntity.getMultiplier();
        String allocatedSeat = "";
        for(ShowSeatEntity seat : bookedSeat){
            seat.setBookedAt(new Date());
            seat.setTicket(ticketEntity);
            seat.setBooked(true);
            seat.setShow(showEntity);


            String seatNo = seat.getSeatNo();
            allocatedSeat = allocatedSeat + seatNo + ",";
            int rate = 0;
            if(seatNo.charAt(0)=='1'){
                rate = 100;
            }else{
                rate = 200;
            }

            totalAmount = totalAmount + multiplier*rate;
        }

        ticketEntity.setAmount( totalAmount);
        ticketEntity.setBookedAt(new Date());
        ticketEntity.setUser(userEntity);
        ticketEntity.setShow(showEntity);
        ticketEntity.setAllocated_seat(allocatedSeat);
        ticketEntity.setBookedSeats(bookedSeat);

        ticketRepository.save(ticketEntity);
        return "Successfully ticket is booked";
    }
}





