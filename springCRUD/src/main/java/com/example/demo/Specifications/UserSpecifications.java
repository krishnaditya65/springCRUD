package com.example.demo.Specifications;

import com.example.demo.model.MyUser;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecifications {

    public static Specification<MyUser> nameContains(String name) {
        return (root, query, builder) -> builder.like(builder.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<MyUser> emailContains(String email) {
        return (root, query, builder) -> builder.like(builder.lower(root.get("email")), "%" + email.toLowerCase() + "%");
    }

    public static Specification<MyUser> ageBetween(Integer minAge, Integer maxAge) {
        return (root, query, builder) -> builder.between(root.get("age"), minAge, maxAge);
    }
}
