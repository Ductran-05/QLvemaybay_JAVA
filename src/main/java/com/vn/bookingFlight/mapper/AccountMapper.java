package com.vn.bookingFlight.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.vn.bookingFlight.domain.Account;
import com.vn.bookingFlight.dto.request.AccountRequest;
import com.vn.bookingFlight.dto.response.AccountResponse;

@Mapper(componentModel = "Spring")
public interface AccountMapper {
    Account toAccount(AccountRequest request);

    AccountResponse toAccountResponse(Account entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAccount(@MappingTarget Account account, AccountRequest request);
}
