
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
    private int id;

    @ColumnInfo(name = "poster_path")
    private String poster_path;

    @ColumnInfo(name = "overview")
    private String overview;

    @ColumnInfo(name = "release_date")
    private String release_date;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "backdrop_path")
    private String backdrop_path;

    @ColumnInfo(name = "popularity")
    private double popularity;

    @ColumnInfo(name = "vote_average")
    private float vote_average;

    @ColumnInfo(name = "idMovie")
    private int idMovie;

    @ColumnInfo(name = "favorate")
    private Boolean favorate;

    @Ignore
    public Movie() {
    }

    public Movie(String poster_path, String overview, String release_date, String title, String backdrop_path, double popularity, float vote_average, int idMovie, Boolean favorate) {
        this.poster_path = poster_path;
        this.overview = overview;
        this.release_date = release_date;
        this.title = title;
        this.backdrop_path = backdrop_path;
        this.popularity = popularity;
        this.vote_average = vote_average;
        this.idMovie = idMovie;
        this.favorate = favorate;
    }

    protected Movie(Parcel in) {
        id = in.readInt();
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

    /*
     * Getters and Setters
     * */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPoster_path() {
        String imag = "https://image.tmdb.org/t/p/w500/";
        return imag.concat(poster_path);
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }


    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getBackdrop_path() {
        String imag = "https://image.tmdb.org/t/p/w500/";
        return imag.concat(backdrop_path);
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }


    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public int getIdMovie() {
        return idMovie;
    }

    public int setIdMovie(int idMovie) {
        this.idMovie = idMovie;
        return idMovie;
    }


    public void setFavorate(Boolean favorate) {
        this.favorate = favorate;
    }

    public Boolean getFavorate() {
        return favorate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
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


}