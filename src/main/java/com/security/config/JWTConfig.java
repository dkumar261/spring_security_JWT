package com.security.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.security.service.UserService;

@Configuration
@EnableAuthorizationServer
public class JWTConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Value(value = "varun.oath.tokenTimeout:3600")
	private int expiration;

	@Autowired
	private JwtAccessTokenConverter accessTokenConverter;

	private String signKey;

	@Autowired
	private TokenStore tokenStore;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter);
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {

		JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
		accessTokenConverter.setSigningKey("jwtdemo123");

		return accessTokenConverter;
	}

	public void configure(AuthorizationServerEndpointsConfigurer configurer) {
		TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
		List list = Arrays.asList(accessTokenConverter);
		configurer.tokenStore(tokenStore).accessTokenConverter(
				accessTokenConverter);
	}

	public void configure(ClientDetailsServiceConfigurer configurer)
			throws Exception {
		configurer.inMemory().withClient("varun").secret("secret")
				.accessTokenValiditySeconds(expiration).scopes("read", "write")
				.authorizedGrantTypes("password", "refresh_token");
	}
}
