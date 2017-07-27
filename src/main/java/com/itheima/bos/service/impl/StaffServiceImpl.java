package com.itheima.bos.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.wsdl.util.StringUtils;
import com.itheima.bos.dao.IStaffDao;
import com.itheima.bos.domain.Staff;
import com.itheima.bos.service.IStaffService;
import com.itheima.bos.utils.PageBean;


@Service
@Transactional
public class StaffServiceImpl implements IStaffService {
	@Autowired
	private IStaffDao staffDao;
	public void save(Staff model) {
		staffDao.save(model);
	}
	
	
	public void pageQuery(PageBean pageBean) {
		staffDao.pageQuery(pageBean);
	}
	
	
	
	
	public void deleteBatch(String ids) {
		if(org.apache.commons.lang3.StringUtils.isNotBlank(ids)){
			String[] staffids = ids.split(",");
			for(String id : staffids){
				staffDao.executeUpdate("staff.delete", id);
				
			}
		}
		
	}

}
