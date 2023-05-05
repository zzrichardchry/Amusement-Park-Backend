package com.team_nine.final_project.controller;

import com.team_nine.final_project.payload.InvoiceDto;
import com.team_nine.final_project.payload.VisitorDto;
import com.team_nine.final_project.payload.manage.InvoiceManageDto;
import com.team_nine.final_project.service.AuthorityService;
import com.team_nine.final_project.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author zhuhaotian
 * @Date 2023/5/5
 */

@RestController
@RequestMapping("api/invoice/manager")
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final AuthorityService authorityService;
    @Autowired
    public InvoiceController(InvoiceService invoiceService, AuthorityService authorityService) {
        this.invoiceService = invoiceService;
        this.authorityService = authorityService;
    }

    @GetMapping
    public ResponseEntity<List<InvoiceDto>> getAllInvoices(@RequestBody VisitorDto visitorDto) {
        authorityService.isManager(visitorDto);
        return ResponseEntity.ok(invoiceService.getAllInvoice());
    }

    @GetMapping("{id}")
    public ResponseEntity<InvoiceDto> getInvoiceById(@RequestBody VisitorDto visitorDto,
                                                     @PathVariable long id) {
        authorityService.isManager(visitorDto);
        return ResponseEntity.ok(invoiceService.getInvoiceById(id));
    }

//    @DeleteMapping("{id}")
//    public ResponseEntity<String> deleteInvoiceById(@RequestBody VisitorDto visitorDto,
//                                                    @PathVariable long id) {
//        authorityService.isManager(visitorDto);
//        invoiceService.deleteInvoiceById(id);
//        return ResponseEntity.ok("Invoice Entity Deleted Successfully.");
//    }
}
