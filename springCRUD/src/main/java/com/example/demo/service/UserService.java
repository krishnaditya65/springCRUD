package com.example.demo.service;

import com.example.demo.Specifications.UserSpecifications;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserFilterRequest;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.MyUser;
import com.example.demo.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public UserDTO createUser(UserDTO userDTO) {
        MyUser user = UserMapper.toEntity(userDTO);
        MyUser saved = repo.save(user);
        return UserMapper.toDTO(saved);
    }

    public UserDTO getUserDTO(Long id) {
        return repo.findById(id)
                .map(UserMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("User with ID " + id + " not found"));
    }

    public void deleteUser(Long id) {
        repo.deleteById(id);
    }

    public Page<UserDTO> searchUsers(UserFilterRequest filters, Pageable pageable) {
        Specification<MyUser> spec = Specification.where(null);

        if (filters.getName() != null && !filters.getName().isBlank()) {
            spec = spec.and(UserSpecifications.nameContains(filters.getName()));
        }
        if (filters.getEmail() != null && !filters.getEmail().isBlank()) {
            spec = spec.and(UserSpecifications.emailContains(filters.getEmail()));
        }
        if (filters.getMinAge() != null && filters.getMaxAge() != null) {
            spec = spec.and(UserSpecifications.ageBetween(filters.getMinAge(), filters.getMaxAge()));
        }

        return repo.findAll(spec, pageable)
                .map(UserMapper::toDTO);
    }
}
