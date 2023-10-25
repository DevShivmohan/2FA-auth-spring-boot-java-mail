package com.mail.fa.controller;

import com.mail.fa.dto.*;
import com.mail.fa.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AuthenticationController {

    private final UserService userService;

    @PostMapping(value = "/sign-up", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "Creates a user account in the system")
    public ResponseEntity<?> userAccountCreationHandler(
            @RequestBody final UserAccountCreationRequestDto userAccountCreationRequestDto) {
        return userService.createAccount(userAccountCreationRequestDto);
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "Endpoint to authenticate users credentials")
    public ResponseEntity<?> userLoginHandler(
            @RequestBody final UserLoginRequestDto userLoginRequestDto) {
        return userService.login(userLoginRequestDto);
    }

    @PostMapping(value = "/verify-otp", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "verifies OTP and returns JWT corresponding to the user")
    public ResponseEntity<UserLoginSuccessDto> otpVerificationHandler(
            @RequestBody final OtpVerificationRequestDto otpVerificationRequestDto) {
        return userService.verifyOtp(otpVerificationRequestDto);
    }

    @PutMapping(value = "/refresh-token", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "Returns new access_token")
    public ResponseEntity<?> tokenRefresherHandler(
            @RequestBody final TokenRefreshRequestDto tokenRefreshRequestDto) {
        return userService.refreshToken(tokenRefreshRequestDto);
    }

}
