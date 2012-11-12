package br.com.fiap.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Util {
	public static boolean isSessionValid(HttpServletRequest req){
        Cookie cookies[] = req.getCookies(); 
		Cookie cookie = null;  
        if (cookies != null) {
        	for (Cookie ck : cookies) {  
                if (ck.getName() != null && ck.getName().equals("entrou") && !ck.getValue().equalsIgnoreCase(null)) {  
                    cookie = ck;  
                }  
            }  
        } 
        
		return cookie != null;
	}
	
	public static void deleteCookie(HttpServletRequest req, HttpServletResponse response){
        Cookie cookies[] = req.getCookies(); 
        if (cookies != null) {
        	for (Cookie ck : cookies) {  
                if (ck.getName() != null && ck.getName().equals("entrou")) {   
                    ck.setMaxAge(0);
                    ck.setValue(null);
                }  
            }  
        } 
	}
}
