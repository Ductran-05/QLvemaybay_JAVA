package com.vn.bookingFlight.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vn.bookingFlight.Exception.AppException;
import com.vn.bookingFlight.Exception.ErrorCode;
import com.vn.bookingFlight.domain.Customer;
import com.vn.bookingFlight.dto.request.CustomerRequest;
import com.vn.bookingFlight.dto.response.CustomerResponse;
import com.vn.bookingFlight.mapper.CustomerMapper;
import com.vn.bookingFlight.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    public List<CustomerResponse> getAllCustomer() {
        return customerRepository.findAll().stream()
                .map(customerMapper::toCustomerResponse)
                .collect(Collectors.toList());
    }

    public CustomerResponse getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::toCustomerResponse)
                .orElseThrow(() -> new AppException(ErrorCode.CUSTOMER_NOT_EXISTED));
    }

    public CustomerResponse createCustomer(CustomerRequest request) {
        return customerMapper.toCustomerResponse(customerRepository.save(customerMapper.toCustomer(request)));
    }

    public CustomerResponse updateCustomer(Long id, CustomerRequest request) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.CUSTOMER_NOT_EXISTED));
        customerMapper.updateCustomer(customer, request);
        return customerMapper.toCustomerResponse(customerRepository.save(customer));
    }

    public void deleteCustomer(Long id) {
        customerRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.CUSTOMER_NOT_EXISTED));
        customerRepository.deleteById(id);
    }
}
