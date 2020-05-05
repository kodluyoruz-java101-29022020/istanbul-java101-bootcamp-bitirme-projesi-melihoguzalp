package com.spring.bookshelf.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "books")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;



	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Long id;
	
	@Column(name = "title")
    private String bookName;
	
	@Column(name = "publish_year")
    private Long publishYear;
	
	@Column(name = "book_description")
    private String description;
    
	
	@Column(name = "book_comment")
    private String comment;
	
//	@Column(name = "author_name")
//    private String authorName;
//	
//	
//	
//	
//    public String getAuthorName() {
//		return authorName;
//	}
//
//	public void setAuthorName(String authorName) {
//		this.authorName = authorName;
//	}
	
	

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(
			name = "author_book",
			joinColumns = { @JoinColumn(name = "book_id") },
			inverseJoinColumns =  { @JoinColumn(name = "aouthor_id") }
	)
    private List<Author> authors;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Long getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(Long publishYear) {
		this.publishYear = publishYear;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<Author> getAuthor() {
		return authors;
	}

	public void setAuthor(List<Author> authors) {
		this.authors = authors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((authorName == null) ? 0 : authorName.hashCode());
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((publishYear == null) ? 0 : publishYear.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
//		if (authorName == null) {
//			if (other.authorName != null)
//				return false;
//		} else if (!authorName.equals(other.authorName))
//			return false;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (publishYear == null) {
			if (other.publishYear != null)
				return false;
		} else if (!publishYear.equals(other.publishYear))
			return false;
		return true;
	}


	
	
	
    
}
