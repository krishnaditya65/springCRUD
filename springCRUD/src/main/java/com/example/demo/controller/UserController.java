package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserFilterRequest;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ApiResponse<UserDTO> create(@Valid @RequestBody UserDTO userDTO) {
        return ApiResponse.success("User created successfully", service.createUser(userDTO));
    }

    @GetMapping("/{id}")
    public ApiResponse<UserDTO> get(@PathVariable Long id) {
        return ApiResponse.success("User fetched successfully", service.getUserDTO(id));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        service.deleteUser(id);
        return ApiResponse.success("User deleted successfully", null);
    }

    @GetMapping("/advanced")
    public ApiResponse<Page<UserDTO>> getFilteredUsers(@ModelAttribute @Valid UserFilterRequest filters, Pageable pageable) {
        return ApiResponse.success("Users fetched successfully", service.searchUsers(filters, pageable));
    }
}
