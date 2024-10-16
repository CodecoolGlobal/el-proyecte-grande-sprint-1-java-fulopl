package com.codecool.backend.repository;

import com.codecool.backend.modell.entity.menu.CourseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseTypeRepository extends JpaRepository<CourseType, Long> {
    Optional<CourseType> findByName(String dishType);
}
