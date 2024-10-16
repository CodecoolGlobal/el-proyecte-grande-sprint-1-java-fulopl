package com.codecool.backend.modell.dto.food;

import java.time.LocalDate;

public record MenuItemDTO(
        Long id,
        CourseTypeDTO course,
        String code,
        DishDTO dish,
        int dayIndex,
        LocalDate dateOfDelivery) {
}
