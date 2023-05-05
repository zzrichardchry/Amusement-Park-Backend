package com.team_nine.final_project.service.impl;

import com.team_nine.final_project.dao.*;
import com.team_nine.final_project.entity.*;
import com.team_nine.final_project.exception.ResourceNotFoundException;
import com.team_nine.final_project.payload.VisitorActivityDto;
import com.team_nine.final_project.payload.VisitorDto;
import com.team_nine.final_project.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

@Service
public class VisitorServiceImpl implements VisitorService {

    private final VisitorRepository visitorRepository;
    private final ShowTicketRepository showTicketRepository;
    private final ParkingRepository parkingRepository;
    private final StoreOrderRepository storeOrderRepository;
    private final TicketRepository ticketRepository;
    private final AttractionTicketRepository attractionTicketRepository;
    private final InvoiceRepository invoiceRepository;
    @Autowired
    public VisitorServiceImpl(VisitorRepository visitorRepository, ShowTicketRepository showTicketRepository, ParkingRepository parkingRepository, StoreOrderRepository storeOrderRepository, TicketRepository ticketRepository, AttractionTicketRepository attractionTicketRepository, InvoiceRepository invoiceRepository) {
        this.visitorRepository = visitorRepository;
        this.showTicketRepository = showTicketRepository;
        this.parkingRepository = parkingRepository;
        this.storeOrderRepository = storeOrderRepository;
        this.ticketRepository = ticketRepository;
        this.attractionTicketRepository = attractionTicketRepository;
        this.invoiceRepository = invoiceRepository;
    }


    @Override
    public List<VisitorDto> getAllVisitors() {
        return visitorRepository.findAll().stream()
                .map(VisitorServiceImpl::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public VisitorDto getVisitorById(long id) {
        Visitor visitor = visitorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Visitor", "id", id));
        return mapToDto(visitor);
    }

    @Override
    public VisitorActivityDto getVisitorActivityById(long id) {
        Visitor visitor = visitorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Visitor", "id", id));

        VisitorActivityDto visitorActivityDto = new VisitorActivityDto();
        visitorActivityDto.setId(visitor.getId());
        visitorActivityDto.setVisitorType(visitor.getVisitorType());

        // Add all show_id to the dto
        List<ShowTicket> allShowTickets = showTicketRepository.findByVisitorId(id);
        visitorActivityDto.setShowIds(allShowTickets.stream()
                .map(ShowTicket::getShowId)
                .collect(Collectors.toSet()));
        Set<Long> invoiceIds = allShowTickets.stream()
                .map(ShowTicket::getInvoiceId).collect(Collectors.toSet());

        // Add all parking_id to the dto
        List<Parking> allParking = parkingRepository.findByVisitor(visitor);
        visitorActivityDto.setParkingIds(allParking.stream()
                .map(Parking::getId)
                .collect(Collectors.toSet()));
        invoiceIds.addAll(allParking.stream()
                .map(Parking::getInvoiceId)
                .collect(Collectors.toSet()));

        // Add all order_id to the dto
        List<StoreOrder> allStoreOrders = storeOrderRepository.findByVisitorId(id);
        visitorActivityDto.setOrderIds(allStoreOrders.stream()
                .map(StoreOrder::getId)
                .collect(Collectors.toSet()));
        invoiceIds.addAll(allStoreOrders.stream()
                .map(StoreOrder::getInvoiceId)
                .collect(Collectors.toSet()));

        // Add all tk_id to the dto
        List<Ticket> allTickets = ticketRepository.findByVisitorId(id);
        visitorActivityDto.setTicketIds(allTickets.stream()
                .map(Ticket::getId)
                .collect(Collectors.toSet()));
        invoiceIds.addAll(allTickets.stream()
                .map(Ticket::getInvoiceId)
                .collect(Collectors.toSet()));

        // Add all a_id to the dto
        visitorActivityDto.setAttractionIds(allTickets.stream()
                .map(Ticket::getId)
                .flatMap(ticketId -> attractionTicketRepository.findByTicketId(id).stream())
                .map(AttractionTicket::getAttractionId)
                .collect(Collectors.toSet()));

        // Add all invoice to the dto
        visitorActivityDto.setInvoiceIds(invoiceIds);

        // Calculate the total amount
        visitorActivityDto.setAmount(invoiceIds.stream()
                .map(invoiceRepository::findById)
                .map(o -> {
                    if (!o.isPresent()) throw new ResourceNotFoundException("Invoice", "visitor id", id);
                    return o.get();
                })
                .mapToDouble(Invoice::getAmount)
                .sum());

        return visitorActivityDto;
    }

    private static VisitorDto mapToDto(Visitor visitor) {
        VisitorDto ret = new VisitorDto();

        ret.setId(visitor.getId());
        ret.setFirstName(visitor.getFirstName());
        ret.setLastName(visitor.getLastName());
        ret.setEmail(visitor.getEmail());
        ret.setPhoneNumber(visitor.getPhoneNumber());
        ret.setStreet(visitor.getStreet());
        ret.setCity(visitor.getCity());
        ret.setState(visitor.getState());
        ret.setZipcode(visitor.getZipcode());
        ret.setCountry(visitor.getCountry());
        ret.setVisitorType(visitor.getVisitorType());

        return ret;
    }

    private static Visitor mapToEntity(VisitorDto visitorDto) {
        Visitor ret = new Visitor();

        ret.setId(visitorDto.getId());
        ret.setFirstName(visitorDto.getFirstName());
        ret.setLastName(visitorDto.getLastName());
        ret.setEmail(visitorDto.getEmail());
        ret.setPhoneNumber(visitorDto.getPhoneNumber());
        ret.setStreet(visitorDto.getStreet());
        ret.setCity(visitorDto.getCity());
        ret.setState(visitorDto.getState());
        ret.setZipcode(visitorDto.getZipcode());
        ret.setCountry(visitorDto.getCountry());
        ret.setVisitorType(visitorDto.getVisitorType());

        return ret;
    }
}
