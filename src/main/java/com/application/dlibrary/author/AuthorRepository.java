package com.application.dlibrary.author;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
	public Author findByNameContaining(String name);

	public List<Author> findByDeathDateIsNull();

	public Set<Author> findByIdIn(Set<Integer> authorIds);
}