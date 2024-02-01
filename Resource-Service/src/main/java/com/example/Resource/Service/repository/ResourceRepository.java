package com.example.Resource.Service.repository;

import com.example.Resource.Service.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

   Optional<Resource> findById(Long id);

   Resource save(Resource resource);

   @Query("DELETE FROM Resource r WHERE r.id IN :ids")
   void deleteResourcesByIds(@Param("ids") List<Long> ids);

}
