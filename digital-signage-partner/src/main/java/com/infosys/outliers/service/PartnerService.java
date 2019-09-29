package com.infosys.outliers.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.infosys.outliers.entity.PartnerEntity;
import com.infosys.outliers.exception.UserIdNotPresentException;
import com.infosys.outliers.model.User;
import com.infosys.outliers.repository.PartnerRepository;

@Service
@Transactional
public class PartnerService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private PartnerRepository userRepository;

	public User register(User user) {

		// convert to entity
		PartnerEntity userEntity = new PartnerEntity();
		userEntity.setName(user.getName());
		userEntity.setPassword(passwordEncoder.encode(user.getPassword()));

		// persist
		userRepository.saveAndFlush(userEntity);
		
		user.setPassword(null);
		user.setId(userEntity.getPartnerId());
		
		return user;
	}

	public User getDetails(Integer id) {
		Optional<PartnerEntity> user = userRepository.findById(id);

		if (user.isPresent()) {
			User u = new User();
			u.setId(user.get().getPartnerId());
			u.setName(user.get().getName());
			return u;
		} else {
			throw new UserIdNotPresentException("");
		}
	}
}
