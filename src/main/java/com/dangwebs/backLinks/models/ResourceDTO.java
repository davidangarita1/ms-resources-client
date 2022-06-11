package com.dangwebs.backLinks.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ResourceDTO {
    private String id;
    @NotBlank
    private String name;
    private String description;
    @NotBlank
    private String url;
    private List<String> category;
    private Date date;
    private String image;
    private Boolean favorite;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceDTO that = (ResourceDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(url, that.url) && Objects.equals(category, that.category) && Objects.equals(date, that.date) && Objects.equals(image, that.image) && Objects.equals(favorite, that.favorite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, url, category, date, image, favorite);
    }

    @Override
    public String toString() {
        return "ResourceDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", category=" + category +
                ", date=" + date +
                ", image='" + image + '\'' +
                ", favorite=" + favorite +
                '}';
    }
}
