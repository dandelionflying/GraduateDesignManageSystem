package com.running4light.gdms.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.running4light.gdms.common.StatusCode;
import com.running4light.gdms.pojo.Findpswinfos;
import com.running4light.gdms.pojo.Result;
import com.running4light.gdms.service.FindpswinfosService;
import com.running4light.gdms.service.ManagerService;
import com.running4light.gdms.service.StudentService;
import com.running4light.gdms.service.TeacherService;
import com.running4light.gdms.service.UserroleService;
import com.running4light.gdms.util.MailUtil;

@Controller
@RequestMapping("mail")
public class MailController {
	/*@Resource(name="javaMailSender")*/
	@Autowired
	private JavaMailSender javaMailSender;//注入有问题暂时这样用
	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private ManagerService managerService;
	@Autowired
	private UserroleService userroleService;
	@Autowired
	private FindpswinfosService findpswinfosService;
	/*@Value("#{mail.stmp.host}")
	private String host;
	@Value("#{mail.stmp.username}")
	private String username;
	@Value("#{mail.stmp.password}")
	private String password;
	@Value("#{mail.stmp.defaultEncoding}")
	private String defaultEncoding;*/
	/*@Value("mail.stmp.auth")
	private boolean auth;*/
	@ResponseBody
	@RequestMapping(value = "send",method = RequestMethod.POST)
	public Result forget(@RequestParam("uid")String uid,HttpServletRequest request) {
		MimeMessage mMessage=javaMailSender.createMimeMessage();//创建邮件对象
        MimeMessageHelper mMessageHelper;
        String toEmail = null;
      	toEmail = studentService.getEmailById(uid);
        if(toEmail==null) {
        	toEmail = teacherService.getEmailById(uid);
        	if(toEmail ==null) {
        		toEmail = managerService.getEmailById(uid);
        	}
        }
        if(toEmail==null) {
        	return new Result(false,StatusCode.EMPTYERROR,"该用户不存在");
        }
        Byte role = userroleService.selectByUid(uid).getRid();
        Properties prop = new Properties();
        String from;
        try {
            //从配置文件中拿到发件人邮箱地址
            prop.load(this.getClass().getResourceAsStream("/config/mail.properties"));
            String username = prop.getProperty("mail.smtp.username");
            from = username+"";
            mMessageHelper=new MimeMessageHelper(mMessage,true);
            mMessageHelper.setFrom(from);//发件人邮箱
            mMessageHelper.setTo(toEmail);//收件人邮箱
            mMessageHelper.setSubject("GDMS修改密码");//邮件的主题
            Findpswinfos findpswinfos = new Findpswinfos();
            findpswinfos.setUid(uid);
			// 过期时间
			Date outDate = new Date(System.currentTimeMillis() + 30 * 60 * 1000);// 30分钟后过期
			long date = outDate.getTime() / 1000 * 1000;// 忽略毫秒数 mySql 取出时间是忽略毫秒数的

			// 此处应该更新Studentinfo表中的过期时间、密钥信息
			findpswinfos.setTimeout(date);
			
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String token = encoder.encode(uid+date);
			/*String token = uid+date;*/
			findpswinfos.setToken(token);
			if(findpswinfosService.selectByUid(uid)==null) {
				findpswinfosService.insert(findpswinfos);
			}
			findpswinfosService.updateByPrimaryKey(findpswinfos);
			String link = MailUtil.createLink(findpswinfos, request)+"&role="+role;
			
            mMessageHelper.setText("<p>请勿回复本邮件.点击下面的链接,重设密码,本邮件超过30分钟,链接将会失效，需要重新申请找回密码.</p><br/>"
            		+ "<a href='"+link+"'>"+link+"</a>",true);//邮件的文本内容，true表示文本以html格式打开
            javaMailSender.send(mMessage);//发送邮件
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		}
        return new Result(true,StatusCode.OK,"已发送链接至邮箱，请查收。");
	}
	/**
	 * 找回密码
	 * @param uid
	 * @param id
	 * @param token
	 * @param role
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "findPassword",method = RequestMethod.GET)
	public String findPassword(@RequestParam("uid")String uid,@RequestParam("id")Integer id,
			@RequestParam("token")String token,@RequestParam("role") Integer role,
			HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		Findpswinfos findpswinfos = findpswinfosService.selectByPrimaryKey(id);
		
		if(findpswinfos==null) {
			return "error.html";
		}
		if(findpswinfos.getTimeout()<=System.currentTimeMillis()) {
			return "redirect:/error.html";
		}
		if(!token.equals(findpswinfos.getToken())) {
			return "redirect:/error.html";
		}else {
			return "redirect:/findPassword.html?uid="+uid+"&role="+role;
		}
	}
}
