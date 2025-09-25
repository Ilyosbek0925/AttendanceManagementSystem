package school.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.web.filter.OncePerRequestFilter;
import school.exception.NotAcceptableException;
import school.service.auth.AuthenticationService;

import java.io.IOException;
import java.util.Date;

public class JwtTokenFilter extends OncePerRequestFilter {
    private final JwtTokenService jwtService;
    private final AuthenticationService authenticationService;

    public JwtTokenFilter(JwtTokenService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        String path = request.getRequestURI();


        String token = request.getHeader("authorization");
        if (token == null || !token.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        token = token.substring(7);
        Jws<Claims> claimsJws = jwtService.extractToken(token);
        Date expiration = claimsJws.getBody().getExpiration();
        if (new Date().after(expiration)) throw new NotAcceptableException("Expired access token!");
        authenticationService.authenticate(claimsJws.getBody(), request);

        filterChain.doFilter(request, response);
    }




}
