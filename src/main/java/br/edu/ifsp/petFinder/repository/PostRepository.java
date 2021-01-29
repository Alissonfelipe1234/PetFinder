package br.edu.ifsp.petFinder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.petFinder.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
  List<Post> findByEncontrado(boolean encontrado);
  List<Post> findByNomeContaining(String nome);
  List<Post> findByDescricaoContaining(String descricao);
}