package com.safvan.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * Component class that handles unauthorized user access.
 */
@Component
public class InvalidUserAuthEntryPoint implements AuthenticationEntryPoint {
	/**
	 * Commences the handling of an unauthorized user access.
	 *
	 * @param request       The HTTP request.
	 * @param response      The HTTP response.
	 * @param authException The authentication exception that occurred.
	 * @throws IOException      If there is an I/O error during handling.
	 * @throws ServletException If there is a servlet-related exception.
	 */
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		// Send an error response with HTTP status code 401 (Unauthorized) and a message
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "UnAutherized USER !!");
	}

}
