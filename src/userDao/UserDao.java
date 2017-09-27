package userDao;

import java.util.List;

import userBean.UserBean;

public interface UserDao {
	//public UserBean login(UserBean ub);

	public List userInfo();

	public void saveUser(UserBean ub);

	public int delUser(int id);

	public boolean updateUser(UserBean ub);
}
