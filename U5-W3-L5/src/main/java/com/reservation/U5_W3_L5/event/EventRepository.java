package com.reservation.U5_W3_L5.event;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    boolean existsByTitle(String title);

    List<Event> findAllByOrganizerId(Long organizerId);
}
