package cn.elwy.eplus.framework.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.common.entity.Pageable;
import cn.elwy.common.entity.Parameter;
import cn.elwy.common.entity.ResultDto;
import cn.elwy.common.exception.RunException;
import cn.elwy.common.util.Assert;
import cn.elwy.eplus.framework.biz.Biz;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@Transactional
public class BaseService<E> implements Service<E> {

	@Autowired
	protected Biz<E> biz;

	public Biz<E> getBiz() {
		return biz;
	}

	public void setBiz(Biz<E> biz) {
		this.biz = biz;
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

	public ResultDto deleteByPrimaryKey(E record) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.deleteByPrimaryKey(record));
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

	public ResultDto deleteByPrimaryKeys(List<E> recordList) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.deleteByPrimaryKeys(recordList));
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

	public ResultDto logicallyDeleteByCondition(Parameter parameter) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.logicallyDeleteByCondition(parameter));
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

	public ResultDto logicallyDeleteByPrimaryKey(E record) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.logicallyDeleteByPrimaryKey(record));
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

	public ResultDto logicallyDeleteByPrimaryKeys(List<E> recordList) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.logicallyDeleteByPrimaryKeys(recordList));
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

	public ResultDto recoverByCondition(Parameter parameter) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.recoverByCondition(parameter));
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

	public ResultDto recoverByPrimaryKey(E record) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.recoverByPrimaryKey(record));
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

	public ResultDto recoverByPrimaryKeys(List<E> recordList) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.recoverByPrimaryKeys(recordList));
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

	public ResultDto insert(E record) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.insert(record));
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

	public ResultDto insertBatch(List<E> recordList) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.insertBatch(recordList));
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

	public ResultDto insertBatchSelective(List<E> recordList) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.insertBatchSelective(recordList));
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

	public ResultDto insertSelective(E record) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.insertSelective(record));
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
	public ResultDto queryAllByPage(Pageable<E> page) {
		ResultDto rd = new ResultDto();
		try {
			Pageable<E> data = biz.queryAllByPage(page);

			rd.setPageNo(data.getPageNo());
			rd.setPageSize(data.getPageSize());
			rd.setTotalRecord(data.getTotalRecord());
			rd.setTotalPage(data.getTotalPage());
			rd.setDatas(page.getDatas());

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

	public ResultDto queryByCondition(Parameter parameter, Pageable<E> page) {
		ResultDto rd = new ResultDto();
		try {
			Pageable<E> data = biz.queryByCondition(parameter, page);
			rd.setPageNo(data.getPageNo());
			rd.setPageSize(data.getPageSize());
			rd.setTotalRecord(data.getTotalRecord());
			rd.setTotalPage(data.getTotalPage());
			rd.setDatas(page.getDatas());
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

	public ResultDto audit(E record) {
		Assert.notNull(record);
		List<E> recordList = new ArrayList<E>();
		recordList.add(record);
		return audit(recordList);
	}

	public ResultDto audit(List<E> recordList) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.audit(recordList));
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

	public ResultDto unaudit(E record) {
		Assert.notNull(record);
		List<E> recordList = new ArrayList<E>();
		recordList.add(record);
		return unaudit(recordList);
	}

	public ResultDto unaudit(List<E> recordList) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.unaudit(recordList));
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

	public ResultDto updateByCondition(Parameter parameter) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.updateByCondition(parameter));
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

	public ResultDto updateByConditionSelective(Parameter parameter) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.updateByConditionSelective(parameter));
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

	public ResultDto updateByPrimaryKey(E record) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.updateByPrimaryKey(record));
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

	public ResultDto updateByPrimaryKeys(List<E> recordList) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.updateByPrimaryKeys(recordList));
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

	public ResultDto updateByPrimaryKeySelective(E record) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.updateByPrimaryKeySelective(record));
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

	public ResultDto updateByPrimaryKeySelectives(List<E> recordList) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(biz.updateByPrimaryKeySelectives(recordList));
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
