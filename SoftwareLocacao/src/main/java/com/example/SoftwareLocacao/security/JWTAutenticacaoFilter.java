package com.example.SoftwareLocacao.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.SoftwareLocacao.models.UsuarioAdministrador;

public class JWTAutenticacaoFilter extends UsernamePasswordAuthenticationFilter {

        private AuthenticationManager authenticationManager;

        private JWTUtil jwtUtil;

        public JWTAutenticacaoFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
            this.authenticationManager = authenticationManager;
            this.jwtUtil = jwtUtil;
        }

        @Override
        public Authentication attemptAuthentication(HttpServletRequest request,
                                                    HttpServletResponse response) throws AuthenticationException {
            try {
                UsuarioAdministrador userCredentials = new ObjectMapper().readValue(request.getInputStream(), UsuarioAdministrador.class);

                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userCredentials.getNome(), userCredentials.getSenha(), new ArrayList<>());

                Authentication authentication = this.authenticationManager.authenticate(authToken);
                return authentication;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        protected void successfulAuthentication(HttpServletRequest request,
                                                HttpServletResponse response, FilterChain filterChain, Authentication authentication)
                throws IOException, ServletException {
            AdminSpringSecurity adminSpringSecurity = (AdminSpringSecurity) authentication.getPrincipal();
            String nome = adminSpringSecurity.getNome();
            String token = this.jwtUtil.generateToken(nome);
            response.addHeader("Authorization", "Bearer " + token);
            response.addHeader("access-control-expose-headers", "Authorization");
        }

    }
