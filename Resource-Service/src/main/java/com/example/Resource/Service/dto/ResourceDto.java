package com.example.Resource.Service.dto;

import java.io.File;

public class ResourceDto {

   private Long id;

   private File file;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public File getFile() {
      return file;
   }

   public void setFile(File file) {
      this.file = file;
   }
}
