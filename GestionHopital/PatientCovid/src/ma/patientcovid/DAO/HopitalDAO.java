package ma.patientcovid.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import ma.patientcovid.room.Hopital;

public class HopitalDAO extends DAO<Hopital> {
	public HopitalDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Hopital obj) {
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			int result = stmt.executeUpdate("INSERT INTO Hopital(nomHopital,ville) VALUES(" + obj.toStringNoid() + ")");
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
	
	public boolean createid(Hopital obj) {
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			int result = stmt.executeUpdate("INSERT INTO Hopital VALUES(" + obj.toString() + ")");
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

	public boolean delete(Hopital obj) {
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			int result = stmt.executeUpdate("DELETE FROM Hopital WHERE id_Hopital = " + obj.getId());
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

	public boolean update(Hopital oldobj, Hopital newobj) {
		try {
			delete(oldobj);
			createid(newobj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Hopital find(Hopital obj) {
		Hopital hop = new Hopital();
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("SELECT * FROM Hopital WHERE id_Diagnostic  = " + obj.getId());
			hop = new Hopital(result.getInt(1), result.getString(2),result.getString(3));
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
		return hop;
	}

	public Set<Hopital> all() {
		Set<Hopital> set_Hopital = new HashSet<>();
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("SELECT * FROM Hopital");
			while (result.next()) {
				set_Hopital.add(new Hopital(result.getInt(1), result.getString(2),result.getString(3)));
			}
			result.close();
			System.out.println(set_Hopital);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return set_Hopital;
	}
	
	public Set<String> allVille() {
		Set<String> set_Ville = new HashSet<>();
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("SELECT DISTINCT ville FROM hopital");
			while (result.next()) {
				set_Ville.add(result.getString(1));
			}
			result.close();
			System.out.println(set_Ville);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return set_Ville;
	}
	
	public Set<Integer> findVille(String ville) {
		Set<Integer> set_Ville = new HashSet<>();
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("SELECT id_hopital FROM hopital where ville ='"+ville+"'");
			while (result.next()) {
				set_Ville.add(result.getInt(1));
			}
			result.close();
			System.out.println(set_Ville);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return set_Ville;
	}
	
	public int countVille(String ville) {
		int counter = 0;
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("SELECT count(*) FROM Hopital WHERE ville  = '" + ville+"'");
			result.next();
			counter = result.getInt(1);
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
		return counter;
	}
}
