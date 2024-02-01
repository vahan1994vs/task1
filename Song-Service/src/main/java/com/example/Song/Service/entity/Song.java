package com.example.Song.Service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "songs")
public class Song {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;

   @Column(name = "mp3")
   private String[] mp3;

   @Column(name = "resourceId")
   private Long resourceId;

   public Long getResourceId() {
      return resourceId;
   }

   public void setResourceId(Long resourceId) {
      this.resourceId = resourceId;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String[] getMp3() {
      return mp3;
   }

   public void setMp3(String[] mp3) {
      this.mp3 = mp3;
   }
}
