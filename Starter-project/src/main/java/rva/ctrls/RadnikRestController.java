package rva.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import rva.jpa.Radnik;
import rva.jpa.Sektor;
import rva.repository.RadnikRepository;
import rva.repository.SektorRepository;

@RestController
public class RadnikRestController {
	@Autowired
	private RadnikRepository radnikRepository;
	
	@Autowired
	private SektorRepository sektorRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("radnik")
	public Collection<Radnik> getRadnici(){
		return radnikRepository.findAll();
	}
	
	@GetMapping("radnik/{id}")
	public Radnik getRadnik(@PathVariable ("id") Integer id) {
		return radnikRepository.getOne(id);
	}
	
	@GetMapping("radnikBySektor/{id}")
	public Collection<Radnik> getRadnikBySektor(@PathVariable ("id") Integer id){
		Sektor s = sektorRepository.getOne(id);
		return radnikRepository.findBySektor(s);
	}
	
	@GetMapping("radnikByLk/{broj_lk}")
	public Collection<Radnik> getRadnikByLk(@PathVariable ("broj_lk") Integer broj_lk){
		return radnikRepository.findByBrojLkLessThanOrderById(broj_lk);
	}
	
	@PostMapping("radnik")
	public ResponseEntity<Radnik> insertRadnik(@RequestBody Radnik radnik){
		if(!radnikRepository.existsById(radnik.getId())) {
			radnik.setBrojLk(radnikRepository.nextLicnaKarta(radnik.getSektor().getId()));
			radnikRepository.save(radnik);
			return new ResponseEntity<Radnik>(HttpStatus.OK);
		}
		return new ResponseEntity<Radnik>(HttpStatus.CONFLICT);
		
	}
	
	@PutMapping("radnik")
	public ResponseEntity<Radnik> updateRadnik(@RequestBody Radnik radnik){
		if(!radnikRepository.existsById(radnik.getId())) {
			return new ResponseEntity<Radnik>(HttpStatus.CONFLICT);
			
		}
		radnikRepository.save(radnik);
		return new ResponseEntity<Radnik>(HttpStatus.OK);
	}
	
	@DeleteMapping("radnik/{id}")
	public ResponseEntity<Radnik> deleteRadnik(@PathVariable Integer id){
		if(!radnikRepository.existsById(id)) {
			return new ResponseEntity<Radnik>(HttpStatus.NO_CONTENT);
		}
		radnikRepository.deleteById(id);
		if(id == -100) {
			jdbcTemplate.execute("INSERT INTO \"radnik\" (\"id\", \"ime\", \"prezime\", \"broj_lk\", \"obrazovanje\" ,\"sektor\" )"
					+ "VALUES (-100,'izmenjeno','TEST',223,1,1)");
		}
		return new ResponseEntity<Radnik>(HttpStatus.OK);
	}

}
