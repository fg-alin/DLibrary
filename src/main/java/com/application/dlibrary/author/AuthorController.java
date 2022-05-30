package com.application.dlibrary.author;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.application.dlibrary.author.dto.AuthorDTO;
import com.application.dlibrary.author.mapper.AuthorMapper;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	@Autowired
	private AuthorService authorService;
	@Autowired
	private AuthorMapper authorMapper;

	@PostMapping
	public AuthorDTO createAuthor(@RequestBody AuthorDTO authorDTO) {
		Author aut = authorService.createAuthor(authorMapper.authorDTO2Author(authorDTO));
		return authorMapper.author2AuthorDTO(aut);
	}

	@GetMapping("/list")
	public List<AuthorDTO> getAllAuthor() {
		return authorMapper.authorList2AuthorListDTO(authorService.getAllAuthor());
	}

	@GetMapping("/{id}")
	public AuthorDTO getAuthorById(@PathVariable Integer id) {
		return authorMapper.author2AuthorDTO(authorService.getAuthorById(id));
	}

	@GetMapping("/byName")
	public AuthorDTO getAuthorByname(@RequestParam String name) {
		return authorMapper.author2AuthorDTO(authorService.getAuthorByName(name));
	}

	@GetMapping("/live")
	public List<AuthorDTO> getAuthorWhoLive() {
		return authorMapper.authorList2AuthorListDTO(authorService.getAuthorWhoLive());
	}

	@PutMapping("/{id}")
	public AuthorDTO updateAuthor(@RequestBody AuthorDTO authorDTO, @PathVariable Integer id) {
		Author author = authorService.updateAuthorById(authorMapper.authorDTO2Author(authorDTO), id);
		return authorMapper.author2AuthorDTO(author);
	}

	@DeleteMapping("/{id}")
	public void deleteAuthorById(@PathVariable Integer id) {
		authorService.deleteAuthorById(id);
	}

}