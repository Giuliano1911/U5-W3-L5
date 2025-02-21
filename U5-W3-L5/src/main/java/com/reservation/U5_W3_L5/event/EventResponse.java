package com.reservation.U5_W3_L5.event;

import com.reservation.U5_W3_L5.auth.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventResponse {

    private long id;

    private String title;

    private String description;

    private String location;

    private LocalDate date;

    private int maxGuests;

    private AppUser organizer;

    private List<AppUser> participants = new ArrayList<>();
}
