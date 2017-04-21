package com.koukio.repository;

import org.springframework.data.repository.CrudRepository;

import com.koukio.entity.Event;

public interface EventRepository extends CrudRepository<Event, Integer> {

}