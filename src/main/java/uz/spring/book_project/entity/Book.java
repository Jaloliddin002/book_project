package uz.spring.book_project.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book extends BaseClass{

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String description;

    @Builder(builderMethodName = "childBuilder")
    public Book(Integer id, LocalDateTime createdAt, LocalDateTime updatedAt, String title, String author, String description) {
        super(id, createdAt, updatedAt);
        this.title = title;
        this.author = author;
        this.description = description;
    }
}
