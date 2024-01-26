package vidaalemdasgrades.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vidaalemdasgrades.model.Cursos;
import vidaalemdasgrades.repository.CursosRepository;

@Controller
@RequestMapping("/cursos")
public class CursosController {
	@Autowired
	private CursosRepository cursoRepository;
	
	@GetMapping
	public ModelAndView curso() {
		ModelAndView modelAndView = new ModelAndView("views/usuarios/cursos.html");
		modelAndView.addObject("cursos", cursoRepository.findAll());
		
		modelAndView.addObject("curso", new Cursos());
		
		return modelAndView;
	}
	@PostMapping({"/cadastrar", "/{id}/editar"})
	public String cadastrar(Cursos curso) {
		cursoRepository.save(curso);
		
		return "redirect:/cursos";
	}
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		cursoRepository.deleteById(id);
		
		return "redirect:/cursos";
	}
}
