package com.codecool.backend.controller.dto;

import java.util.List;

public record MemberAdminDTO(Long id, String username, List<String> roles) {
}
