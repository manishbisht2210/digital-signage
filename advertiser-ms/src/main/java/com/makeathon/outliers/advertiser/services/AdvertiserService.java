package com.makeathon.outliers.advertiser.services;

import com.makeathon.outliers.advertiser.entity.Advertiser;
import com.makeathon.outliers.advertiser.repositories.AdvertiserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdvertiserService {

    private final AdvertiserRepository advertiserRepository;

    public Integer createAdvertiser(Advertiser advertiser){
        return advertiserRepository.save(advertiser).getId();
    }

    public void updateAdvertiser(Advertiser advertiser){
        Advertiser advertiserEntity = advertiserRepository.findById(advertiser.getId()).orElse(null);
        advertiserEntity.setName(advertiser.getName());
        advertiserRepository.save(advertiserEntity);
    }

    public Advertiser getAdvertiser(Integer id){
        return advertiserRepository.findById(id).orElse(null);
    }
}
