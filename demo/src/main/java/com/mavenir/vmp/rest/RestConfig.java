package com.mavenir.vmp.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Configuration for REST clients
 */
@Configuration
public class RestConfig {

    /**
     * Returns client HTTP request factory.
     *
     * @return the client http request factory
     */
	/*@Bean
	public ClientHttpRequestFactory clientHttpRequestFactory() {
		return new HttpComponentsClientHttpRequestFactory(createHttpClient());
	}

	*//**
     * Returns new HTTP client.
     *
     * @return the http client
     *//*
	private static CloseableHttpClient createHttpClient() {
		return HttpClients.custom()
				.setSSLSocketFactory(createSocketFactory())
				.build();
	}

	*//**
     * Returns new SSL context.
     *
     * @return the SSL context
     *//*
	private static SSLContext createSocketFactory() {
		try {
			return SSLContextBuilder.create()
					.loadTrustMaterial((chain, authType) -> true) // Accept all certificates
					.build();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Error initializing SSLContext", e);
		}
	}*/

    /**
     * Returns REST template.
     *
     * @return the rest template
     */
    @Bean
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        RestTemplate rest = new RestTemplate(factory);
        rest.setErrorHandler(new ErrorHandler());
        return rest;
    }

    /**
     * Error handler.
     */
    private static final class ErrorHandler extends DefaultResponseErrorHandler {

        @Override
        public void handleError(ClientHttpResponse response) throws IOException {
            // If any of the following errors get back in response, don't do anything about it
            // We will use error code in response to show error on front end
            if (response.getStatusCode() == HttpStatus.BAD_REQUEST ||
                    response.getStatusCode() == HttpStatus.NOT_FOUND ||
                    response.getStatusCode() == HttpStatus.GATEWAY_TIMEOUT ||
                    response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR ||
                    response.getStatusCode() == HttpStatus.BAD_GATEWAY) {
                return;
            }
            try {
                super.handleError(response);
            } catch (HttpClientErrorException e) {
                throw new RestException(false, e);
            } catch (HttpServerErrorException e) {
                throw new RestException(true, e);
            }
        }
    }
}