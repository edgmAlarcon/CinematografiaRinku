package com.cine.rinku.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rinku")
public class HolaMundo {
	
	@RequestMapping("/holaMundo")
	String holaMundo() {
		return "Hola Mundo";
	}
}
