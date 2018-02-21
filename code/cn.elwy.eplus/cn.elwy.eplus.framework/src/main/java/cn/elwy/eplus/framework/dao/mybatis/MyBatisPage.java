package cn.elwy.eplus.framework.dao.mybatis;

import java.io.Serializable;

import org.apache.ibatis.session.RowBounds;

/**
 * @description
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class MyBatisPage<E> extends RowBounds implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 总条数 */
	private long totalRecord;

	public MyBatisPage() {
	}

	public MyBatisPage(int offset, int limit) {
		super(offset, limit);
	}

	public long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}

}
