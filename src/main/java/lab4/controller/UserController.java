package lab4.controller;

import jakarta.validation.Valid;
import lab4.dto.UserDto;
import lab4.service.UserService;
import lab4.util.ErrorUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-api/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody @Valid UserDto userDto, BindingResult bindingResult) {
        ErrorUtil.ifHasErrorsBuildMessageAndThrowValidationException(bindingResult);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userDto));
    }
}
