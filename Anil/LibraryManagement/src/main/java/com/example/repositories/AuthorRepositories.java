package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.dto.AuthorResponseDTO;
import com.example.entity.Author;


@Repository
@RepositoryRestResource
public interface AuthorRepositories extends JpaRepository<Author, Integer>{

	AuthorResponseDTO findByName(String name);
	
	@Query(value = "select * from author", nativeQuery = true)
	List<AuthorResponseDTO> findAllName();

	
}
