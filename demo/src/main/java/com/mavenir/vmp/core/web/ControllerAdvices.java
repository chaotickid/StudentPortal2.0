package com.mavenir.vmp.core.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mavenir.vmp.rest.RestException;
import com.mavenir.vmp.security.handler.UserLoggedOutException;

/**
 * Controller advices.
 */
@ControllerAdvice
public class ControllerAdvices {

	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(ControllerAdvices.class);

	/**
	 * Adds string trimmer for request parameters.
	 *
	 * @param binder web data binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor("", true));
	}

	/**
	 * Logs error and returns '400 Bad Request' when mapping or validation error occurs.
	 *
	 * @param exception exception
	 */
	@ExceptionHandler({BadRequestException.class, BindException.class, HttpMessageConversionException.class, MethodArgumentNotValidException.class,
			ServletRequestBindingException.class, TypeMismatchException.class, DataIntegrityViolationException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public void handleBadRequest(Exception exception) {
		LOG.error("Bad request: {}", exception.getMessage());
	}

	/**
	 * Logs error and returns '400 Bad Request' when mapping or validation error occurs.
	 *
	 * @param exception exception
	 */
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public void handleNotFound(NotFoundException exception) {
		LOG.error("Not found: {}", exception.getMessage());
	}

	@ExceptionHandler(UserLoggedOutException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ResponseBody
	public void handleUserLoggedOut(UserLoggedOutException exception) {
		LOG.error("Access denied: {}", exception.getMessage());
	}

	@ExceptionHandler(RestException.class)
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ResponseBody
	public void handleRestException(RestException exception) {
		LOG.error("Unauthorized: {}", exception.getMessage());
	}

	/**
	 * Logs error and returns '500 Internal Server Error' when unexpected error occurs.
	 *
	 * @param exception exception
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public void handleInternalError(Exception exception) {
		LOG.error("Internal error", exception);
	}

	/**
	 * Handles access denied exception.
	 *
	 * @param exception the exception
	 */
	@ExceptionHandler(AccessDeniedException.class)
	public void handleAccessDeniedException(Exception exception) {
		LOG.error("AccessDeniedException", exception.getMessage());
	}

}
