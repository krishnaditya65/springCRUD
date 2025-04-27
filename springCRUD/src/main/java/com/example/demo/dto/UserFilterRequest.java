package com.example.demo.dto;

public class UserFilterRequest {

    private String name;
    private String email;
    private Integer minAge;
    private Integer maxAge;

    // --- Getters and Setters ---
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getMinAge() { return minAge; }
    public void setMinAge(Integer minAge) { this.minAge = minAge; }

    public Integer getMaxAge() { return maxAge; }
    public void setMaxAge(Integer maxAge) { this.maxAge = maxAge; }
}
