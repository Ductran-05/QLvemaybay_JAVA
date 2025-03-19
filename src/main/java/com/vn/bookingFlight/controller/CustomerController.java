package com.vn.bookingFlight.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vn.bookingFlight.dto.request.CustomerRequest;
import com.vn.bookingFlight.dto.response.APIResponse;
import com.vn.bookingFlight.dto.response.CustomerResponse;
import com.vn.bookingFlight.service.CustomerService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping()
    public ResponseEntity<APIResponse<List<CustomerResponse>>> getAllCustomers() {
        APIResponse<List<CustomerResponse>> apiResponse = APIResponse.<List<CustomerResponse>>builder()
                .Code(200)
                .Message("Get all customers")
                .data(customerService.getAllCustomer())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<CustomerResponse>> getCustomerByID(@PathVariable("id") Long id) {
        APIResponse<CustomerResponse> apiResponse = APIResponse.<CustomerResponse>builder()
                .Code(200)
                .Message("Get customer by id")
                .data(customerService.getCustomerById(id))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping()
    public ResponseEntity<APIResponse<CustomerResponse>> createCustomer(@RequestBody CustomerRequest request) {
        APIResponse<CustomerResponse> apiResponse = APIResponse.<CustomerResponse>builder()
                .Code(201)
                .Message("Create customer")
                .data(customerService.createCustomer(request))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<CustomerResponse>> updateCustomer(@PathVariable String id,
            @RequestBody CustomerRequest request) {
        APIResponse<CustomerResponse> apiResponse = APIResponse.<CustomerResponse>builder()
                .Code(200)
                .Message("Update customer by id")
                .data(customerService.updateCustomer(Long.parseLong(id), request))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Void>> deleteCustomer(@PathVariable String id) {
        APIResponse<Void> apiResponse = APIResponse.<Void>builder()
                .Code(200)
                .Message("Delete customer by id")
                .build();
        customerService.deleteCustomer(Long.parseLong(id));
        return ResponseEntity.ok(apiResponse);
    }

}
