package cn.elwy.eplus.framework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.common.entity.Page;
import cn.elwy.common.entity.Parameter;
import cn.elwy.common.entity.ResultDto;
import cn.elwy.common.exception.RunException;
import cn.elwy.eplus.framework.biz.Biz;

/**
 * @description
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@Transactional
public class BaseService<E> implements Service<E> {

	@Autowired
	protected Biz<E> biz;

	public ResultDto audit(String... ids) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.audit(ids));
		} catch (RunException e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		} catch (Exception e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		}
		return rd;
	}

	@Override
	public ResultDto countByCondition(Parameter parameter) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.countByCondition(parameter));
		} catch (RunException e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		} catch (Exception e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		}
		return rd;
	}

	public ResultDto deleteByCondition(Parameter parameter) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.deleteByCondition(parameter));
		} catch (RunException e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		} catch (Exception e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		}
		return rd;
	}

	public ResultDto deleteByPrimaryKey(String id) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.deleteByPrimaryKey(id));
		} catch (RunException e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		} catch (Exception e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		}
		return rd;
	}

	public ResultDto deleteByPrimaryKeys(String... ids) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.deleteByPrimaryKeys(ids));
		} catch (RunException e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		} catch (Exception e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		}
		return rd;
	}

	public Biz<E> getBiz() {
		return biz;
	}

	public ResultDto insert(E entity) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.insert(entity));
		} catch (RunException e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		} catch (Exception e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		}
		return rd;
	}

	public ResultDto insertBatch(List<E> entityList) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.insertBatch(entityList));
		} catch (RunException e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		} catch (Exception e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		}
		return rd;
	}

	public ResultDto insertBatchSelective(List<E> entityList) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.insertBatchSelective(entityList));
		} catch (RunException e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		} catch (Exception e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		}
		return rd;
	}

	public ResultDto insertSelective(E entity) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.insertSelective(entity));
		} catch (RunException e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		} catch (Exception e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		}
		return rd;
	}

	@Override
	public ResultDto queryAll() {
		ResultDto rd = new ResultDto();
		try {
			rd.setDatas(biz.queryAll());
		} catch (RunException e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		} catch (Exception e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		}
		return rd;
	}

	@Override
	public ResultDto queryAllByPage(Page<E> page) {
		ResultDto rd = new ResultDto();
		try {
			Page<E> data = biz.queryAllByPage(page);

			rd.setPageNo(data.getPageNo());
			rd.setPageSize(data.getPageSize());
			rd.setTotalRecord(data.getTotalRecord());
			rd.setTotalPage(data.getTotalPage());
			rd.setDatas(page.getData());

		} catch (RunException e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		} catch (Exception e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		}
		return rd;
	}

	public ResultDto queryByCondition(Parameter parameter) {
		ResultDto rd = new ResultDto();
		try {
			rd.setDatas(biz.queryByCondition(parameter));
		} catch (RunException e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		} catch (Exception e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		}
		return rd;
	}

	public ResultDto queryByCondition(Parameter parameter, Page<E> page) {
		ResultDto rd = new ResultDto();
		try {
			Page<E> data = biz.queryByCondition(parameter, page);
			rd.setPageNo(data.getPageNo());
			rd.setPageSize(data.getPageSize());
			rd.setTotalRecord(data.getTotalRecord());
			rd.setTotalPage(data.getTotalPage());
			rd.setDatas(page.getData());
		} catch (RunException e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		} catch (Exception e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		}
		return rd;
	}

	public ResultDto queryByPrimaryKey(String id) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.queryByPrimaryKey(id));
		} catch (RunException e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		} catch (Exception e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		}
		return rd;
	}

	public ResultDto queryByPrimaryKeys(String... ids) {
		ResultDto rd = new ResultDto();
		try {
			rd.setDatas(biz.queryByPrimaryKeys(ids));
		} catch (RunException e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		} catch (Exception e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		}
		return rd;
	}

	public void setBiz(Biz<E> biz) {
		this.biz = biz;
	}

	public ResultDto unaudit(String... ids) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.unaudit(ids));
		} catch (RunException e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		} catch (Exception e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		}
		return rd;
	}

	public ResultDto updateByCondition(E entity, Parameter parameter) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.updateByCondition(entity, parameter));
		} catch (RunException e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		} catch (Exception e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		}
		return rd;
	}

	public ResultDto updateByConditionSelectives(E entity, Parameter parameter) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.updateByConditionSelectives(entity, parameter));
		} catch (RunException e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		} catch (Exception e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		}
		return rd;
	}

	public ResultDto updateByPrimaryKey(E entity) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.updateByPrimaryKey(entity));
		} catch (RunException e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		} catch (Exception e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		}
		return rd;
	}

	public ResultDto updateByPrimaryKeys(List<E> entityList) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.updateByPrimaryKeys(entityList));
		} catch (RunException e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		} catch (Exception e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		}
		return rd;
	}

	public ResultDto updateByPrimaryKeySelective(E entity) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.updateByPrimaryKeySelective(entity));
		} catch (RunException e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		} catch (Exception e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		}
		return rd;
	}

	public ResultDto updateByPrimaryKeySelectives(List<E> entityList) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.updateByPrimaryKeySelectives(entityList));
		} catch (RunException e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		} catch (Exception e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		}
		return rd;
	}

}
