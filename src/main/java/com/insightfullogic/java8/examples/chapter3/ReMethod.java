package com.insightfullogic.java8.examples.chapter3;

import com.insightfullogic.java8.examples.chapter1.Album;
import com.insightfullogic.java8.examples.chapter1.Artist;
import com.insightfullogic.java8.examples.chapter1.Track;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by wangyingjie1 on 2017/2/3.
 */
public class ReMethod {

    // 传统的查找满足条件的元素
    public Set<String> findLongTracks(List<Album> albums) {

        Set<String> set = new HashSet<>();
        for (Album album : albums) {
            for (Track track : album.getTrackList()) {
                if (track.getLength() > 60) {
                    set.add(track.getName());
                }
            }
        }

        return set;
    }

    public Set<String> findLongTracks_V1(List<Album> albums) {
        Set<String> set = new HashSet<>();

        albums.stream().forEach(album -> {
            album.getTrackList().forEach(track -> {
                if (track.getLength() > 60) {
                    set.add(track.getName());
                }
            });
        });

        return set;
    }


    public Set<String> findLongTracks_V2(List<Album> albums) {
        Set<String> set = new HashSet<>();

        albums.stream()
                .forEach(album -> {
                    album.getTrackList().stream()
                            .filter(track -> track.getLength() > 60).map(track -> track.getName())
                            .forEach(name -> {
                                set.add(name);
                            });
                });

        return set;
    }

    public Set<String> findLongTracks_V3(List<Album> albums) {
        Set<String> set = new HashSet<>();

        albums.stream()
                .forEach(album -> {
                    album.getTracks()
                            .filter(track -> track.getLength() > 60).map(track -> track.getName())
                            .forEach(name -> {
                                set.add(name);
                            });
                });

        return set;
    }

    // 流合并
    public Set<String> findLongTracks_V4(List<Album> albums) {
        Set<String> set = new HashSet<>();

        albums.stream()
                .flatMap(album -> album.getTracks())
                .filter(track -> track.getLength() > 60)
                .map(track -> track.getName())
                .forEach(name -> {
                    set.add(name);
                });

        return set;
    }

    // 流合并 自动创建set集合
    public Set<String> findLongTracks_V5(List<Album> albums) {

        Set<String> set = albums.stream()
                .flatMap(album -> album.getTracks())
                .filter(track -> track.getLength() > 60)
                .map(track -> track.getName())
                .collect(Collectors.toSet());

        return set;
    }

    // 流合并 自动创建set集合
    public Set<String> findLongTracks_V6(List<Album> albums) {
        // 风格简易、易读
        return albums.stream()
                .flatMap(album -> album.getTracks())
                .filter(track -> track.getLength() > 60)
                .map(track -> track.getName())
                .collect(Collectors.toSet());
    }


    /**
     * 重构以下方法
     *
     * @param artistList
     * @return
     * @see ReMethod#totalMembers_V1(java.util.List)
     */
    public Long totalMembers(List<Artist> artistList) {
        long totalMembers = 0;
        // 1、将artist map 为 long
        // 2、reduce 求和，使用Long 的静态方法
        for (Artist artist : artistList) {
            Stream<Artist> members = artist.getMembers();
            totalMembers += members.count();
        }

        return totalMembers;
    }

    public Long totalMembers_V1(List<Artist> artistList) {

        return artistList.stream()
                .map(artist -> artist.getMembers().count())
                .reduce(0L, Long::sum);
    }
}
