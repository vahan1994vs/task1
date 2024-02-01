package com.example.Resource.Service.service;

import com.example.Resource.Service.dto.ResourceDto;
import com.example.Resource.Service.entity.Resource;
import com.example.Resource.Service.repository.ResourceRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResourceServiceImpl implements ResourceService {

   private final ResourceRepository resourceRepository;

   @Override
   public Optional<ResourceDto> findResourceById(Long id) {
      Optional<Resource> resource = resourceRepository.findById(id);
      long resourceId = resource.get().getId();
      byte[] mp3 = resource.get().getMp3();
      try {
         Path path = Paths.get("mp3"); // specify the path and file name where you want to create the file
         Files.write(path, mp3); // write the byte[] to the file
      } catch (IOException e) {
         e.printStackTrace();
      }

      File file = mapToFile(mp3);
      ResourceDto resourceDto = new ResourceDto();
      resourceDto.setFile(file);
      resourceDto.setId(resourceId);

      return Optional.of(resourceDto);
   }

   @Override
   @Transactional
   public Resource saveResource(MultipartFile file) {
      Resource resource = mapToResource(file);
      return resourceRepository.save(resource);
   }

   private Resource mapToResource(MultipartFile file) {
      Resource resource = new Resource();
      try {
         byte[] bytes = file.getBytes();
         resource.setMp3(bytes);
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
      return resource;
   }

   private File mapToFile(byte[] mp3) {
      File file = new File("mp3");
      try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
         fileOutputStream.write(mp3);
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
      return file;
   }

   @Override
   public List<Long> deleteResourceById(List<Long> listDeletedIds) {
      resourceRepository.deleteResourcesByIds(listDeletedIds);
      return listDeletedIds;
   }
}
