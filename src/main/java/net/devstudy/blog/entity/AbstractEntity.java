package net.devstudy.blog.entity;

import java.io.Serializable;

import net.devstudy.blog.model.AbstractModel;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 * @version 1.0
 */
public abstract class AbstractEntity<PK> extends AbstractModel implements Serializable {
	private static final long serialVersionUID = -886224493172895177L;
	private PK id;
	public PK getId() {
		return id;
	}
	public void setId(PK id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
