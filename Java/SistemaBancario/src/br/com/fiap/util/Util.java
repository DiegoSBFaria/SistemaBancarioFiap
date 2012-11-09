package br.com.fiap.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Util {
	public static boolean isSessionValid(HttpServletRequest req){
        Cookie cookies[] = req.getCookies(); 
		Cookie cookie = null;  
        if (cookies != null) {
        	for (Cookie ck : cookies) {  
                if (ck.getName() != null && ck.getName().equals("entrou")) {  
                    cookie = ck;  
                }  
            }  
        } 
        
		return cookie != null;
	}
}
