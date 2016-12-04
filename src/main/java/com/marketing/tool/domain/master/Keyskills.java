package com.marketing.tool.domain.master;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marketing.tool.domain.Author;
import com.marketing.tool.domain.MasterDataType;
import com.marketing.tool.domain.MasterEntity;

@Entity
@Table(name = "KEYSKILLS")
@PrimaryKeyJoinColumn(name="id")
public class Keyskills extends MasterEntity {

	
	public Keyskills() {
		this.masterDataType = MasterDataType.KEYSKILLS;
	}
	
	@NotEmpty
	@Column(name = "skill", nullable = false, updatable = true)
	private String skill;

	@JsonIgnore
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
		return "skill [skill=" + skill+ ",id= " + super.getId() +"]";
	}
	
	/*@Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
	
    @Override
    public int hashCode() {
        return super.hashCode();
    }*/
}
