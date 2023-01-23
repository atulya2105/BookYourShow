package com.example.bookYourShow.Service;

import com.example.bookYourShow.Dtos.TheaterRequestDto;
import com.example.bookYourShow.Modals.TheaterEntity;
import com.example.bookYourShow.Modals.TheaterSeatEntity;
import com.example.bookYourShow.Repository.TheaterSeatRepository;
import com.example.bookYourShow.Repository.TheatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bookYourShow.Enums.SeatType;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterSeatRepository theaterSeatEntityRepository;
    @Autowired
    TheatorRepository theatorRepository;
    public String createTheater(TheaterRequestDto theaterRequestDto){
        TheaterEntity theaterEntity = TheaterEntity.builder().name(theaterRequestDto.getName())
                .address(theaterRequestDto.getAddress())
                .city(theaterRequestDto.getCity()).build();
        List<TheaterSeatEntity> theaterSeatEntityList = createTheaterSeatList();

        theaterEntity.setTheaterSeatEntityList(theaterSeatEntityList);
        for(TheaterSeatEntity theaterSeat : theaterSeatEntityList){
            theaterSeat.setTheater(theaterEntity);
        }
        theatorRepository.save(theaterEntity);
        return "Successfully theater is created";
    }
    private List<TheaterSeatEntity> createTheaterSeatList(){
        List<TheaterSeatEntity> theaterSeatEntityList = new ArrayList<>();
//        TheaterSeatEntity theaterSeatEntity1 = new TheaterSeatEntity("A1",SeatType.CLASSIC,200);
//        TheaterSeatEntity theaterSeatEntity2 = new TheaterSeatEntity("A2",SeatType.CLASSIC,200);
//        TheaterSeatEntity theaterSeatEntity3 = new TheaterSeatEntity("A3",SeatType.CLASSIC,200);
//        TheaterSeatEntity theaterSeatEntity4 = new TheaterSeatEntity("A4",SeatType.CLASSIC,200);
//        TheaterSeatEntity theaterSeatEntity5 = new TheaterSeatEntity("A5",SeatType.CLASSIC,200);
//        TheaterSeatEntity theaterSeatEntity6 = new TheaterSeatEntity("B1",SeatType.PLATINUM,400);
//        TheaterSeatEntity theaterSeatEntity7 = new TheaterSeatEntity("B2",SeatType.PLATINUM,400);
//        TheaterSeatEntity theaterSeatEntity8 = new TheaterSeatEntity("B3",SeatType.PLATINUM,400);
//        TheaterSeatEntity theaterSeatEntity9 = new TheaterSeatEntity("B4",SeatType.PLATINUM,400);
//        TheaterSeatEntity theaterSeatEntity10 = new TheaterSeatEntity("B6",SeatType.PLATINUM,400);


//        theaterSeatEntityList.add(theaterSeatEntity1);
//        theaterSeatEntityList.add(theaterSeatEntity2);
//        theaterSeatEntityList.add(theaterSeatEntity3);
//        theaterSeatEntityList.add(theaterSeatEntity4);
//        theaterSeatEntityList.add(theaterSeatEntity5);
//        theaterSeatEntityList.add(theaterSeatEntity6);
//        theaterSeatEntityList.add(theaterSeatEntity7);
//        theaterSeatEntityList.add(theaterSeatEntity8);
//        theaterSeatEntityList.add(theaterSeatEntity9);
//        theaterSeatEntityList.add(theaterSeatEntity10);
//        theaterSeatEntityRepository.saveAll(theaterSeatEntityList);

        // here this is another way to write the same code using loops

        for(int i = 0;i<5;i++){
            char ch = (char)('A'+i);
            String seatNo = "1" + ch;
            TheaterSeatEntity theaterSeatEntity = new TheaterSeatEntity(seatNo,SeatType.CLASSIC,200);
            theaterSeatEntityList.add(theaterSeatEntity);

        }
        for(int i = 0;i<5;i++){
            char  ch = (char)('A'+i);
            String seatNo = "2"+ch;
            TheaterSeatEntity theaterSeatEntity = new TheaterSeatEntity(seatNo,SeatType.PLATINUM,400);
            theaterSeatEntityList.add(theaterSeatEntity);
        }

        return theaterSeatEntityList;
    }
}
