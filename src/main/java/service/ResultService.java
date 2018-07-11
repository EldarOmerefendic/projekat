package service;

import java.util.List;
import dao.ResultDAO;
import model.Result;

public class ResultService {
	
	private ResultDAO resultDao;
	
	public ResultService(ResultDAO resultDao) {
		this.resultDao = resultDao;
	}
	
	public boolean create(Result result) {		
		return resultDao.save(result);	
	}
	
	public List<Result> findAll() {
		return resultDao.findAll();
	}
		
}