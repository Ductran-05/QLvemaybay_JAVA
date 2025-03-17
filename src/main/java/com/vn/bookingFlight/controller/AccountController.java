package com.vn.bookingFlight.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vn.bookingFlight.dto.request.AccountRequest;
import com.vn.bookingFlight.dto.response.APIResponse;
import com.vn.bookingFlight.dto.response.AccountResponse;
import com.vn.bookingFlight.service.AccountService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<AccountResponse>> getAccountById(@PathVariable("id") Long id) {
        APIResponse<AccountResponse> apiResponse = APIResponse.<AccountResponse>builder()
                .Code(200)
                .Message("Get account by id")
                .data(accountService.getAccountByID(id))
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<AccountResponse>>> getAllAccounts() {
        APIResponse<List<AccountResponse>> apiResponse = APIResponse.<List<AccountResponse>>builder()
                .Code(200)
                .Message("Get all accounts")
                .data(accountService.getAllAccounts())
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }

    @PostMapping
    public ResponseEntity<APIResponse<AccountResponse>> createTaiKhoan(@RequestBody AccountRequest request) {
        APIResponse<AccountResponse> apiResponse = APIResponse.<AccountResponse>builder()
                .Code(201)
                .Message("Create account")
                .data(accountService.createAccount(request))
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<AccountResponse>> updateAccount(@PathVariable("id") Long id,
            @RequestBody AccountRequest request) {
        APIResponse<AccountResponse> apiResponse = APIResponse.<AccountResponse>builder()
                .Code(200)
                .Message("Update account by id")
                .data(accountService.updateAccount(id, request))
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Void>> deleteAccount(@PathVariable("id") Long id) {
        APIResponse<Void> apiResponse = APIResponse.<Void>builder()
                .Code(200)
                .Message("Delete account by id")
                .build();
        accountService.deleteAccount(id);
        return ResponseEntity.ok().body(apiResponse);
    }

}
