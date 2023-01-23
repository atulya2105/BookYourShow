package com.example.bookYourShow.Service;

import com.example.bookYourShow.Dtos.MovieRequestDto;
import com.example.bookYourShow.Modals.MovieEntity;
import com.example.bookYourShow.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    public String addMovie(MovieRequestDto movieRequestDto){
        MovieEntity movie = MovieEntity.builder().movieName(movieRequestDto.getMovieName()).releaseDate(movieRequestDto.getReleaseDate())
                .duration(movieRequestDto.getDuration()).build();
        try {
            movieRepository.save(movie);
        }catch (Exception e){
            return "There is an exception";
        }
        return "Successfully add movie in the database";
    }
}
