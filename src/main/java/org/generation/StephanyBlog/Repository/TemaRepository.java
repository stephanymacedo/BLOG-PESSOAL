package org.generation.StephanyBlog.Repository;

import java.util.List;

import org.generation.StephanyBlog.Model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepository extends JpaRepository<Tema,Long>{
	
	public List<Tema>findAllByDescricaoContainingIgnoreCase(String descricao);

}
