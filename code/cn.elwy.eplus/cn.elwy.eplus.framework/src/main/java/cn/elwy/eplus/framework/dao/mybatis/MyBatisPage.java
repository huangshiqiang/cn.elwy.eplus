package cn.elwy.eplus.framework.dao.mybatis;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.RowBounds;

/**
 * @description
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class MyBatisPage<E> extends RowBounds implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 当前页 */
	private int pageNo = 1;
	/** 页大小 : 每页的数量 */
	private int pageSize = 15;
	/** 总条数 */
	private long totalRecord;
	/** 查询结果 */
	private List<E> data;

	public MyBatisPage() {
	}

	public MyBatisPage(int offset, int limit) {
		super(offset, limit);
	}

	public void setPage(int pageNo, int pageSize) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}

	public List<E> getData() {
		return data;
	}

	public void setData(List<E> data) {
		this.data = data;
	}

}
