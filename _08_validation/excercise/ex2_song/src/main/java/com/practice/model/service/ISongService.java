package com.practice.model.service;

import com.practice.model.entity.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    List<Song> findAll();
    void createSong(Song song);
    Optional<Song> findById(Integer id);
}
