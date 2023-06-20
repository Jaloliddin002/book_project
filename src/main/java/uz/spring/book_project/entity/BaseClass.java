package uz.spring.book_project.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
    @MappedSuperclass
@Getter
@Setter
@Builder
public class BaseClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreationTimestamp
    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
