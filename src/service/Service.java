package service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import userBean.UserBean;
import userDao.UserDao;

public class Service {
	public static void main(String[] args) {
		// 程序执行的地方,
		// 加载核心配置文件
		try {
			// 配置文件流信息
			InputStream in = Resources.getResourceAsStream("conflig/mybatis-conflig.xml");
			// 需要使用sqlSessionFactory session工厂 去解析配置文件
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
			// 建立session 打开一个与数据库的session回话
			SqlSession session = sf.openSession();
			UserDao ud = session.getMapper(UserDao.class);
			UserBean ub = new UserBean(1, "zhangsan", 123);
			UserBean ub1 = new UserBean(2, "zhangsan", 123);
			UserBean ub2 = new UserBean(3, "zhangsan", 123);
			//UserBean ub3 = new UserBean(4, "zhangsan", 123);原来的ub3
			UserBean ub3 = new UserBean(4, "zhangsan", 1234);

			// ud.saveUser(ub);
			// ud.saveUser(ub1);
			// ud.saveUser(ub2);
			// ud.saveUser(ub3);
			// ud.delUser(1);
			//System.out.println(ud.userInfo());
			// 增删查改除了查,因为对数据库里面的数据进行了更改,都需要commit
			ud.updateUser(ub3);
			session.commit();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
