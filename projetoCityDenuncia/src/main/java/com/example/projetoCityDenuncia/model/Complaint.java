package com.example.projetoCityDenuncia.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "denuncias")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String category;
    private String address;
    private String description;
    private String image;

    private String status;

    private LocalDateTime createdAt;

    public Complaint() {
        this.createdAt = LocalDateTime.now();
        this.status = "ABERTA";
    }

    public Complaint(
            String title, String category, String address,
            String description, String image, String status
    ) {
        this.title = title;
        this.category = category;
        this.address = address;
        this.description = description;
        this.image = image;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCeatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

