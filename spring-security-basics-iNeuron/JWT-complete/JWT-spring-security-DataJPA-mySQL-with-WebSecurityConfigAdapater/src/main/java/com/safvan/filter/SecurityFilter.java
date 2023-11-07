package com.safvan.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.safvan.util.JwtUtil;

/**
 * The SecurityFilter class is responsible for handling JWT token validation and
 * authentication for incoming HTTP requests.
 */
@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * This method is automatically invoked for each incoming HTTP request.
     *
     * @param request     The incoming HTTP request.
     * @param response    The HTTP response to send.
     * @param filterChain The filter chain to continue processing the request.
     * @throws ServletException In case of servlet-related errors.
     * @throws IOException      In case of I/O errors.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 1: Read the JWT token from the Authorization Header
        String token = request.getHeader("Authorization");

        if (token != null) {
            // Perform validation if the token is not null
            String tokenUsername = jwtUtil.getUsername(token);

            // Ensure the username is not empty, and there is no existing authentication in the context
            if (tokenUsername != null &&
                    SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(tokenUsername);

                // Validate the Token, check for expiration, and verify that the database username and tokenUsername match
                String usernameFromDb = userDetails.getUsername();
                boolean isTokenValid = jwtUtil.isTokenValid(token, usernameFromDb);

                if (isTokenValid) {
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            tokenUsername,
                            userDetails.getPassword(),
                            userDetails.getAuthorities());

                    // Link the authentication token with the current request
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    // Connect the security context object
                    // The final object stored in SecurityContext with user details (username, password)
                    // Similar to a session, credentials are cross-verified for authentication from the SecurityContext Authentication object
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
        }
        // Continue processing the request
        filterChain.doFilter(request, response);
    }
}
