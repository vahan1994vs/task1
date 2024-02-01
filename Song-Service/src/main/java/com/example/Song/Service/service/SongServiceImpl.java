package com.example.Song.Service.service;

import com.example.Song.Service.dto.ResourceDto;
import com.example.Song.Service.entity.Song;
import com.example.Song.Service.repository.SongRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SongServiceImpl implements SongService {

   private final SongRepository songRepository;

   @Override
   public Optional<Song> findSongById(Long id) {
      return songRepository.findById(id);
   }

   @Override
   @Transactional
   public Song saveSong(final Long id) {

      final String uri = "http://localhost:8085/resources/" + id;
      final RestTemplate restTemplate = new RestTemplate();
      final ResourceDto resourceDto = restTemplate.getForObject(uri, ResourceDto.class);

      final BodyContentHandler handler = new BodyContentHandler();
      final Metadata metadata = new Metadata();
      final ParseContext pcontext = new ParseContext();

      //Mp3 parser
      final Mp3Parser mp3Parser = new Mp3Parser();

      try (FileInputStream inputstream = new FileInputStream(Optional.ofNullable(resourceDto)
            .map(ResourceDto::getFile)
            .orElseThrow(() -> new IllegalArgumentException("Resource file is missing!")))) {
         mp3Parser.parse(inputstream, handler, metadata, pcontext);
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
      final var metadataNames = metadata.names();

      final var song = new Song();
      song.setMp3(metadataNames);
      song.setResourceId(Optional.of(resourceDto)
            .map(ResourceDto::getId)
            .orElseThrow(() -> new IllegalArgumentException("Resource file is missing!")));

      return songRepository.save(song);
   }

   @Override
   public List<Long> deleteSongById(final List<Long> listIds) {
      songRepository.deleteSongsByIds(listIds);
      return listIds;
   }
}
