package ma.patientcovid.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import ma.patientcovid.patient.Posologie;
import ma.patientcovid.patient.Traitement;

public class PosologieDAO extends DAO<Posologie> {
	public PosologieDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Posologie obj) {
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			int result = stmt.executeUpdate("INSERT INTO Posologie(date_debut,date_fin,nb_prise_jour,id_Diagnostic) VALUES(" + obj.toStringNoid() + ")");
			System.out.println(result + " Row affected ! ");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean createId(Posologie obj) {
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			int result = stmt.executeUpdate("INSERT INTO Posologie VALUES(" + obj.toString() + ")");
			System.out.println(result + " Row affected ! ");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean delete(Posologie obj) {
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			int result = stmt.executeUpdate("DELETE FROM Posologie WHERE id_Posologie  = " + obj.getId());
			System.out.println(result + " Row affected !");
			return (true);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return (false);
	}

	public boolean update(Posologie oldobj, Posologie newobj) {
		try {
			Traitement t = new Traitement(oldobj.getId());
			DAOFactory.getTraitementDAO().deletePos(t);
			delete(oldobj);
			createId(newobj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Posologie find(Posologie obj) {
		Posologie pos = new Posologie();
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("SELECT * FROM Posologie WHERE date_debut  = '" + obj.getDebut()+"' and date_fin = '"+obj.getFin()+"' and nb_prise_jour = "+obj.getPrise()+" and id_Diagnostic ="+obj.getIdDiag());
			pos = new Posologie(result.getInt(1), result.getDate(2).toLocalDate(),
					result.getDate(3).toLocalDate(), result.getInt(4), result.getInt(5));
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pos;
	}

	public Set<Posologie> all() {
		Set<Posologie> set_Posologie = new HashSet<>();
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("SELECT * FROM Posologie");
			while (result.next()) {
				set_Posologie.add(new Posologie(result.getInt(1), result.getDate(2).toLocalDate(),
						result.getDate(3).toLocalDate(), result.getInt(4), result.getInt(5)));
			}
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return set_Posologie;
	}
	
	public Set<String> allid() {
		Set<String> set_Posologie = new HashSet<>();
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("SELECT id_Posologie FROM Posologie");
			while (result.next()) {
				set_Posologie.add(String.valueOf(result.getInt(1)));
			}
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return set_Posologie;
	}
}
