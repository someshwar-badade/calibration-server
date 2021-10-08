package com.examserver.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.examserver.service.impl.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String requestTokenHandler = request.getHeader("Authorization");
		System.out.println("token:" + requestTokenHandler);

		String username = null;
		String jwtToken = null;
		if (requestTokenHandler != null && requestTokenHandler.startsWith("Bearer ")) {
			try {
				jwtToken = requestTokenHandler.substring(7);

				try {
					username = this.jwtUtil.extractUsername(jwtToken);
				} catch (ExpiredJwtException e) {
					e.printStackTrace();
					System.out.println("Token expired!!");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Error");
				}

			} catch (Exception e) {

			}

		} else {
			System.out.println("Invalid token");
		}

		// validate
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			final UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(username);
			if (this.jwtUtil.validateToken(jwtToken, userDetails)) {
				// token is valid
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());

				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		} else {
			System.out.println("Invalid token!!");
		}

		filterChain.doFilter(request, response);
	}

}
