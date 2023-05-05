package com.team_nine.final_project.service.impl;

import com.team_nine.final_project.dao.TicketRepository;
import com.team_nine.final_project.entity.Ticket;
import com.team_nine.final_project.exception.ResourceNotFoundException;
import com.team_nine.final_project.payload.TicketDto;
import com.team_nine.final_project.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public TicketDto getTicketById(long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ticket", "id", id));
        return mapToDto(ticket);
    }

    private static TicketDto mapToDto(Ticket ticket) {
        TicketDto ret = new TicketDto();

        ret.setId(ticket.getId());
        ret.setMethod(ticket.getMethod());
        ret.setPrice(ticket.getPrice());

        return ret;
    }
}
