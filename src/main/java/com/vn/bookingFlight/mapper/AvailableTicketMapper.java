package com.vn.bookingFlight.mapper;
import com.vn.bookingFlight.domain.AvailableTicket;
import com.vn.bookingFlight.dto.request.AvailableTicketRequest;
import com.vn.bookingFlight.dto.response.AvailableTicketResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface AvailableTicketMapper  {
    AvailableTicket toAvailableTicket(AvailableTicketRequest request);
    AvailableTicketResponse toAvailableTicketResponse(AvailableTicket ticket);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAvailableTicket(@MappingTarget AvailableTicket ticket, AvailableTicketRequest request);

}