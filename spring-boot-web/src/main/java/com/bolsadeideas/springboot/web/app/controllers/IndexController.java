package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@GetMapping({"/index","/","","/home"})
	public String index(Model model) {
		model.addAttribute("titulo","Hola Spring Framework con Model!");
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Nicole");
		usuario.setApellido("Sanhueza");
		usuario.setEmail("nicole.sanhueza@tinet.cl");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo","Perfil del usuario:".concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Usuario> usuarios = Arrays.asList(new Usuario("Nicole", "Sanhueza", "nicole.sanhueza@tinet.cl"),
				new Usuario("Luis", "Saez", "siulcrash@gmail.com"),
				new Usuario("Elizabeth", "Hinojosa", "elizabeth.hinojosa@usach.cl"),
				new Usuario("Rodrigo", "Rodriguez", "rodrigo.rodriguez.z@gmail.com"));
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("titulo", "Listado de Usuarios");
		return "listar";
	}
	
}
