package lab05.Ex3;

import java.util.*;

public class Movie {
    private final String title; // required
    private final int year; // required
    private final Person director;
    private final Person writer;
    private final String series;
    private final List<Person> cast;
    private final List<Place> locations;
    private final List<String> languages;
    private final List<String> genres;
    private final boolean isTelevision;
    private final boolean isNetflix;
    private final boolean isIndependent;

    public static class Builder {
        private final String title; // required
        private final int year; // required

        private Person director = null;
        private Person writer = null;
        private String series = "";
        private List<Person> cast = null;
        private List<Place> locations = null;
        private List<String> languages = null;
        private List<String> genres =  null;
        private boolean isTelevision = false;
        private boolean isNetflix = false;
        private boolean isIndependent = false;


        public Builder(String title, int year) {
            this.title = title;
            this.year = year;
        }
        public Builder director(Person p) {
            director = p;
            return this;
        }
        public Builder writer(Person p) {
            writer = p;
            return this;
        }
        public Builder series(String s) {
            series = s;
            return this;
        }
        public Builder cast(List<Person> list) {
            cast = list;
            return this;
        }
        public Builder locations(List<Place> list) {
            locations = list;
            return this;
        }
        public Builder languages(List<String> list) {
            languages = list;
            return this;
        }
        public Builder genres(List<String> list) {
            genres = list;
            return this;
        }
        public Builder isTelevision(boolean bol) {
            isTelevision = bol;
            return this;
        }
        public Builder isNetflix(boolean bol) {
            isNetflix = bol;
            return this;
        }
        public Builder isIndependent(boolean bol) {
            isIndependent = bol;
            return this;
        }
        public Movie build() {
            return new Movie(this);
        }
    }

    private Movie(Builder builder) {
        title = builder.title;
        year = builder.year;
        director = builder.director;
        writer = builder.writer;
        series = builder.series;
        cast = builder.cast;
        locations = builder.locations;
        languages = builder.languages;
        genres = builder.genres;
        isTelevision = builder.isTelevision;
        isNetflix = builder.isNetflix;
        isIndependent = builder.isIndependent;
    }

    public String toString() {
        String info = "";
        if (title != null) {
            info += "Title: " + title + "\n";
        }
        if (year != 0){
            info += "Year: " + year + "\n";
        }
        if (director != null) {
            info += "Director: " + director + "\n";
        }
        if (writer != null) {
            info += "Writer: " + writer + "\n";
        }
        if (series != "") {
            info += "Series: " + series + "\n";
        }
        if (cast != null) {
            info += "Cast: " + cast + "\n";
        }
        if (locations != null) {
            info += "Locations: " + locations + "\n";
        }
        if (languages != null) {
            info += "Languages: " + languages + "\n";
        }
        if (genres != null) {
            info += "Genres: " + genres + "\n";
        }
        if (isTelevision != false) {
            info += "isTelevision: " + isTelevision + "\n";
        }
        if (isNetflix != false) {
            info += "isNetflix: " + isNetflix + "\n";
        }
        if (isIndependent != false) {
            info += "isIndependent: " + isIndependent + "\n";
        }
        return info;
    }
    
}