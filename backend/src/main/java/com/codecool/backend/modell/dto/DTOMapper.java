package com.codecool.backend.modell.dto;

import com.codecool.backend.modell.dto.food.*;
import com.codecool.backend.modell.dto.member.AddressDTO;
import com.codecool.backend.modell.dto.member.MemberRoleDTO;
import com.codecool.backend.modell.entity.dish.Allergen;
import com.codecool.backend.modell.entity.dish.Dish;
import com.codecool.backend.modell.entity.member.Address;
import com.codecool.backend.modell.entity.member.MemberRole;
import com.codecool.backend.modell.entity.menu.CourseType;
import com.codecool.backend.modell.entity.menu.MenuItem;
import com.codecool.backend.modell.entity.menu.WeeklyMenu;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DTOMapper {
    public static WeeklyMenuDTO toWeeklyMenuDTO(WeeklyMenu weeklyMenu) {
        return new WeeklyMenuDTO(
                weeklyMenu.getId(),
                weeklyMenu.getWeekNumber(),
                weeklyMenu.getStartDate(),
                weeklyMenu.getEndDate(),
                toMenuItemDTOList(weeklyMenu.getMenuItems())
        );
    }

    public static List<MenuItemDTO> toMenuItemDTOList(List<MenuItem> menuItems) {
        return menuItems.stream()
                .map(DTOMapper::toMenuItemDTO)
                .toList();
    }

    public static MenuItemDTO toMenuItemDTO(MenuItem menuItem) {
        return new MenuItemDTO(menuItem.getId(),
                toCourseTypeDTO(menuItem.getCourse()),
                menuItem.getCode(),
                toDishDTO(menuItem.getDish()),
                menuItem.getDayIndex(),
                menuItem.getWeeklyMenu().getStartDate().plusDays(menuItem.getDayIndex()-1)
        );
    }

    public static CourseTypeDTO toCourseTypeDTO(CourseType courseType) {
        return new CourseTypeDTO(courseType.getId(), courseType.getName());
    }

    public static DishDTO toDishDTO(Dish dish) {
        return new DishDTO(
                dish.getId(),
                dish.getName(),
                dish.getDescription(),
                dish.getPrice(),
                toAllergenDTOSet(dish.getAllergens())
        );
    }

    public static Set<AllergenDTO> toAllergenDTOSet(Set<Allergen> allergens) {
        return allergens.stream()
                .map(DTOMapper::toAllergenDTO)
                .collect(Collectors.toSet());
    }

    public static AllergenDTO toAllergenDTO(Allergen allergen) {
        return new AllergenDTO(allergen.getName(), allergen.getNumber());
    }

    public static Set<MemberRoleDTO> toMemberRoleDTOSet(Set<MemberRole> memberRoles) {
        return memberRoles.stream().map(DTOMapper::toMemberRoleDTO).collect(Collectors.toSet());
    }

    public static MemberRoleDTO toMemberRoleDTO(MemberRole memberRole) {
        return new MemberRoleDTO(memberRole.getRole());
    }

    public static AddressDTO toAddressDTO(Address address) {
        return new AddressDTO(
                address.getStreetAndHouseNumber(),
                address.getSettlement(),
                address.getCountry(),
                address.getZipCode()
        );
    }
}
