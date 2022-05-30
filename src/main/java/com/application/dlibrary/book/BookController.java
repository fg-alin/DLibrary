package com.application.dlibrary.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.dlibrary.book.dto.BookCreateDTO;
import com.application.dlibrary.book.dto.BookDTO;
import com.application.dlibrary.book.mapper.BookMapper;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private BookMapper bookMapper;

	@PostMapping
	public BookDTO createBook(@RequestBody BookDTO bookDTO) {
		Book createdBook = bookService.createBook(bookMapper.bookDTO2Book(bookDTO));
		return bookMapper.book2BookDTO(createdBook);
	}

	@PostMapping("/with-authors")
	public BookDTO createBookWithAuthor(@RequestBody BookCreateDTO bookCreateDTO) {
		Book createBook = bookService.createBook(bookMapper.bookCreateDTO2Book(bookCreateDTO),
				bookCreateDTO.getAuthorIds());
		return bookMapper.book2BookDTO(createBook);
	}

	@GetMapping("/list")
	public List<BookDTO> getAllBook() {
		return bookMapper.bookList2BookListDTO(bookService.getAllBooks());
	}

	@GetMapping("/{id}")
	public Book getBookById(@PathVariable Integer id) {
		return bookService.getBookById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteBookById(@PathVariable Integer id) {
		bookService.deleteBookById(id);
	}

	@PutMapping("/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable Integer id) {
		return bookService.updateBook(book, id);
	}

	@GetMapping("/title/{title}")
	public List<Book> findByTitle(@PathVariable("title") String title) {
		return bookService.findByTitle(title);

	}

}