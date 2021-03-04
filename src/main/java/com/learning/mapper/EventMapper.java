package com.learning.mapper;

import com.learning.dto.EventDto;
import com.learning.model.Event;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {


    public EventDto mapToEventDto(Event event) {
        return new EventDto(event.getEventName(), event.getLocation(), event.getPrice(), event.getRank());
    }

}
