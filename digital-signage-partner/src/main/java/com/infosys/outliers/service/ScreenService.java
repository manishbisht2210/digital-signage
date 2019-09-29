package com.infosys.outliers.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.outliers.entity.ScreenEntity;
import com.infosys.outliers.exception.ScreenNotFoundException;
import com.infosys.outliers.model.Screen;
import com.infosys.outliers.repository.PartnerRepository;
import com.infosys.outliers.repository.ScreenRepository;

@Service
@Transactional
public class ScreenService {
	
	@Autowired
	private ScreenRepository screenRepository;
	
	@Autowired
	private PartnerRepository partnerRepository;
	
	public List<Screen> getAllScreens() {
		
		List<Screen> screens = new ArrayList<>();
		List<ScreenEntity> allScreen = screenRepository.findAll();
		
		allScreen.forEach(s -> {
			Screen sc = new Screen();
			
			sc.setScreenId(s.getScreenId());
			sc.setPartnerId(s.getPartner().getPartnerId());
			sc.setCity(s.getCity());
			sc.setLocality(s.getLocality());
			sc.setLatitude(s.getLatitude());
			sc.setLongitude(s.getLongitude());
			
			screens.add(sc);
		});
		
		return screens; 
	}
	
	public List<Screen> getAllScreensPartners(Integer partnerId) {
		List<Screen> screens = new ArrayList<>();
		List<ScreenEntity> allScreen = screenRepository.findByPartnerPartnerId(partnerId);
		
		allScreen.forEach(s -> {
			Screen sc = new Screen();
			
			sc.setScreenId(s.getScreenId());
			sc.setPartnerId(s.getPartner().getPartnerId());
			sc.setCity(s.getCity());
			sc.setLocality(s.getLocality());
			sc.setLatitude(s.getLatitude());
			sc.setLongitude(s.getLongitude());
			
			screens.add(sc);
		});
		
		return screens; 
	}
	
	public Screen addScreen(Screen screen) {
		ScreenEntity se = new ScreenEntity();
		se.setPartner(partnerRepository.getOne(screen.getPartnerId()));
		se.setCity(screen.getCity());
		se.setLocality(screen.getLocality());
		se.setLatitude(screen.getLatitude());
		se.setLongitude(screen.getLongitude());
		
		screenRepository.saveAndFlush(se);
		
		screen.setScreenId(se.getScreenId());
		
		return screen;
	}
	
	public void deleteScreen(Integer screenId) {
		
		screenRepository.findById(screenId).orElseThrow(() -> new ScreenNotFoundException("Screen Not found"));
		
		screenRepository.deleteById(screenId);
	}
}
