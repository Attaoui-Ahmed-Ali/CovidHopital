package ma.patientcovid.DAO;

import java.sql.Connection;
import java.util.Set;

public abstract class DAO<T> {
	
	protected Connection connect = null;

	public DAO(Connection conn) {
		this.connect = conn;
	}

	/**
	 * Methode de cr�ation
	 * 
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean create(T obj);

	/**
	 * Methode pour effacer
	 * 
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean delete(T obj); // ali

	/**
	 * Methode de mise � jour
	 * 
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean update(T oldobj, T newobj);// ali

	/**
	 * Methode de recherche des informations
	 * 
	 * @param id
	 * @return T (peut retourner null )
	 */
	public abstract T find(T obj);

	/**
	 * Methode qui permet de charger tout les enregistrement
	 * 
	 * @param id
	 * @return Set<T>
	 */
	public abstract Set<T> all();

}

