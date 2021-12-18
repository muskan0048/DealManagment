package com.machinecoding.udaan.service;

import com.machinecoding.udaan.Request.ClaimDealRequest;
import com.machinecoding.udaan.Request.DealRequest;
import com.machinecoding.udaan.Request.UpdateDealRequest;
import com.machinecoding.udaan.Response.DealResponse;
import com.machinecoding.udaan.models.Deal;
import com.machinecoding.udaan.models.User;
import com.machinecoding.udaan.repositories.DealRepository;
import com.machinecoding.udaan.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class DealService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    DealRepository dealRepository;

    public DealResponse createDeal(DealRequest dealRequest){
        boolean result = false;
        Deal deal = validateDealRequest(dealRequest);
        if(deal!=null){
            dealRepository.save(deal);
            result = true;
        }
        DealResponse response = new DealResponse();
        if(result){
            response.setMessage("Deal Created Successfully");
            response.setSuccess(true);
        }else {
            response.setMessage("Couldn't Create Deal");
            response.setSuccess(false);
        }
        return response;
    }

    private Deal validateDealRequest(DealRequest dealRequest){
        Deal deal = new Deal();
        if(!dealRequest.getDeal_name().isEmpty()){
            deal.setDeal_name(dealRequest.getDeal_name());
        }
        if(dealRequest.getDeal_id()>0){
            deal.setDeal_id(dealRequest.getDeal_id());
        }

        if(dealRequest.getMaxAllowedDeal()>0){
            deal.setMaxAllowedDeal(dealRequest.getMaxAllowedDeal());
        }

        if(dealRequest.getStartTime().isAfter(LocalDateTime.now()) || dealRequest.getStartTime().equals(LocalDateTime.now())){
            deal.setStartTime(dealRequest.getStartTime());
        }

        if(dealRequest.getEndTime().isAfter(LocalDateTime.now())){
            deal.setEndTime(dealRequest.getEndTime());
        }

        deal.setCurrentDeal(0);

        return deal;
    }

    public DealResponse endDeal(int deal_id){
        boolean result = false;
        DealResponse response = new DealResponse();
        Optional<Deal> deal = dealRepository.findById(deal_id);
        if(deal.isPresent()){
            Deal dealObject = deal.get();
            dealObject.setEndTime(LocalDateTime.now());
            dealRepository.save(dealObject);
            result = true;
        }

        if(result){
            response.setMessage("Deal Ended Successfully");
            response.setSuccess(true);
        }else {
            response.setMessage("Couldn't End Deal");
            response.setSuccess(false);
        }
        return response;
    }

    public DealResponse updateDeal(UpdateDealRequest updateDealRequest){
        DealResponse response = new DealResponse();
        Deal deal = null;
        if(dealRepository.findById(updateDealRequest.getDeal_id()).isPresent()){
            deal = dealRepository.findById(updateDealRequest.getDeal_id()).get();
            if(updateDealRequest.getNo_of_items()>0)
               deal.setMaxAllowedDeal(updateDealRequest.getNo_of_items());
            else if(updateDealRequest.getEnd_time()!=null)
                deal.setEndTime(updateDealRequest.getEnd_time());

            dealRepository.save(deal);
            response.setMessage("Deal details Updated Successfully");
            response.setSuccess(true);
        }else{
            response.setMessage("Can't Find Deal");
            response.setSuccess(false);
        }

        return response;
    }

    public DealResponse claimDeal(ClaimDealRequest claimDealRequest){
        DealResponse response = new DealResponse();
        User user = null;
        if(userRepository.findById(claimDealRequest.getUser_id()).isPresent()){
            user = userRepository.findById(claimDealRequest.getUser_id()).get();
        }

        Deal deal = null;

        if(dealRepository.findById(claimDealRequest.getDeal_id()).isPresent()){
            deal = dealRepository.findById(claimDealRequest.getDeal_id()).get();
        }

        if(user!=null && deal!=null){
            if(user.getClaimedDeals().contains(deal.getDeal_id())){
                response.setMessage("Deal Already Claimed");
                response.setSuccess(false);
            }else if(deal.getCurrentDeal()>=deal.getMaxAllowedDeal()){
                response.setMessage("Deal Completely Claimed");
                response.setSuccess(false);
            }else if(deal.getEndTime().isBefore(LocalDateTime.now())){
                response.setMessage("Deal Time Over");
                response.setSuccess(false);
            }else {
                user.getClaimedDeals().add(deal.getDeal_id());
                userRepository.save(user);
                deal.setCurrentDeal(deal.getCurrentDeal()+1);
                dealRepository.save(deal);
                response.setMessage("Deal Claimed Successfully");
                response.setSuccess(true);
            }
        }else{
            response.setMessage("Invalid Deal or User");
            response.setSuccess(false);
        }
        return response;
    }

}
