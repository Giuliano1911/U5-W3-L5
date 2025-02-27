package com.reservation.U5_W3_L5.event;

import com.reservation.U5_W3_L5.response.CreateResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
@Validated
public class EventController {
    private final EventService eventService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EventResponse> findAll() {
        return eventService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EventResponse findById(@PathVariable Long id) {
        return eventService.findById(id);
    }

    @GetMapping("/reservations")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('USER')")
    public List<EventResponse> getCurrentUserEvents() {
        return eventService.findAllEventsByUserId();
    }

    @GetMapping("/created")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ORGANIZER')")
    public List<EventResponse> findAllEventsByOrganizer() {
        return eventService.findAllEventsByOrganizer();
    }

    @PatchMapping("/add/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('USER')")
    public EventResponse addParticipant(@PathVariable Long id) {
        return eventService.addParticipant(id);
    }

    @PatchMapping("/remove/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('USER')")
    public EventResponse removeParticipant(@PathVariable Long id) {
        return eventService.removeParticipant(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ORGANIZER')")
    public CreateResponse save(@RequestBody @Valid EventRequest eventRequest) {
        return eventService.save(eventRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ORGANIZER')")
    public EventResponse update(@PathVariable Long id, @RequestBody @Valid EventRequest eventRequest) {
        return eventService.update(id, eventRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ORGANIZER')")
    public void delete(@PathVariable Long id) {
        eventService.delete(id);
    }
}
