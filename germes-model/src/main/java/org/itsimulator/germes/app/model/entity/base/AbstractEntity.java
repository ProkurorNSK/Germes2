package org.itsimulator.germes.app.model.entity.base;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import org.itsimulator.germes.app.model.entity.person.Account;

/**
 * Base class for all business entities
 * @author Morenets
 *
 */
@MappedSuperclass
public abstract class AbstractEntity {
	/**
	 * Unique entity identifier
	 */
	private int id;
	
	/**
	 * Timestamp of entity creation
	 */
	private LocalDateTime createdAt;
	
	/**
	 * Timestamp of entity last modification
	 */
	private LocalDateTime modifiedAt;
	
	/**
	 * Person who created specific entity
	 */
	private Account createdBy;
	
	/**
	 * Last person who modified entity 
	 */
	private Account modifiedBy;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "CREATED_AT", nullable = false, updatable = false)
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "MODIFIED_AT", insertable = false)
	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = {})
	@JoinColumn(name = "CREATED_BY", updatable = false)	
	public Account getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Account createdBy) {
		this.createdBy = createdBy;
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = {})
	@JoinColumn(name = "MODIFIED_BY", insertable = false)	
	public Account getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Account modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		AbstractEntity other = (AbstractEntity) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
