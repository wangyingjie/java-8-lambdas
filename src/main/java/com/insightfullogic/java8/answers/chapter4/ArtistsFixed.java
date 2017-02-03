package com.insightfullogic.java8.answers.chapter4;

import com.insightfullogic.java8.examples.chapter1.Artist;

import java.util.List;
import java.util.Optional;

public class ArtistsFixed {

    private List<Artist> artists;

    public ArtistsFixed(List<Artist> artists) {
        this.artists = artists;
    }

    public Optional<Artist> getArtist(int index) {
        if (index < 0 || index >= artists.size()) {
            return Optional.empty();
        }
        return Optional.of(artists.get(index));
    }

    public String getArtistName(int index) {
        Optional<Artist> artist = getArtist(index);

        /*return artist.map(artist1 -> artist1.getName())
                .orElse("unknown");*/

        artist.map(artist1 -> artist1.getName());

        // todo 可以通过 Artist::getName 来重构上面的方法引用
        return artist.map(Artist::getName)
                     .orElse("unknown");
    }

}
