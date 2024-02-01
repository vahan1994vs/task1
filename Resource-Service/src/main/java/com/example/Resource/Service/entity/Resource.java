package com.example.Resource.Service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "resources")
public class Resource {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
   @Column(name = "mp3")
   @Lob
   private byte[] mp3;

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public byte[] getMp3() {
      return mp3;
   }

   public void setMp3(byte[] mp3) {
      this.mp3 = mp3;
   }
}
