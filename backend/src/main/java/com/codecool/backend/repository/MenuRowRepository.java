package com.codecool.backend.repository;

import com.codecool.backend.modell.menu.MenuRow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRowRepository extends JpaRepository<MenuRow, Long> {
}
