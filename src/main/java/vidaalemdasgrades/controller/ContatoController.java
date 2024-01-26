package vidaalemdasgrades.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vidaalemdasgrades.model.Contato;

import vidaalemdasgrades.repository.ContatoRepository;

@Controller
@RequestMapping("/contato")
public class ContatoController {
	@Autowired
	private ContatoRepository contatoRepository;
	
	@GetMapping
	public ModelAndView contato() {
		ModelAndView modelAndView = new ModelAndView("views/usuarios/contato.html");
		modelAndView.addObject("contato", contatoRepository.findAll());
		return modelAndView;
}
//	@PostMapping("/salvar")
//	public String salvarContato(@RequestBody Contato contato) {
//	    // Salva o contato no banco de dados
//	    contatoRepository.save(contato);
//	    
//	    return "redirect:/contato";
//	}
	@PostMapping({"/cadastrar", "/{id}/editar"})
	public String cadastrar(Contato contato) {
		contatoRepository.save(contato);
		
		return "redirect:/contato";
	}
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		contatoRepository.deleteById(id);
		
		return "redirect:/contato";
	}
}