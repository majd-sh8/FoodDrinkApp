package application.example.com.moviesapp.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

@Entity(tableName = "moviesFav")
public class Movie implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

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
    private Boolean fav;

    @Ignore
    String path = "https://image.tmdb.org/t/p/w500/";

    @Ignore
    public Movie() {
    }

    public Movie(String poster_path, String overview, String release_date, int id, int idMovie, String title, String backdrop_path, double popularity, float vote_average, Boolean fav) {
        this.poster_path = poster_path;
        this.overview = overview;
        this.release_date = release_date;
        this.id = id;
        this.idMovie = idMovie;
        this.title = title;
        this.backdrop_path = backdrop_path;
        this.popularity = popularity;
        this.vote_average = vote_average;
        this.fav = fav;
    }

    @Ignore
    public Movie(String poster_path, String overview, String release_date, int idMovie, String title, String backdrop_path, double popularity, float vote_average, Boolean fav) {
        this.poster_path = poster_path;
        this.overview = overview;
        this.release_date = release_date;
        this.idMovie = idMovie;
        this.title = title;
        this.backdrop_path = backdrop_path;
        this.popularity = popularity;
        this.vote_average = vote_average;
        this.fav = fav;
    }

    /*
     * Getters and Setters
     * */

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

    public int getId() {
        return id;
    }

    public Movie setId(int id) {
        this.id = id;
        return this;
    }

    public String getPoster_path() {
        return path.concat(poster_path);
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
        return path.concat(backdrop_path);
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

    public Boolean getFav() {
        return fav;
    }

    public Movie setFav(Boolean fav) {
        this.fav = fav;
        return this;
    }

    protected Movie(Parcel in) {
        poster_path = in.readString();
        overview = in.readString();
        release_date = in.readString();
        id = in.readInt();
        title = in.readString();
        backdrop_path = in.readString();
        popularity = in.readDouble();
        vote_average = in.readFloat();
        byte tmpFavorate = in.readByte();
        fav = tmpFavorate == 0 ? null : tmpFavorate == 1;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(poster_path);
        dest.writeString(overview);
        dest.writeString(release_date);
        dest.writeInt(idMovie);
        dest.writeString(title);
        dest.writeString(backdrop_path);
        dest.writeDouble(popularity);
        dest.writeFloat(vote_average);
        dest.writeByte((byte) (fav == null ? 0 : fav ? 1 : 2));

    }
}
