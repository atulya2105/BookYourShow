package com.example.bookYourShow.Controller;


import com.example.bookYourShow.Dtos.ShowRequestDto;
import com.example.bookYourShow.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowService showService;
     @PostMapping("/add")
    public String addMovie(@RequestBody  ShowRequestDto showRequestDto){
         return showService.addShow(showRequestDto);
     }

}
