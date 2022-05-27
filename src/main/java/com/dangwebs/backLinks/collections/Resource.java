package com.dangwebs.backLinks.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Resource {
    @Id
    private String id;
    private String userId;
    private String name;
    private String description;
    private String url;
    private List<String> category;
    private String date;
}
