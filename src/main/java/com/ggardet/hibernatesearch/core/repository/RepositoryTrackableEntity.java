package com.ggardet.hibernatesearch.core.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Embeddable
@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public abstract class RepositoryTrackableEntity extends RepositoryBaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CREATIONDATE")
	private Date creationDate;

	@Column(name = "LAST_MODIFIED_ON")
	private Date lastModifiedOn;

	@Column(name = "HIBERNATEVERSION")
	private Long hibernateVersion;

	/**
	 * full constructor
	 *
	 * @param pCreationDate     creationDate
	 * @param pLastModifiedOn   lastModifiedOn
	 * @param pHibernateVersion hibernateVersion
	 */
	public RepositoryTrackableEntity(Date pCreationDate, Date pLastModifiedOn, Long pHibernateVersion) {
		this.creationDate = pCreationDate;
		this.lastModifiedOn = pLastModifiedOn;
		this.hibernateVersion = pHibernateVersion;
	}

	/**
	 * A copy constructor. This constructor will only all attributes. Fort complex
	 * type (User), it will use their copy constructor as well
	 */
	public RepositoryTrackableEntity(RepositoryTrackableEntity pRepositoryTrackableEntity) {
		super(pRepositoryTrackableEntity);
		setCreationDate(pRepositoryTrackableEntity.getCreationDate());
		setLastModifiedOn(pRepositoryTrackableEntity.getLastModifiedOn());
		setHibernateVersion(pRepositoryTrackableEntity.getHibernateVersion());
	}

	/**
	 * Overwrite this method if you want to generate UUID for a specific entity
	 * object.
	 *
	 * @return Define whether an UUID must be generated
	 */
	public boolean generateUUID() {
		return false;
	}

	public UUID getUuid() {
		return null;
	}

	public void setUuid(UUID uuid) {
	}
}
