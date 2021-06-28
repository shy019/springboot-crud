package com.co.crud.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.crud.crud.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
	List<Tutorial> findByPublished(boolean published);

	List<Tutorial> findByTitleContaining(String title);

	//Tutorial save(String title, String description, boolean published);
}