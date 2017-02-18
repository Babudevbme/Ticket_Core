import com.ticket.dao.RoleDAO;
import com.ticket.model.Role;

public class TestEmployeeRoleDAO {

	public static void main(String[] args) {
		RoleDAO erd = new RoleDAO();
		Role er = new Role();
		er.setName("manager");
		erd.save(er);

	}

}
