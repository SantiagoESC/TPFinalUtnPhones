package edu.utn.phones.Session;

import edu.utn.phones.Domain.Enums.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class SessionFilterBackoffice extends OncePerRequestFilter {

    @Autowired
    private SessionManager sessionManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String sessionToken = request.getHeader("Authorization");
        Session session = sessionManager.getSession(sessionToken);
        if (null != session ) {
            if (session.getLoggedUser().getUserType().equals(UserType.EMPLOYEE)){
                filterChain.doFilter(request, response);
            }else {
                response.setStatus(HttpStatus.FORBIDDEN.value());
            }

        } else {
            response.setStatus(HttpStatus.FORBIDDEN.value());
        }
    }
}