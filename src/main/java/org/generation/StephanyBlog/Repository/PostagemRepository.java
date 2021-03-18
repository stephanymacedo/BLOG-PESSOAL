package org.generation.StephanyBlog.Repository;

import java.util.List;

import org.generation.StephanyBlog.Model.Postagens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostagemRepository extends JpaRepository <Postagens, Long> {
	public List<Postagens>findAllByTituloContainingIgnoreCase(String Titulo);
	


}
