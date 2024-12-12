//package com.mavenir.vmp.rest;
//
//import java.io.IOException;
//
//import javax.net.ssl.SSLContext;
//
//import org.apache.http.client.CredentialsProvider;
//import org.apache.http.client.HttpClient;
//import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
//import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.conn.ssl.SSLContexts;
//import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.client.ClientHttpRequestFactory;
//import org.springframework.http.client.ClientHttpResponse;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.web.client.DefaultResponseErrorHandler;
//import org.springframework.web.client.HttpClientErrorException;
//import org.springframework.web.client.HttpServerErrorException;
//import org.springframework.web.client.RestTemplate;
//
//import com.google.common.base.Throwables;
//
///**
// * Configuration for REST clients.
// */
//@Configuration
//public class RestConfig {
//
//	/**
//	 * Returns client HTTP request factory.
//	 *
//	 * @param provider credentials provider
//	 * @return the client http request factory
//	 */
//	//@Bean
//	public ClientHttpRequestFactory clientHttpRequestFactory(CredentialsProvider provider) {
//		return new HttpComponentsClientHttpRequestFactory();
//	}
//
//	/**
//	 * Returns new HTTP client.
//	 *
//	 * @param provider credentials provider
//	 * @return the http client
//	 */
//	private static HttpClient createHttpClient(CredentialsProvider provider) {
//		return HttpClientBuilder.create().setSSLSocketFactory(createSocketFactory()).setDefaultCredentialsProvider(provider).build();
//	}
//
//	/**
//	 * Returns new socket factory.
//	 *
//	 * @return the layered connection socket factory
//	 */
//	private static LayeredConnectionSocketFactory createSocketFactory() {
//		SSLContext context = createSslContext();
//		AllowAllHostnameVerifier verifier = new AllowAllHostnameVerifier();
//		return new SSLConnectionSocketFactory(context, verifier);
//	}
//
//	/**
//	 * Returns new SSL context.
//	 *
//	 * @return the SSL context
//	 */
//	private static SSLContext createSslContext() {
//		try {
//			return SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).useSSL().build();
//		} catch (Exception e) {
//			throw Throwables.propagate(e);
//		}
//	}
//
//	/**
//	 * Returns REST template.
//	 *
//	 * @param clientHttpRequestFactory client HTTP request factory
//	 * @return the rest template
//	 */
//	@Bean
//	public RestTemplate restTemplate(ClientHttpRequestFactory clientHttpRequestFactory) {
//		RestTemplate rest = new RestTemplate(clientHttpRequestFactory);
//		rest.setErrorHandler(new ErrorHandler());
//		return rest;
//	}
//
//	/**
//	 * Error handler.
//	 */
//	private static final class ErrorHandler extends DefaultResponseErrorHandler {
//
//		@Override
//		public void handleError(ClientHttpResponse response) throws IOException {
//			// If any of the following errors get back in response, don't do anything about it
//			// We will use error code in response to show error on front end
//			if (response.getStatusCode() == HttpStatus.BAD_REQUEST ||
//					response.getStatusCode() == HttpStatus.NOT_FOUND ||
//					response.getStatusCode() == HttpStatus.GATEWAY_TIMEOUT ||
//					response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR ||
//					response.getStatusCode() == HttpStatus.BAD_GATEWAY) {
//				return;
//			}
//			try {
//				super.handleError(response);
//			} catch (HttpClientErrorException e) {
//				throw new RestException(false, e);
//			} catch (HttpServerErrorException e) {
//				throw new RestException(true, e);
//			}
//		}
//
//	}
//
//}
