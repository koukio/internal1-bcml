package com.koukio.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.koukio.entity.Event;

public interface EventRepository extends CrudRepository<Event, Long> {

	Page<Event> findAll(Pageable pageable);

	Event findByActionAndObjectAllIgnoringCase(String action, String object);

}