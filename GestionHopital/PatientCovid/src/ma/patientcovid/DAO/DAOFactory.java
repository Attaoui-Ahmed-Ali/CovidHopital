package ma.patientcovid.DAO;
import java.sql.Connection;

public class DAOFactory {
	protected static final Connection conn = BddConnection.getInstance();

	public static DiagnosticDAO getDiagnosticDAO() {
		return new DiagnosticDAO(conn);
	}
	
	public static HopitalDAO getHopitalDAO() {
		return new HopitalDAO(conn);
	}
	
	public static MaladieDAO getMaladieDAO() {
		return new MaladieDAO(conn);
	}
	
	public static PatientDAO getPatientDAO() {
		return new PatientDAO(conn);
	}
	
	public static PosologieDAO getPosologieDAO() {
		return new PosologieDAO(conn);
	}
	
	public static RoomDAO getRoomDAO() {
		return new RoomDAO(conn);
	}
	
	public static SejourHopitalierDAO getSejourHopitalierDAO() {
		return new SejourHopitalierDAO(conn);
	}
	
	public static SymptomeDAO getSymptomeDAO() {
		return new SymptomeDAO(conn);
	}
	
	public static TraitementDAO getTraitementDAO() {
		return new TraitementDAO(conn);
	}
	
	public static UserDAO getUserDAO() {
		return new UserDAO(conn);
	}
}
