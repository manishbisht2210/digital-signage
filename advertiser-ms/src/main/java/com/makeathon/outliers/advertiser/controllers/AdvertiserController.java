package com.makeathon.outliers.advertiser.controllers;

import com.makeathon.outliers.advertiser.entity.Advertiser;
import com.makeathon.outliers.advertiser.services.AdvertiserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/advertiser")
@RequiredArgsConstructor
public class AdvertiserController {

    private final AdvertiserService advertiserService;

    @PostMapping(value = "/create", produces = "application/json")
    public Integer createAdvertiser(@RequestBody Advertiser advertiser) {
        return advertiserService.createAdvertiser(advertiser);
    }

    @PutMapping(value = "/update")
    public void updateAdvertiser(@RequestBody Advertiser advertiser) {
        advertiserService.updateAdvertiser(advertiser);
    }

    @GetMapping(value = "/get/{advertiserId}", produces = "application/json")
    public Advertiser getAdvertiser(@PathVariable("advertiserId") Integer advertiserId) {
        return advertiserService.getAdvertiser(advertiserId);
    }

}
