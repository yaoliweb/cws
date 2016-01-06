package cn.zj.sunda.water.util;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * ������������֤��
 *
 */
public class VerifyCodeServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		//��������������汾ҳ
		response.setHeader("Cache-Control", "no-cache");
		
		//�����֤�룬д���û�session
		String verifyCode=VerifyCode.generateTextCode(VerifyCode.TYPE_NUM_UPPER,4,"0oOilJI1");
		request.getSession().setAttribute("verifyCode",verifyCode);
		
		//�����֤���ͻ���
		response.setContentType("image/jpeg");
		BufferedImage bim=VerifyCode.generateImageCode(verifyCode, 90, 30, 2,true,Color.WHITE,Color.BLACK,null);

		ImageIO.write(bim, "JPEG",response.getOutputStream());	
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}



}
