package com.learning.mapper;

import com.learning.dto.CarDto;
import com.learning.model.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public CarDto mapToDto(Car car) {
        return new CarDto(car.getId(), car.getBrand(), car.getModel(), car.getHp());
    }

}
