package cn.bgenius.pconnect.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import hello.app.MyService;
//
@Controller
@RequestMapping(path="/demo")
public class DemoController {
//
//	private final MyService myService;
//
//    public DemoApplication(MyService myService) {
//        this.myService = myService;
//    }
//
//    @GetMapping("/")
//    public String home() {
//        return myService.message();
//    }
	@GetMapping("/")
	public String test() {
		return "test";
	}
}
