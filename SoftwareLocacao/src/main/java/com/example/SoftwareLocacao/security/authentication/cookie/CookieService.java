package com.example.SoftwareLocacao.security.authentication.cookie;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Optional;

public class CookieService {
    public static void setCookie(HttpServletResponse response, String key, String valor, int segundos) throws IOException {
        Cookie cookie = new Cookie(key, URLEncoder.encode(valor, StandardCharsets.UTF_8));
        cookie.setMaxAge(segundos);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

    }

    public static String getCookie(HttpServletRequest request, String key){
        String valor = Optional.ofNullable(request.getCookies())
                .flatMap(cookies -> Arrays.stream(cookies)
                        .filter(cookie -> key.equals(cookie.getName()))
                        .findAny()
                ).map(Cookie::getValue) // original (e -> e.getValue())
                .orElse(null);
        if(valor != null){
            valor = URLDecoder.decode(valor, StandardCharsets.UTF_8);
        }
        return valor;
    }

}