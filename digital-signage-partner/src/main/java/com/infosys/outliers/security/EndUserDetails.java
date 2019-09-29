package com.infosys.outliers.security;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.infosys.outliers.entity.PartnerEntity;
import com.infosys.outliers.repository.PartnerRepository;

@Component
@Transactional
public class EndUserDetails implements UserDetailsService {

	@Autowired
	private PartnerRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		// find the user
		Optional<PartnerEntity> userEntity = userRepository.findById(Integer.parseInt(username));

		// validate user availability
		if (!userEntity.isPresent()) {
			// throw Invalid login details exception
			throw new RuntimeException("Invalid Login Details Provided");
		}
		return new UserDetails() {

			private static final long serialVersionUID = 3414447359784878271L;

			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				return AuthorityUtils.commaSeparatedStringToAuthorityList("USER");
			}

			@Override
			public String getPassword() {
				return userEntity.get().getPassword();
			}

			@Override
			public String getUsername() {
				return Integer.toString(userEntity.get().getPartnerId());
			}

			@Override
			public boolean isAccountNonExpired() {
				return true;
			}

			@Override
			public boolean isAccountNonLocked() {
				return true;
			}

			@Override
			public boolean isCredentialsNonExpired() {
				return true;
			}

			@Override
			public boolean isEnabled() {
				return true;
			}
		};
	}
}
