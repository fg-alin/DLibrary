package com.application.dlibrary.exemplary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.dlibrary.book.Book;
import com.application.dlibrary.book.BookService;
import com.application.dlibrary.publisher.Publisher;
import com.application.dlibrary.publisher.PublisherService;

@Service
public class ExemplaryService {

	@Autowired
	private ExemplaryRepository exemplaryRepository;
	@Autowired
	private PublisherService publisherService;
	@Autowired
	private BookService bookService;

	public Exemplary createExemplary(Integer bookId, Integer publisherId, Exemplary exemplary) throws Exception {
		Book book = bookService.getBookById(bookId);
		if (book == null) {
			throw new Exception("Book with id " + bookId + " was not found");
		}
		Publisher publisher = publisherService.getPublisherById(publisherId);

		// one to many + many to one (bidirectional)
		book.addExemplary(exemplary);
		// only many to one
		exemplary.setPublisher(publisher);

		return exemplaryRepository.saveAndFlush(exemplary);
	}

	public void deleteExemplary(Integer exemplaryId) {
		exemplaryRepository.deleteById(exemplaryId);
	}

	public List<Exemplary> findExemplariesByBookId(Integer bookId) {
		return exemplaryRepository.findByBookId(bookId);
		
	}
}