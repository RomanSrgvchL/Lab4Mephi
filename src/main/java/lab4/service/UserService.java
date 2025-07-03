package lab4.service;

import lab4.dto.UserDto;
import lab4.model.User;
import lab4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(this::convertToUserDto).toList();
    }

    @Transactional
    public UserDto save(UserDto userDto) {
        return convertToUserDto(userRepository.save(convertToUser(userDto)));
    }

    private User convertToUser(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    private UserDto convertToUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }
}
