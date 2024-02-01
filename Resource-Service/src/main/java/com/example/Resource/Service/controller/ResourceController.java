package com.example.Resource.Service.controller;

import com.example.Resource.Service.dto.ResourceDto;
import com.example.Resource.Service.entity.Resource;
import com.example.Resource.Service.service.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resources")
@RequiredArgsConstructor
public class ResourceController {

   private final ResourceService resourceService;

   @GetMapping("/{id}")
   public ResponseEntity<Optional<ResourceDto>> getResource(@PathVariable("id") Long id) {
      Optional<ResourceDto> resourceById = resourceService.findResourceById(id);
      return new ResponseEntity<>(resourceById, HttpStatus.OK);
   }

   @PostMapping()
   public ResponseEntity<Long> saveResource(@RequestParam("file") MultipartFile file) {
      Resource resource = resourceService.saveResource(file);
      return new ResponseEntity<>(resource.getId(), HttpStatus.CREATED);
   }

   @DeleteMapping("/{ids}")
   public ResponseEntity<List<Long>> deleteResources(@PathVariable List<Long> ids) {
      List<Long> longs = resourceService.deleteResourceById(ids);
      return new ResponseEntity<>(longs, HttpStatus.OK);
   }
}
