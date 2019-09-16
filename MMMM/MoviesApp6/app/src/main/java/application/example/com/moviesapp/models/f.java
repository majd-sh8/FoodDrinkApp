package application.example.com.moviesapp.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

@Entity(tableName = "movies")
public class Movie implements Parcelable {


    @PrimaryKey(autoGenerate = true)
    private int idDB;

    @ColumnInfo(name = "poster_path")
    private String poster_path;

    @ColumnInfo(name = "overview")
    private String overview;

    @ColumnInfo(name = "release_date")
    private String release_date;

    @ColumnInfo(name = "idMovie")
    private int idMovie;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "backdrop_path")
    private String backdrop_path;

    @ColumnInfo(name = "popularity")
    private double popularity;

    @ColumnInfo(name = "vote_average")
    private float vote_average;

    @ColumnInfo(name = "favorate")
    private Boolean favorate;

    @Ignore
    public Movie() {
    }



    protected Movie(Parcel in) {
        idDB = in.readInt();
        poster_path = in.readString();
        overview = in.readString();
        release_date = in.readString();
        idMovie = in.readInt();
        title = in.readString();
        backdrop_path = in.readString();
        popularity = in.readDouble();
        vote_average = in.readFloat();
        byte tmpFavorate = in.readByte();
        favorate = tmpFavorate == 0 ? null : tmpFavorate == 1;
    }


    /*
     * Getters and Setters
     * */
    public int getIdDB() {
        return idDB;
    }

    public Movie setIdDB(int idDB) {
        this.idDB = idDB;
        return this;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public Movie setPoster_path(String poster_path) {
        this.poster_path = poster_path;
        return this;
    }

    public String getOverview() {
        return overview;
    }

    public Movie setOverview(String overview) {
        this.overview = overview;
        return this;
    }

    public String getRelease_date() {
        return release_date;
    }

    public Movie setRelease_date(String release_date) {
        this.release_date = release_date;
        return this;
    }

    public int getIdMovie() {
        return idMovie;
    }

    public Movie setIdMovie(int idMovie) {
        this.idMovie = idMovie;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Movie setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public Movie setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
        return this;
    }

    public double getPopularity() {
        return popularity;
    }

    public Movie setPopularity(double popularity) {
        this.popularity = popularity;
        return this;
    }

    public float getVote_average() {
        return vote_average;
    }

    public Movie setVote_average(float vote_average) {
        this.vote_average = vote_average;
        return this;
    }

    public Boolean getFavorate() {
        return favorate;
    }

    public Movie setFavorate(Boolean favorate) {
        this.favorate = favorate;
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idDB);
        dest.writeString(poster_path);
        dest.writeString(overview);
        dest.writeString(release_date);
        dest.writeInt(idMovie);
        dest.writeString(title);
        dest.writeString(backdrop_path);
        dest.writeDouble(popularity);
        dest.writeFloat(vote_average);
        dest.writeByte((byte) (favorate == null ? 0 : favorate ? 1 : 2));
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}