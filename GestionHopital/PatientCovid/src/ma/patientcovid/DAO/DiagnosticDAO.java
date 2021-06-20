package ma.patientcovid.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import ma.patientcovid.patient.Diagnostic;
import ma.patientcovid.patient.Maladie;

public class DiagnosticDAO extends DAO<Diagnostic> {

	public DiagnosticDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Diagnostic obj) {
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			int result = stmt.executeUpdate("INSERT INTO diagnostic(date_Contamination,date_Diagnostic,date_Cloture,etat_final,id_Patient) VALUES(" + obj.toStringNoid() + ")");
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
	
	public boolean createId(Diagnostic obj) {
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			int result = stmt.executeUpdate("INSERT INTO diagnostic VALUES(" + obj.toString() + ")");
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

	public boolean delete(Diagnostic obj) {
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			int result = stmt.executeUpdate("DELETE FROM diagnostic WHERE id_Diagnostic  = " + obj.getId());
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

	public boolean update(Diagnostic oldobj, Diagnostic newobj) {
		try {
			Maladie m = new Maladie(oldobj.getId());
			DAOFactory.getMaladieDAO().delete(m);
			delete(oldobj);
			createId(newobj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Diagnostic find(Diagnostic obj) {
		Diagnostic diag = new Diagnostic();
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("SELECT * FROM diagnostic WHERE date_Contamination = '"+obj.getCont()+"' and date_Diagnostic = '"+obj.getDiag()+"' and date_Cloture = '"+obj.getClot()+"' and etat_final = '"+obj.getstateF()+"' and id_Patient ="+obj.getidPatat());
			result.next();
			diag = new Diagnostic(result.getInt(1), result.getDate(2).toLocalDate(),
					result.getDate(3).toLocalDate(), result.getDate(4).toLocalDate(), result.getInt(5),
					result.getInt(6));
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
		return diag;
	}

	public Set<Diagnostic> all() {
		Set<Diagnostic> set_Diagnostic = new HashSet<>();
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("SELECT * FROM diagnostic");
			while (result.next()) {
				set_Diagnostic.add(new Diagnostic(result.getInt(1), result.getDate(2).toLocalDate(),
						result.getDate(3).toLocalDate(), result.getDate(4).toLocalDate(), result.getInt(5),
						result.getInt(6)));
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
		return set_Diagnostic;
	}
	
	public int countEtat(int et) {
		int counter = 0;
		Statement stmt = null;
		try {
			stmt = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = stmt.executeQuery("SELECT count(*) FROM diagnostic WHERE etat_final = "+et);
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
