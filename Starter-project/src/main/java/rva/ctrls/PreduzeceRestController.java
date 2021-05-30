package rva.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import rva.jpa.Preduzece;
import rva.repository.PreduzeceRepository;

@RestController
public class PreduzeceRestController {
	
	@Autowired
	private PreduzeceRepository preduzeceRepository;
	
	@GetMapping("preduzece")
	public Collection<Preduzece> getPreduzeca(){
		return preduzeceRepository.findAll();
	}
	
	@GetMapping("preduzece/{id}")
	public Preduzece getPreduzece(@PathVariable ("id") Integer id) {
		return preduzeceRepository.getOne(id);
	}
	
	@GetMapping("preduzeceNaziv/{naziv}")
	public Collection<Preduzece> getPreduzeceByNaziv(@PathVariable ("naziv") String naziv){
		return preduzeceRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	
}
