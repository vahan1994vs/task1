package com.example.Song.Service.controller;

import com.example.Song.Service.entity.Song;
import com.example.Song.Service.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/songs")
@RequiredArgsConstructor
public class SongController {

   private final SongService songService;

   @GetMapping("/{id}")
   public ResponseEntity<Optional<Song>> getSong(@PathVariable("id") Long id) {
      Optional<Song> resourceById = songService.findSongById(id);
      return new ResponseEntity<>(resourceById, HttpStatus.OK);
   }

   @PostMapping("/{id}")
   public ResponseEntity<Long> saveSong(@PathVariable("id") Long id) {
      Long longId = songService.saveSong(id).getId();
      return new ResponseEntity<>(longId, HttpStatus.OK);
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<List<Long>> deleteSong(@PathVariable List<Long> ids) {
      List<Long> longs = songService.deleteSongById(ids);
      return new ResponseEntity<>(longs, HttpStatus.OK);
   }
}
