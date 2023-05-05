package com.team_nine.final_project.service.impl;

import com.team_nine.final_project.dao.InvoiceRepository;
import com.team_nine.final_project.entity.Invoice;
import com.team_nine.final_project.exception.ResourceNotFoundException;
import com.team_nine.final_project.payload.InvoiceDto;
import com.team_nine.final_project.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author zhuhaotian
 * @Date 2023/5/5
 */

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    @Autowired
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<InvoiceDto> getAllInvoice() {
        return invoiceRepository.findAll().stream()
                .map(InvoiceServiceImpl::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public InvoiceDto getInvoiceById(long id) {
        Invoice invoice = invoiceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invoice", "id", id));
        return mapToDto(invoice);
    }

//    @Override
//    public void deleteInvoiceById(long id) {
//        Invoice invoice = invoiceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invoice", "id", id));
//        invoiceRepository.delete(invoice);
//    }

    private static InvoiceDto mapToDto(Invoice invoice) {
        InvoiceDto ret = new InvoiceDto();

        ret.setId(invoice.getId());
        ret.setDateTime(invoice.getDateTime());
        ret.setAmount(invoice.getAmount());
        ret.setParkingId(invoice.getParkingId());

        return ret;
    }

    private static Invoice mapToEntity(InvoiceDto invoiceDto) {
        Invoice ret = new Invoice();

        ret.setId(invoiceDto.getId());
        ret.setDateTime(invoiceDto.getDateTime());
        ret.setAmount(invoiceDto.getAmount());
        ret.setParkingId(invoiceDto.getParkingId());

        return ret;
    }
}
