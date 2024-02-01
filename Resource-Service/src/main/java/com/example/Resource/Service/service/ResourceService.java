package com.example.Resource.Service.service;

import com.example.Resource.Service.dto.ResourceDto;
import com.example.Resource.Service.entity.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Optional;

public interface ResourceService {

   Optional<ResourceDto> findResourceById(Long id);

   Resource saveResource(MultipartFile file);

   List<Long> deleteResourceById(List<Long> listIds);
}
