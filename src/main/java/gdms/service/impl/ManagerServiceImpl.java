package gdms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gdms.dao.ManagerDao;
import gdms.model.EDUManager;
import gdms.model.Topic;
import gdms.service.ManagerService;
@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDao managerDao;
	@Override
	public EDUManager login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
