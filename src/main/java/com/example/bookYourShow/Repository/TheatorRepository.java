package com.example.bookYourShow.Repository;

import com.example.bookYourShow.Modals.TheaterEntity;
import com.example.bookYourShow.Modals.TheaterSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatorRepository extends JpaRepository<TheaterEntity,Integer> {
}
