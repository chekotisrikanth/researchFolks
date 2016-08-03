package com.marketing.tool.domain;


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

	
	@Entity
	@Table(name = "customerauthorfavlist")
	public class CustomerAuthorFavList  {

		private CustomerAuthorFavListId id;
		private Author author;
		private Customer customer;
		private Integer rating;
		private String review;
		private boolean favourite;

		public CustomerAuthorFavList() {
		}

		public CustomerAuthorFavList(CustomerAuthorFavListId id, Author author, Customer customer) {
			this.id = id;
		    this.author = author;
			this.customer = customer;
		}

		public CustomerAuthorFavList(CustomerAuthorFavListId id,Integer rating,
				String review, boolean favourite,Author author, Customer customer) {
			this.id = id;
			this.author = author;
			this.customer = customer;
			this.rating = rating;
			this.review = review;
			this.favourite = favourite;
		}
		
		public CustomerAuthorFavList(CustomerAuthorFavListId id,boolean favourite) {
			this.id = id;
			this.favourite = favourite;
		}
		
		
		
		public CustomerAuthorFavList(CustomerAuthorFavListId id,boolean favourite,Integer rating) {
			this.id = id;
			this.favourite = favourite;
			this.rating = rating;
		}

		public CustomerAuthorFavList(CustomerAuthorFavListId id, String review) {
			this.id = id;
			this.review=review;
		}

		public CustomerAuthorFavList(CustomerAuthorFavListId customerAuthorFavListId) {
			this.id=customerAuthorFavListId;
		}

		@EmbeddedId
		@AttributeOverrides({ @AttributeOverride(name = "authorid", column = @Column(name = "authorid", nullable = false) ),
				@AttributeOverride(name = "customerid", column = @Column(name = "customerid", nullable = false) ),
				@AttributeOverride(name = "reportid", column = @Column(name = "reportid", nullable = false) )})
		public CustomerAuthorFavListId getId() {
			return this.id;
		}

		public void setId(CustomerAuthorFavListId id) {
			this.id = id;
		}

		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "authorid", nullable = false, insertable = false, updatable = false)
		public Author getAuthor() {
			return this.author;
		}

		public void setAuthor(Author author) {
			this.author = author;
		}

		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "customerid", nullable = false, insertable = false, updatable = false)
		public Customer getCustomer() {
			return this.customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		
		@Column(name = "rating")
		public Integer getRating() {
			return this.rating;
		}

		public void setRating(Integer rating) {
			this.rating = rating;
		}

		@Column(name = "review", length = 45)
		public String getReview() {
			return this.review;
		}

		public void setReview(String review) {
			this.review = review;
		}

		@Column(name = "favourite", length = 45)
		public boolean getFavourite() {
			return this.favourite;
		}

		public void setFavourite(boolean favourite) {
			this.favourite = favourite;
		}

	}
