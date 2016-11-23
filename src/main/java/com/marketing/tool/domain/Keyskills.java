package com.marketing.tool.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "KEYSKILLS")
@PrimaryKeyJoinColumn(name="id")
public class Keyskills extends MasterEntity {

	
	@NotEmpty
	@Column(name = "skill", nullable = false, updatable = false)
	private String skill;

	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "keyskills") 
	 private Set<Author> author; 
	
	  
	 
	public Set<Author> getAuthor() {
		return author;
	}

	public void setAuthor(Set<Author> author) {
		this.author = author;
	}


	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	@Override
	public String toString() {
		return "skill [skill=" + skill+ "]";
	}
}
