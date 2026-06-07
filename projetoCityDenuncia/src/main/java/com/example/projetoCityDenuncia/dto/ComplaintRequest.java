package com.example.projetoCityDenuncia.dto;

public class ComplaintRequest {
    private String title;
    private String category;
    private String address;
    private String description;
    private String image;

    public ComplaintRequest() {
    }

    public ComplaintRequest(
            String title, String category, String address,
            String description, String image
    ) {
        this.title = title;
        this.category = category;
        this.address = address;
        this.description = description;
        this.image = image;
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
}
