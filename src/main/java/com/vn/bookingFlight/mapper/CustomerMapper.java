package com.vn.bookingFlight.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.vn.bookingFlight.domain.Customer;
import com.vn.bookingFlight.dto.request.CustomerRequest;
import com.vn.bookingFlight.dto.response.CustomerResponse;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toCustomer(CustomerRequest request);

    CustomerResponse toCustomerResponse(Customer entity);

    void updateCustomer(@MappingTarget Customer customer, CustomerRequest request);
}