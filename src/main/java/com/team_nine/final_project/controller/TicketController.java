package com.team_nine.final_project.controller;

import com.team_nine.final_project.entity.Ticket;
import com.team_nine.final_project.payload.TicketDto;
import com.team_nine.final_project.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

@RestController
@RequestMapping("api/ticket")
public class TicketController {

    private final TicketService ticketService;
    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("{id}")
    public ResponseEntity<TicketDto> getTicketById(@PathVariable long id) {
        return new ResponseEntity<>(ticketService.getTicketById(id), HttpStatus.OK);
    }
}
