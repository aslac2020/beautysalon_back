package com.salaohair.api.controller;

import com.salaohair.api.dto.request.ClienteRequest;
import com.salaohair.api.dto.request.FinanceiroRequest;
import com.salaohair.api.dto.response.ClienteResponse;
import com.salaohair.api.dto.response.FinanceiroResponse;
import com.salaohair.api.services.FinanceiroService;
import com.salaohair.api.services.impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/financas")
public class FinanceiroController {

    @Autowired
    private FinanceiroService financeiroService;

    @GetMapping
    public ResponseEntity<List<FinanceiroResponse>> findAllFinances(){
        return new ResponseEntity<>(financeiroService.findAllFinances(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FinanceiroResponse> createFinaces(@RequestBody FinanceiroRequest request){
        return new ResponseEntity<>(financeiroService.createFinances(request), HttpStatus.OK);
    }

    @GetMapping("/{financeiroId}")
    public ResponseEntity<FinanceiroResponse>  findFinancesById(@PathVariable Long financeiroId){
        return new ResponseEntity<>(financeiroService.findFinancesById(financeiroId), HttpStatus.OK);
    }

    @PutMapping("/{financeiroId}")
    public ResponseEntity<FinanceiroResponse> updateFinances(@RequestBody FinanceiroRequest request, @PathVariable Long financeiroId ){
        return new ResponseEntity<>(financeiroService.updateFinances(financeiroId, request), HttpStatus.OK);
    }

    @DeleteMapping("/{financeiroId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long financeiroId ){
        financeiroService.deleteFinances(financeiroId);
        return ResponseEntity.noContent().build();
    }

}
