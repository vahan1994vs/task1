package com.example.Song.Service.repository;

import com.example.Song.Service.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

   Optional<Song> findById(Long id);

   Song save(Song song);

   @Query("DELETE FROM Song r WHERE r.id IN :ids")
   void deleteSongsByIds(@Param("ids") List<Long> ids);

}
