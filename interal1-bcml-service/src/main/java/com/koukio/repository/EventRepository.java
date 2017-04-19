package com.koukio.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.koukio.entity.Event;

public interface EventRepository extends Repository<Event, Long> {

	Page<Event> findAll(Pageable pageable);

	Event findByActionAndObjectAllIgnoringCase(String action, String object);

}