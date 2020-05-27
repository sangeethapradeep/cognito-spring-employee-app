package com.enkode.cognito.config;

import com.enkode.cognito.store.CognitoAccessTokenConverter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.jwk.JwkTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@EnableResourceServer
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerSecurityConfig extends ResourceServerConfigurerAdapter {

  private final ResourceServerProperties properties;

  public ResourceServerSecurityConfig(ResourceServerProperties properties) {
    this.properties = properties;
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.cors();

    http.csrf().disable();

    http.authorizeRequests()
            .antMatchers("/api/v1/public/**")
            .permitAll()
            .anyRequest()
            .authenticated();
  }

  @Bean
  public TokenStore jwkTokenStore() {
    return new JwkTokenStore(
        Collections.singletonList(properties.getJwk().getKeySetUri()),
        new CognitoAccessTokenConverter(),
        null);
  }

  @Bean
  public CorsFilter corsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();
    List<String> allowedMethods = Arrays.asList("OPTIONS", "GET", "POST", "PUT", "DELETE");

    config.setAllowCredentials(true);
    config.addAllowedOrigin("*");
    config.addAllowedHeader("*");
    config.setAllowedMethods(allowedMethods);
    source.registerCorsConfiguration("/**", config);

    return new CorsFilter(source);
  }

}
