package vidaalemdasgrades.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vidaalemdasgrades.model.Projetos;
import vidaalemdasgrades.repository.ProjetosRepository;

@Controller
@RequestMapping("/projetos")
public class ProjetosController {
	
	@Autowired
	private ProjetosRepository projetoRepository;
	
	@GetMapping
	public ModelAndView projeto() {
		ModelAndView modelAndView = new ModelAndView("views/usuarios/projetos.html");
		modelAndView.addObject("projetos", projetoRepository.findAll());
		
		modelAndView.addObject("projeto", new Projetos());
		
		return modelAndView;
	}
	@PostMapping({"/cadastrar", "/{id}/editar"})
	public String cadastrar(Projetos projeto) {
		projetoRepository.save(projeto);
		
		return "redirect:/projetos";
	}
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		projetoRepository.deleteById(id);
		
		return "redirect:/projetos";
	}
}

