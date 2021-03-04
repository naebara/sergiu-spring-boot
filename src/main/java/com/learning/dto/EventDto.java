package com.learning.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {

    private int id;
    private String eventName;
    private int price;
    private String location;
    private int rank;
    private List<PersonDto> participants = new ArrayList<>();

    public EventDto(String eventName, String location, int price, int rank) {
        this.eventName = eventName;
        this.location = location;
        this.price = price;
        this.rank = rank;

    }

}
