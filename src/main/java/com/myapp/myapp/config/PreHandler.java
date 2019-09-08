package com.myapp.myapp.config;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.UrlPathHelper;

import com.myapp.myapp.model.User;
import com.myapp.myapp.repository.UserRepository;

@Component
public class PreHandler implements HandlerInterceptor {

	@Autowired
	UserRepository userRepo;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		final String authorization = request.getHeader("Authorization");
		String resourcePath = new UrlPathHelper().getPathWithinApplication(request);
		if (resourcePath.startsWith("/customer") || resourcePath.startsWith("/hni")) 
			return true;
		if (authorization != null && authorization.toLowerCase().startsWith("basic")) {
			// Authorization: Basic base64credentials
			String base64Credentials = authorization.substring("Basic".length()).trim();
			byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
			String credentials = new String(credDecoded, StandardCharsets.UTF_8);
			// credentials = username:password
			final String[] values = credentials.split(":", 2);

			if (values.length != 2) {
				return setUnAuthenicatedResponseAndReturnFalse(response);
			}
			Optional<User> userOptional = userRepo.findById(values[0]);

			if (!userOptional.isPresent()) {
				return setUnAuthenicatedResponseAndReturnFalse(response);
			}

			User user = userOptional.get();

			if (user.getPassword().equals(values[1])) {
				request.setAttribute("user", user);
				return true;
			} else {
				return setUnAuthenicatedResponseAndReturnFalse(response);
			}
		} else {
			return setUnAuthenicatedResponseAndReturnFalse(response);
		}
	}

	public boolean setUnAuthenicatedResponseAndReturnFalse(HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		return false;
	}

}
