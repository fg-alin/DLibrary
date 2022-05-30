package com.application.dlibrary.book;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.dlibrary.author.Author;
import com.application.dlibrary.author.AuthorService;
import com.application.dlibrary.exception.ResourceNotFoundException;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorService authorService;

	public Book createBook(Book book) {
		return bookRepository.saveAndFlush(book);
	}

	public Book createBook(Book book, Set<Integer> authorIds) {
		Set<Author> authors = authorService.getAuthors(authorIds);
		for (Author author : authors) {
			book.addAuthor(author);
		}
		return bookRepository.save(book);
	}

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	
	public Book getBookById(Integer id) {
		return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
	}

	
	public void deleteBookById(Integer id) {
		bookRepository.deleteById(id);
	}

	
	public Book updateBook(Book book, Integer id) {
		Book bookUpdate = getBookById(id);
		bookUpdate.setTitleBook(book.getTitleBook());
		bookUpdate.setYearBook(book.getYearBook());
		bookUpdate.setIsbnBook(book.getIsbnBook());
		bookRepository.flush();
		return bookUpdate;
	}

	
	public List<Book> findByTitle(String title) {
		return bookRepository.findByTitle(title);
	}

}