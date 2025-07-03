package lab4.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lab4.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @NotBlank(message = "Имя не должно быть пустым")
    @Size(min = 3, max = 20, message = "Имя должно быть в диапазоне от 3 до 20 символов")
    String firstName;

    @NotBlank(message = "Фамилия не должна быть пустой")
    @Size(min = 3, max = 20, message = "Фамилия должна быть в диапазоне от 3 до 20 символов")
    String lastName;

    @NotNull(message = "Роль не должна быть null")
    @Enumerated(EnumType.STRING)
    Role role;
}
