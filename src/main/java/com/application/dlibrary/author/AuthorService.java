package com.application.dlibrary.author;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepository;

	public Author createAuthor(Author author) {
		return authorRepository.saveAndFlush(author);
	}

	public List<Author> getAllAuthor() {
		return authorRepository.findAll();
	}
	
	public Set<Author> getAuthors(Set<Integer> authorIds) {
		return authorRepository.findByIdIn(authorIds);
	}

	public Author getAuthorById(Integer id) {
		Optional<Author> authorOpt = authorRepository.findById(id);
		if (authorOpt.isPresent()) {
			return authorOpt.get();
		}
		return null;
	}

	public void deleteAuthorById(Integer id) {
		authorRepository.deleteById(id);
	}

	public Author updateAuthorById(Author author, Integer id) {
		Author updateAuthor = getAuthorById(id);
		updateAuthor.setName(author.getName());
		updateAuthor.setBirthDate(author.getBirthDate());
		updateAuthor.setGender(author.getGender());
		updateAuthor.setDeathDate(author.getDeathDate());
		authorRepository.flush();
		return updateAuthor;
	}

	public Author getAuthorByName(String name) {
		return authorRepository.findByNameContaining(name);
	}

	public List<Author> getAuthorWhoLive() {
		return authorRepository.findByDeathDateIsNull();
	}

}