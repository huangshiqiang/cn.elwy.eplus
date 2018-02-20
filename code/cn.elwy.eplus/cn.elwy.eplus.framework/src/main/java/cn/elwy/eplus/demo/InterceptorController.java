package cn.elwy.eplus.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
public class InterceptorController {

	@RequestMapping("/random1")
	public ResponseEntity<Map> random1(HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key", "random1");
		map.put("value", new Random().nextInt(100));
		session.setAttribute("map1", map);
		return new ResponseEntity<Map>(map, HttpStatus.OK);
	}

	@RequestMapping("/random2")
	public ResponseEntity<Map> random2(HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key", "random2");
		map.put("value", new Random().nextInt(100));
		session.setAttribute("map2", map);
		return new ResponseEntity<Map>(map, HttpStatus.OK);
	}

	@RequestMapping("/error1")
	public Object error1() {
		return "error,无权限！";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(InterceptorController.class, args);
	}
}
