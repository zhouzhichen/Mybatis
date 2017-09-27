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
		// ����ִ�еĵط�,
		// ���غ��������ļ�
		try {
			// �����ļ�����Ϣ
			InputStream in = Resources.getResourceAsStream("conflig/mybatis-conflig.xml");
			// ��Ҫʹ��sqlSessionFactory session���� ȥ���������ļ�
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
			// ����session ��һ�������ݿ��session�ػ�
			SqlSession session = sf.openSession();
			UserDao ud = session.getMapper(UserDao.class);
			UserBean ub = new UserBean(1, "zhangsan", 123);
			UserBean ub1 = new UserBean(2, "zhangsan", 123);
			UserBean ub2 = new UserBean(3, "zhangsan", 123);
			//UserBean ub3 = new UserBean(4, "zhangsan", 123);ԭ����ub3
			UserBean ub3 = new UserBean(4, "zhangsan", 1234);

			// ud.saveUser(ub);
			// ud.saveUser(ub1);
			// ud.saveUser(ub2);
			// ud.saveUser(ub3);
			// ud.delUser(1);
			//System.out.println(ud.userInfo());
			// ��ɾ��ĳ��˲�,��Ϊ�����ݿ���������ݽ����˸���,����Ҫcommit
			ud.updateUser(ub3);
			session.commit();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
