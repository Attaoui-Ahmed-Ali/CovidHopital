package ma.patientcovid.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import ma.patientcovid.room.SejourHopitalier;

public class SejourHopitalierDAO extends DAO<SejourHopitalier> {
	public SejourHopitalierDAO(Connection conn) {
		super(conn);
	}

	public boolean create(SejourHopitalier obj) {
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			int result = stmt.executeUpdate("INSERT INTO SejourHospitalier VALUES(" + obj.toString() + ")");
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

	public boolean delete(SejourHopitalier obj) {
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			int result = stmt.executeUpdate("DELETE FROM SejourHospitalier WHERE id_Diagnostic  = " + obj.getId());
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
	
	public boolean deleteSejId(int id) {
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			int result = stmt.executeUpdate("DELETE FROM SejourHospitalier WHERE id_Sejour  = " + id);
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

	public boolean update(SejourHopitalier oldobj, SejourHopitalier newobj) {
		try {
			delete(oldobj);
			create(newobj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public SejourHopitalier find(SejourHopitalier obj) {
		SejourHopitalier sej = new SejourHopitalier();
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("SELECT * FROM SejourHospitalier WHERE debutSejour  = '" + obj.getDebut()+"' and finSejour = '"+obj.getFin()+"' and id_Diagnostic ="+obj.getIdDiag());
			result.next();
			sej = new SejourHopitalier(result.getInt(1), result.getDate(2).toLocalDate(),
					result.getDate(3).toLocalDate(), result.getInt(4));
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
		return sej;
	}
	
	public SejourHopitalier findId(int id) {
		if (id>0) {
			SejourHopitalier sej = new SejourHopitalier();
			Statement stmt = null;
			try {
				stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				ResultSet result = stmt.executeQuery("SELECT * FROM SejourHospitalier WHERE id_Sejour  = "+id );
				result.next();
				sej = new SejourHopitalier(result.getInt(1), result.getDate(2).toLocalDate(),
						result.getDate(3).toLocalDate(), result.getInt(4));
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
			return sej;
		}
		else {
			SejourHopitalier s = new SejourHopitalier(id);
			return(s);
		}
	}

	public Set<SejourHopitalier> all() {
		Set<SejourHopitalier> set_Sejour = new HashSet<>();
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("SELECT * FROM SejourHospitalier");
			while (result.next()) {
				set_Sejour.add(new SejourHopitalier(result.getInt(1), result.getDate(2).toLocalDate(),
						result.getDate(3).toLocalDate(), result.getInt(4)));
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
		return set_Sejour;
	}
}
