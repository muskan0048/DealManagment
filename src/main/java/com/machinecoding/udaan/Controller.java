package com.machinecoding.udaan;

import com.machinecoding.udaan.Request.ClaimDealRequest;
import com.machinecoding.udaan.Request.DealRequest;
import com.machinecoding.udaan.Request.UpdateDealRequest;
import com.machinecoding.udaan.Response.DealResponse;
import com.machinecoding.udaan.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {

    @Autowired
    DealService dealService;

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @PostMapping("/createDeal")
    public ResponseEntity createDeal(@RequestBody DealRequest dealRequest) {
        DealResponse response = dealService.createDeal(dealRequest);
        if(response.isSuccess()){
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return ResponseEntity.status(400).body(response);

    }

    @GetMapping("/endDeal")
    public ResponseEntity endDeal(@RequestParam int deal_id) {
        DealResponse response = dealService.endDeal(deal_id);
        if(response.isSuccess()){
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return ResponseEntity.status(400).body(response);

    }

    @PutMapping("/endDeal")
    public ResponseEntity updateDeal(@RequestBody UpdateDealRequest updateDealRequest) {
        DealResponse response = dealService.updateDeal(updateDealRequest);
        if(response.isSuccess()){
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return ResponseEntity.status(400).body(response);

    }

    @PostMapping("/claimDeal")
    public ResponseEntity claimDeal(@RequestBody ClaimDealRequest claimDealRequest) {
        DealResponse response = dealService.claimDeal(claimDealRequest);
        if(response.isSuccess()){
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return ResponseEntity.status(400).body(response);

    }
}
