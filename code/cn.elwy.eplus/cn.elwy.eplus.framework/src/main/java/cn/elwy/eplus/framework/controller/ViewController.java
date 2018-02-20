package cn.elwy.eplus.framework.controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.elwy.eplus.framework.support.ControllerSupport;
import cn.elwy.eplus.framework.util.ValidateCode;
import cn.elwy.eplus.framework.web.WebUtil;

/**
 * @description 视图控制类
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@Controller
public class ViewController {

	private static final String VALIDATE_CODE = "validateCode";

	public ViewController() {
		System.out.println("viewController");
	}

	@RequestMapping("/403")
	public ModelAndView _403(HttpServletRequest request) {
		ModelAndView mv = ControllerSupport.getView(request, "403");
		return mv;
	}

	@RequestMapping("/500")
	public ModelAndView _500(HttpServletRequest request) {
		ModelAndView mv = ControllerSupport.getView(request, "500");
		return mv;
	}

	@RequestMapping(value = "/v")
	public ModelAndView v(HttpServletRequest request) {
		ModelAndView mv = ControllerSupport.getView(request, "index");
		return mv;
	}

	@RequestMapping(value = "/v/{view}")
	public ModelAndView view(@PathVariable String view, HttpServletRequest request) {
		ModelAndView mv = ControllerSupport.getView(request, view);

		return mv;
	}

	/**
	 * 生成验证码
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/authcode")
	public void authcode(HttpServletRequest request, HttpServletResponse response) {
		int type = WebUtil.getInteger(request, "type", ValidateCode.TYPE_NUM_ONLY);
		int length = WebUtil.getInteger(request, "length", 6);
		int width = WebUtil.getInteger(request, "width", 100);
		int height = WebUtil.getInteger(request, "height", 26);

		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("image/jpeg");

		String verifyCode = ValidateCode.generateTextCode(type, length, "4");
		request.getSession().setAttribute(VALIDATE_CODE, verifyCode);
		BufferedImage image = ValidateCode.generateImageCode(verifyCode, width, height, 3, true, Color.WHITE, null, null);
		try {
			ImageIO.write(image, "JPEG", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
