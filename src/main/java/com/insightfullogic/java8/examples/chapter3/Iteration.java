package com.insightfullogic.java8.examples.chapter3;

import com.insightfullogic.java8.examples.chapter1.Artist;

import java.util.Iterator;
import java.util.List;

public class Iteration {

    public int externalCountArtistsFromLondon(List<Artist> allArtists) {
        // BEGIN external_count_londoners
        int count = 0;
        for (Artist artist : allArtists) {
            if (artist.isFrom("London")) {
                count++;
            }
        }
        // END external_count_londoners
        return count;
    }

    public int externalCountArtistsFromLondonExpanded(List<Artist> allArtists) {
        // BEGIN external_count_londoners_expanded
        int count = 0;
        Iterator<Artist> iterator = allArtists.iterator();
        while (iterator.hasNext()) {
            Artist artist = iterator.next();
            if (artist.isFrom("London")) {
                count++;
            }
        }
        // END external_count_londoners_expanded
        return count;
    }


    public long internalCountArtistsFromLondon(List<Artist> allArtists) {
        // BEGIN internal_count_londoners
        long count = allArtists.stream()
                .filter(artist -> artist.isFrom("London"))
                .count();
        // END internal_count_londoners
        return count;
    }

    public void filterArtistsFromLondon(List<Artist> allArtists) {
        // BEGIN filter_londoners
        allArtists.stream()
                .filter(artist -> artist.isFrom("London"));
        // END filter_londoners
    }

    public void filterArtistsFromLondonPrinted(List<Artist> allArtists) {
        // BEGIN filter_londoners_printed
        allArtists.stream()
                // filter 属于惰性求值方法
                .filter(artist -> {
                    //此处并不会并打印，如果调用了 count 方法则会打印
                    System.out.println(artist.getName());
                    return artist.isFrom("London");
                });
        // END filter_londoners_printed
    }

    public long internalCountArtistsFromLondonPrinted(List<Artist> allArtists) {
        // BEGIN internal_count_londoners_printed
        long count = allArtists.stream()
                .filter(artist -> {
                    System.out.println(artist.getName());
                    return artist.isFrom("London");
                })
                .count();//及早求值方法
        // END internal_count_londoners_printed
        return count;
    }

}
