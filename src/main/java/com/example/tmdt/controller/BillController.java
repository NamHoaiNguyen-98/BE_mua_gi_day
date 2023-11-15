package com.example.tmdt.controller;

import com.example.tmdt.dto.BillDTO;
import com.example.tmdt.model.buyPrd.BillDetail;
import com.example.tmdt.service.IBillDetailService;
import com.example.tmdt.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/bills")
public class BillController {
    @Autowired
    private IBillService billService;
    @Autowired
    private IBillDetailService billDetailService;

//    @PostMapping
//    ResponseEntity<?> save(@RequestBody BillDTO billDTO) {
//        billService.save(billDTO);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
    @PostMapping
    ResponseEntity<?> addToBill (@RequestBody List<Long> idCartDetail) {
        billDetailService.addToBill(idCartDetail);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("/accept")
    public ResponseEntity<?> accept (@RequestBody List<BillDetail> billDetails) {
        billService.accept(billDetails);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("/rejection")
    public ResponseEntity<?> rejection (@RequestBody List<BillDetail> billDetails , @RequestParam String reason) {
        billService.rejection(billDetails ,reason);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
