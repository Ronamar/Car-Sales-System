package main;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Repository<T extends Entity> {

	protected Map<String, T> Entities;

	public Repository() {

		Entities = new HashMap<String, T>();
	}

	public Map<String, T> getEntities() {

		return Entities;
	}

	public T getByID(String ID) {

		return Entities.get(ID);

	}

	public void insert(T entity) {

		Entities.put(entity.ID, entity);

	}

	public void delete(String ID) {

		Entities.remove(ID);

	}

	public void update(T entity) {

		Entities.put(entity.ID, entity);
	}

}
