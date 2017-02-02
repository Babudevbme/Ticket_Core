import com.ticket.dao.EmployeeRoleDAO;
import com.ticket.model.EmployeeRole;

public class TestEmployeeRoleDAO {

	public static void main(String[] args) {
		EmployeeRoleDAO erd = new EmployeeRoleDAO();
		EmployeeRole er = new EmployeeRole();
		er.setName("manager");
		erd.save(er);

	}

}
