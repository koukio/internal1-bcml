package com.koukio.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.koukio.entity.Dvd;

public interface DvdRepository extends Repository<Dvd, Long> {

	Page<Dvd> findAll(Pageable pageable);

	Dvd findByTitleAndDeletedAllIgnoringCase(String title, String deleted);

}