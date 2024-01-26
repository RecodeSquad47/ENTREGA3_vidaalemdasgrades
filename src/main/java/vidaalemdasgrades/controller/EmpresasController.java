package vidaalemdasgrades.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vidaalemdasgrades.model.Empresas;
import vidaalemdasgrades.repository.EmpresasRepository;

@Controller
@RequestMapping("/empresas")
public class EmpresasController {
	
	@Autowired
	private EmpresasRepository empresaRepository;
	
	@GetMapping
	public ModelAndView empresa() {
		ModelAndView modelAndView = new ModelAndView("views/usuarios/empresas.html");
		modelAndView.addObject("empresas", empresaRepository.findAll());
		
		modelAndView.addObject("empresa", new Empresas());
		
		return modelAndView;
}
	
	@PostMapping({"/cadastrar", "/{id}/editar"})
	public String cadastrar(Empresas empresa) { 
		empresaRepository.save(empresa);
		
		return "redirect:/empresas";
	}
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		empresaRepository.deleteById(id);
		
		return "redirect:/empresas";
	}
	
}
