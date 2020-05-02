package com.msa_sample01.auth.server.config;

import java.security.KeyPair;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

@Configuration
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private ClientDetailsService clientDetailsService;
	
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
//	@Autowired
//    private MemberService userDetailsService;
//	
//	@Autowired
//    private TokenEnhancer jwtTokenEnhancer;
    
//	@Bean
//    public TokenStore tokenStore() {
//        return new JwtTokenStore(jwtAccessTokenConverter());
//    }

	/*
	 * JWT 토큰 인증키 설정
	 */
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource("server.jks"), "passtwo".toCharArray())
				.getKeyPair("auth", "passone".toCharArray());
		converter.setKeyPair(keyPair);		
		return converter;
		
//		파일시스템 사용 예시
//		KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new FileSystemResource("src/main/resources/oauth2jwt.jks"), "oauth2jwtpass".toCharArray());
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setKeyPair(keyStoreKeyFactory.getKeyPair("oauth2jwt"));
//        return converter;
	}
	
	/*
	 * 인증과정 Endpoint 설정
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		
		super.configure(endpoints);
		endpoints.accessTokenConverter(jwtAccessTokenConverter()).authenticationManager(authenticationManager);

		/*
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(jwtTokenEnhancer, jwtAccessTokenConverter));

        endpoints.tokenStore(tokenStore)                             //JWT
                .accessTokenConverter(jwtAccessTokenConverter)       //JWT
                .tokenEnhancer(tokenEnhancerChain)                   //JWT
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
        */
	}
	
	@Bean
	@Primary
	public JdbcClientDetailsService JdbcClientDetailsService(DataSource dataSource) {
		return new JdbcClientDetailsService(dataSource);
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		clients.withClientDetails(clientDetailsService);
		//clients.jdbc(dataSource).passwordEncoder(passwordEncoder);
	}
	
	
	/*
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private DefaultTokenServices tokenServices;

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Autowired
    private TokenEnhancer jwtTokenEnhancer;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(jwtTokenEnhancer, jwtAccessTokenConverter));

        endpoints.tokenStore(tokenStore)                             //JWT
                .accessTokenConverter(jwtAccessTokenConverter)       //JWT
                .tokenEnhancer(tokenEnhancerChain)                   //JWT
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
    }


//
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        // TODO persist clients details

    	//
    	//ClientDetailServiceconfigurer 클라스는 inMemory 타입과 JDBC 저장소를 지원
    	//withClient/secret 메소드 호출은 애클리케이션이 OAuth2 액세스 토큰을 받기 위해 제시할 시크릿과 애플리케이션 이름을 제공
    	//redirectUri : 인증 완료 후 이동할 클라이언트 웹 페이지 주소로 code 값을 실어 전달
    	//authorizedGrantTypes	:	
    	//	1) authorization_code :	Service Provider가 제공하는 인증 화면에 로그인하고
    	//							클라이언트 앱이 요청하는 리소스 접근 요청을 승인하면,
		//							지정한 redirect_uri로 code를 넘겨주는데. 해당 code로 access_token 획득
		// 2) implicit			  : Authorization Code와 비슷
		// 						redirect_uri로 직접 access_token을 획득하기에 authorization_code 에 비해 보안성 떨어짐
		// 3) password_credential: Resource Owner가 직접 Client에 아이디와 패스워드를 입력하고
		//							Authorization 서버에 해당 정보로 인증받아 access_token을 직접 얻어오는 방식
		//                         클라이언트에 ID/PW 노출로 보안이 떨어지기에 공식 애플리케이션에서만 사용
		// 4) client_credentials : access_token을 얻는데 정해진 인증 key(secret)로 요청하며, 일반적인 사용보다는 server 간 통신을 할 때 사용
		//scopes : 인증 후 얻은 accessToken으로 접근할 수 있는 리소스의 범위, resource서버(api서버)에서는 해당 scope정보로 클라이언트에게 제공할 리소스를 제한하거나 노출
		//accessTokenValiditySeconds : 발급된 accessToken의 유효시간(초) 
    	//
    	
        // @formatter:off
        clients.inMemory()
		        .withClient("testoauth2")
		        .secret(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("testoauth2"))
		        .authorizedGrantTypes("refresh_token", "password", "client_credentials")
		        .scopes("read", "write")
		        .accessTokenValiditySeconds(3600);
        // @formatter:on
    }

//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints
//                .authenticationManager(authenticationManager)		
//                .userDetailsService(userDetailsService);
//        
//        //Default Endpoint Path : 	authenticationManager : /oauth/token
//        //							userDetailsService	  : /user
//    }

    private final PasswordEncoder passwordEncoder;
    private final DataSource dataSource;
    private final MemberService userDetailService;
    
	@Value("${resouce.id:spring-boot-application}")
	private String resourceId;
	
	@Value("${access_token.validity_period:3600}")
	int accessTokenValiditySeconds = 3600;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }
	
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource("server.jks"), "passtwo".toCharArray())
				.getKeyPair("auth", "passone".toCharArray());
		converter.setKeyPair(keyPair);		
		return converter;
	}
	
	@Bean
	@Primary
	public DefaultTokenServices tokenService() {
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setTokenStore(tokenStore());
		defaultTokenServices.setSupportRefreshToken(true);
		return defaultTokenServices;
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		super.configure(endpoints);
        endpoints.accessTokenConverter(jwtAccessTokenConverter()).userDetailsService(userDetailService);
        
		//endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager).accessTokenConverter(jwtAccessTokenConverter());
	}
	
	@Bean
	@Primary
	public JdbcClientDetailsService JdbcClientDetailsService(DataSource dataSource) {
		return new JdbcClientDetailsService(dataSource);
	}
	
	@Autowired
	private ClientDetailsService clientDetailsService;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		//clients.withClientDetails(clientDetailsService);
		clients.jdbc(dataSource).passwordEncoder(passwordEncoder);
		
	}
	
	*/

}
