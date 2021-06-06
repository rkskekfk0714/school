package sch.service;

import sch.dao.SchDao;

public class Service {
	private static Service service = new Service();
	private Service() {}
	private SchDao dao = SchDao.getInstance();
	public static Service getInstance()
	{
		return service;
	}

	public boolean index(String id, String pwd, String radio) {
		// TODO Auto-generated method stub
		System.out.print("service login :" + pwd);
		return dao.index(id, pwd, radio);
	}
	public int proEnroll(String id, int num) {
		return dao.proEnroll(id, num);
	}
	
	public int proEnrollList(String id) {
		// TODO Auto-generated method stub
		return dao.proEnrollList(id);
	}
}
