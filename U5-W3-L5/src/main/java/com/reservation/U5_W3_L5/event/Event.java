package com.reservation.U5_W3_L5.event;

import com.reservation.U5_W3_L5.auth.AppUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    private String description;

    private String location;

    private LocalDate date;

    private int maxGuests;

    @ManyToOne
    private AppUser organizer;

    @OneToMany
    private List<AppUser> participants = new ArrayList<>();
}
