package cinema.controller;

import cinema.dto.request.UserLoginRequestDto;
import cinema.dto.request.UserRegistrationRequestDto;
import cinema.dto.response.UserResponseDto;
import cinema.exception.AuthenticationException;
import cinema.model.User;
import cinema.security.jwt.JwtTokenProvider;
import cinema.service.AuthenticationService;
import cinema.service.mapper.ResponseDtoMapper;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final ResponseDtoMapper<UserResponseDto, User> userDtoResponseMapper;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthenticationController(AuthenticationService authenticationService,
                                    ResponseDtoMapper<UserResponseDto, User> userDtoResponseMapper,
                                    JwtTokenProvider jwtTokenProvider) {
        this.authenticationService = authenticationService;
        this.userDtoResponseMapper = userDtoResponseMapper;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRegistrationRequestDto requestDto) {
        User user = authenticationService.register(requestDto.getEmail(), requestDto.getPassword());
        return userDtoResponseMapper.mapToDto(user);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid UserLoginRequestDto requestDto)
            throws AuthenticationException {
        User user = authenticationService.login(requestDto.getLogin(), requestDto.getPassword());
        String token = jwtTokenProvider.createToken(user.getEmail(), user.getRoles());
        return new ResponseEntity<>(Map.of("token", token), HttpStatus.OK);
    }
}
