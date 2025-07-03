package lab4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "\"user\"")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Имя не должно быть пустым")
    @Size(min = 3, max = 20, message = "Имя должно быть в диапазоне от 3 до 20 символов")
    @Column(name = "first_name", nullable = false)
    String firstName;

    @NotBlank(message = "Фамилия не должна быть пустой")
    @Size(min = 3, max = 20, message = "Фамилия должна быть в диапазоне от 3 до 20 символов")
    @Column(name = "last_name", nullable = false)
    String lastName;

    @NotNull(message = "Роль не должна быть null")
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    Role role;
}
