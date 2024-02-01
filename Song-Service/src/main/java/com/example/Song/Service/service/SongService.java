package com.example.Song.Service.service;

import com.example.Song.Service.entity.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {
   Optional<Song> findSongById(Long id);

   Song saveSong(Long id);

   List<Long> deleteSongById(List<Long> listIds);
}
