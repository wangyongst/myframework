package com.framework.base.login;

/**
 * Created by BHWL on 2017-04-11.
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p><b>AuthImageServlet Description:</b> (验证码)</p>
 * <b>DATE:</b> 2016年6月2日 下午3:53:12
 */
public class AuthImageServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    static final long serialVersionUID = 1L;

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        Properties prop = new Properties();// 属性集合对象
        InputStream fis = this.getClass().getResourceAsStream("/properties/boot.login.properties");// 属性文件输入流
        try {
            prop.load(fis);// 将属性文件流装载到Properties对象中
            fis.close();// 关闭流
        } catch (Exception e) {
            e.printStackTrace();
        }
        String width = prop.getProperty("authImage.width");
        String height = prop.getProperty("authImage.height");
        String size = prop.getProperty("authImage.size");
        String yawpRate = prop.getProperty("authImage.yawpRate");

        //生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(Integer.parseInt(size));
        //存入会话session
        HttpSession session = request.getSession(true);
        //删除以前的
        session.removeAttribute("verCode");
        session.setAttribute("verCode", verifyCode.toLowerCase());
        //生成图片
        int w = Integer.parseInt(width), h = Integer.parseInt(height);
        VerifyCodeUtils.outputImage(Float.parseFloat(yawpRate),w, h, response.getOutputStream(), verifyCode);

    }
}