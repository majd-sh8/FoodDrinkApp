package application.example.com.volly_recyclerv.RoomDB;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import application.example.com.moviesapp.models.Movie;

@Database(entities = {Movie.class}, version = 1 , exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MovieDao movieDao();
}
