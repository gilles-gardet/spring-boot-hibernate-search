package com.ggardet.hibernatesearch.core.repository;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * A {@link RepositoryTrackableEntity} containing also an UUID
 *
 * @author Joachim Habib (m349531)
 */
@Embeddable
@MappedSuperclass
public abstract class RepositoryTrackableEntityWithUUID extends RepositoryTrackableEntity implements Serializable {

	/**
	 * Determines if a de-serialized file is compatible with this class.
	 * Maintainers must change this value if and only if the new version of this
	 * class is not compatible with old versions. See Sun docs for <a
	 * href=http://java.sun.com/j2se/1.5.0/docs/guide/serialization
	 * /serialization/spec/class.html#4100> details. </a>
	 * Not necessary to include in first version of the class, but included here as
	 * a reminder of its importance.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * UUID
	 */
	@Column(name = "UUID")
	private UUID uuid;

	/**
	 * default constructor
	 */
	public RepositoryTrackableEntityWithUUID() {
	}

	public RepositoryTrackableEntityWithUUID(Date pCreationDate, Date pLastModifiedOn, Long pHibernateVersion) {
		super(pCreationDate, pLastModifiedOn, pHibernateVersion);
	}

	public RepositoryTrackableEntityWithUUID(RepositoryTrackableEntity pRepositoryTrackableEntity) {
		super(pRepositoryTrackableEntity);
	}

	@Override
	public final boolean generateUUID() {
		return true;
	}

	@Override
	public UUID getUuid() {
		return uuid;
	}

	@Override
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
}
