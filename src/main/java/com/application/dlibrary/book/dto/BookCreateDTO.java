package com.application.dlibrary.book.dto;

import java.time.LocalDate;
import java.util.Set;

public class BookCreateDTO {
	private String title;
	private LocalDate year;
	private String isbn;
	private Set<Integer> authorIds;


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getYear() {
		return year;
	}

	public void setYear(LocalDate year) {
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<Integer> getAuthorIds() {
		return authorIds;
	}

	public void setAuthorIds(Set<Integer> authorIds) {
		this.authorIds = authorIds;
	}
}