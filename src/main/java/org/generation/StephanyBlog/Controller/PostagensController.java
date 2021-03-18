package org.generation.StephanyBlog.Controller;



import java.util.List;

import org.generation.StephanyBlog.Model.Postagens;
import org.generation.StephanyBlog.Repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/Postagens")
@CrossOrigin("*")

public class PostagensController {
	
	@Autowired
	private PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity <List<Postagens>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/{id}")
    public ResponseEntity<Postagens> getbyid(@PathVariable long Id){
        return repository.findById(Id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
}
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Postagens>>  getbytitulo(@PathVariable String titulo){
        return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
    @PostMapping
    public ResponseEntity< Postagens>post(@RequestBody Postagens postagens){
    	return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagens));
    }
    @PutMapping
    public ResponseEntity< Postagens>put(@RequestBody Postagens postagens){
    	return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagens));
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
    	repository.deleteById(id);
    }
}