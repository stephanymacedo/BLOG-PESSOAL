package org.generation.StephanyBlog.Controller;



import java.util.List;

import org.generation.StephanyBlog.Model.Postagens;
import org.generation.StephanyBlog.Repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
