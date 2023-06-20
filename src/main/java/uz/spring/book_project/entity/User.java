package uz.spring.book_project.entity;


import jakarta.persistence.*;
import lombok.*;
import uz.spring.book_project.enums.Role;

import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User extends BaseClass{

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder(builderMethodName = "childBuilder")
    public User(Integer id, LocalDateTime createdAt, LocalDateTime updatedAt, String email, String password, Role role) {
        super(id, createdAt, updatedAt);
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
