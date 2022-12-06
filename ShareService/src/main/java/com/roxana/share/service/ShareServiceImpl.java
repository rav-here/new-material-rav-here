package com.roxana.share.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roxana.share.entity.Share;
import com.roxana.share.persistence.ShareDao;

@Service
public class ShareServiceImpl implements ShareService {

	@Autowired
	private ShareDao shareDao;
	@Override
	public Share searchShareById(int id) {
		return shareDao.findById(id).orElse(null);
	}

}
