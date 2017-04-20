package com.koukio.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.koukio.entity.Dvd;

public interface DvdRepository extends CrudRepository<Dvd, Integer> {

	List<Dvd> findByTitleContainingAndDeletedAllIgnoringCase(String title, Boolean deleted);
	
	List<Dvd> findByDescriptionContainingAndDeletedAllIgnoringCase(String keyword, Boolean deleted);

}