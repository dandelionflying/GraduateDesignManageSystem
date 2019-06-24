package com.running4light.gdms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.running4light.gdms.dao.ProcessDao;
import com.running4light.gdms.pojo.Process;
import com.running4light.gdms.service.ProcessService;
@Service
@Transactional
public class ProcessServiceImpl implements ProcessService {
	@Autowired
	private ProcessDao processDao;
	@Override
	public int deleteByPrimaryKey(Short id) {
		return processDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Process process) {
		return processDao.insert(process);
	}

	@Override
	public Process selectByPrimaryKey(Short id) {
		return processDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Process> selectAll() {
		return processDao.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Process process) {
		return processDao.updateByPrimaryKey(process);
	}

	@Override
	public String countState(Short state) {
		return processDao.countState(state);
	}

	@Override
	public List<Process> selectByTeacher(String teacherName) {
		return processDao.selectByTeacher(teacherName);
	}

	@Override
	public int updateState(Integer state,String uid, String classify) {
		Map<String,Object> param = new HashMap<>();
		param.put("uid"	, uid);
		if(classify!=null && !"".equals(classify)) {
			switch (classify) {
			case "任务书":
				param.put("TASK_BOOK", state);
				break;
			case "开题报告":
				param.put("OPENNING_REPORT", state);
				break;
			case "中期检查表":
				param.put("MID_TERM_CHECK", state);
				break;
			case "论文":
				param.put("PAPER", state);
				break;
			case "指导老师评阅表":
				param.put("EVALUATION1", state);
				break;
			case "评阅老师评阅表":
				param.put("EVALUATION2", state);
				break;
			case "论文查重报告":
				param.put("CHECK_REPETITION", state);
				break;
			case "答辩申请表":
				param.put("ANSWER_APPLICATION", state);
				break;
			case "答辩记录表":
				param.put("ANSWER_RECORD", state);
				break;
			default:
				break;
			}
			return processDao.updateState(param);
		}
		else
			return 0;
	}

	@Override
	public Process queryByUid(String uid) {
		return processDao.queryByUid(uid);
	}

}
