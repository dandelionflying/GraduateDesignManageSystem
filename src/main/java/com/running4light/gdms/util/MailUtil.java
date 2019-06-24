package com.running4light.gdms.util;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.running4light.gdms.pojo.Findpswinfos;

public class MailUtil {
	
	public static String createLink(Findpswinfos infos,HttpServletRequest request) {
		  
	    String path=request.getContextPath();  
	      
	    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;  
	      
	    String resetPassHref = basePath + "/mail/findPassword?uid="+ infos.getUid() +"&id="+infos.getId() + "&token=" +infos.getToken();  
	      
	    String link = resetPassHref;  
	      
	    return link;
	}
}
