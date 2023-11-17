package com.example.tmdt.controller;

import com.example.tmdt.dto.BillDTO;
import com.example.tmdt.dto.BillDetailDTO;
import com.example.tmdt.dto.CartDetailDTO;
import com.example.tmdt.service.IBillDetailService;
import com.example.tmdt.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/billDetails")
public class BillDetailController {
    @Autowired
    private IBillDetailService billDetailService ;
    @Autowired
    private IBillService billService ;
    @GetMapping("/shop/{idAcc}")
    ResponseEntity<List<BillDetailDTO>> findBillDetail(@PathVariable Long idAcc ) {
        List<BillDetailDTO> billDetailDTOS = billDetailService.findByShop(idAcc);
        return new ResponseEntity<>(billDetailDTOS, HttpStatus.OK);
    }
    @GetMapping("/shop/bill/{idAcc}")
    ResponseEntity<List<BillDTO>> findBill(@PathVariable Long idAcc ) {
        List<BillDTO> billDTOS = billService.findByShop(idAcc);
        return new ResponseEntity<>(billDTOS, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{idBillDetail}")
    ResponseEntity<?> deleteByIdBillDetail(@PathVariable("idBillDetail") Long idBillDetail) {
        billDetailService.delete(idBillDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
