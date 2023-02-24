package com.ggardet.hibernatesearch.core.repository;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * <p>
 * Title : RepositoryBaseEntity.java
 * </p>
 * BO RepositoryBaseEntity
 * <p>
 * Copyright : Copyright (c) 2009
 * </p>
 * <p>
 * Company : AIRFRANCE
 * </p>
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class RepositoryBaseEntity extends BaseObject implements Serializable {

	/**
	 * Determines if a de-serialized file is compatible with this class.
	 * Maintainers must change this value if and only if the new version of this
	 * class is not compatible with old versions. See Sun docs for <a
	 * href=http://java.sun.com/j2se/1.5.0/docs/guide/serialization
	 * /serialization/spec/class.html#4100> details. </a>
	 * Not necessary to include in first version of the class, but included here as
	 * a reminder of its importance.
	 */
	private static final long serialVersionUID = 1634874575073865291L;
	private static final String DEFAULT_LINK_URL = "/service/softwareServicesView.html";

	/**
	 * default constructor
	 */
	public RepositoryBaseEntity() {
	}

	/**
	 * A copy contructor. This constructor will only copy primitae type attributes
	 */
	public RepositoryBaseEntity(RepositoryBaseEntity pRepositoryBaseEntity) {
		setId(pRepositoryBaseEntity.getId());
	}

	public String createLink() {
		return createLink(null);
	}

	public String createLink(boolean pForMailSubject) {
		return createLink(pForMailSubject, null);
	}

	public String createLink(boolean pForMailSubject, String pDefaultLabel) {
		return "Link";
	}

	public String createLink(String pDefaultLabel) {
		return createLink(false, pDefaultLabel);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see Object#equals(Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		return o != null && (o.getClass().isInstance(this) || getClass().isInstance(o)) && getId() != null
			&& getId().equals(((RepositoryBaseEntity) o).getId());
	}

	public String forMailSubject() {
		return createLink(true);
	}

	/**
	 * getId
	 *
	 * @return The getId as <code>Long</code>
	 */
	public abstract Long getId();

	public String getMailLinkEntityName() {
		String label = "detailed here";

		try {
			Method getName = getClass().getMethod("getName");
			label = (String) getName.invoke(this, new Object[] {});
		} catch (Exception e) {
		}
		return label;
	}

	public String getMailLinkSuffix(boolean pForMailSubject) {
		return "";
	}

	public String getMailLinkText() {
		String text = "the ";
		Class<?> cls = getClass();
		while (cls.getSimpleName().contains("$")) {
			cls = cls.getSuperclass();
		}
		// Convert "SoftwareService" to "software service"
		text += cls.getSimpleName().replaceAll("([A-Z])", " $1").toLowerCase();
		return text;
	}

	public String getMailLinkUrl() {
		Class<?> clazz = getClass();
		if (clazz.getSimpleName().contains("$$")) {
			clazz = clazz.getSuperclass();
		}

		return getMailLinkUrlPage() + "?nodeToOpenId=" + clazz.getSimpleName() + "-" + getId();
	}

	public String getMailLinkUrlPage() {
		return DEFAULT_LINK_URL;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return getId() != null ? getId().hashCode() : 0;
	}

	/**
	 * setId
	 *
	 * @param id in Long
	 */
	public abstract void setId(Long id);
}
