package com.curso.apievents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.apievents.entities.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
