package com.dangwebs.backLinks.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ResourceDTO {
    private String id;
    @NotBlank
    private String userId;
    @NotBlank
    private String name;
    private String description;
    @NotBlank
    private String url;
    private List<String> category;
    private String date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceDTO that = (ResourceDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(url, that.url) && category == that.category && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, name, description, url, category, date);
    }

    @Override
    public String toString() {
        return "ResourceDTO{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", category=" + category +
                ", date='" + date + '\'' +
                '}';
    }
}