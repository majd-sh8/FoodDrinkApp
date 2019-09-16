package application.example.com.moviesapp.RoomDB;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import application.example.com.moviesapp.models.Movie;

@Dao
public interface MovieDao {

    @Query("SELECT * FROM moviesfav")
    List<Movie> getAllMovieFav();

    @Insert
    void insert(Movie movie);

    @Delete
    void delete(Movie movie);


    @Query("SELECT * FROM moviesfav where title LIKE  :title11 ")
    Movie checkMovie(String title11);


}

