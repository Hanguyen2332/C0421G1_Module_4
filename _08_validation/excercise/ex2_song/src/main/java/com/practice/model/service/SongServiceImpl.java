package com.practice.model.service;

import com.practice.model.entity.Song;
import com.practice.model.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements ISongService {
    @Autowired
    private SongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void createSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public Optional<Song> findById(Integer id) {
        return songRepository.findById(id);
    }
}
