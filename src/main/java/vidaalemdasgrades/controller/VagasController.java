package vidaalemdasgrades.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vidaalemdasgrades.model.Vagas;
import vidaalemdasgrades.repository.VagasRepository;


@Controller
@RequestMapping("/vagas")
public class VagasController {
	@Autowired
	private VagasRepository vagaRepository;
	
	@GetMapping
	public ModelAndView vaga() {
		ModelAndView modelAndView = new ModelAndView("views/usuarios/vagas.html");
		modelAndView.addObject("vagas", vagaRepository.findAll());
		return modelAndView;
}
	@PostMapping({"/cadastrar", "/{id}/editar"})
	public String cadastrar(Vagas vaga) {
		vagaRepository.save(vaga);
		
		return "redirect:/vagas";
	}
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		vagaRepository.deleteById(id);
		
		return "redirect:/vagas";
	}
}
