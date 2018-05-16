package org.agent.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页支持 totalCount,pageSize,page必要参数 结果保存在items
 * 
 * @author Administrator
 *
 */
public class PageSupport {
	private Integer totalCount = 0;// 总记录数
	private Integer pageCount;// 总页数
	private Integer pageSize = 10;// 每页显示记录数

	private Integer page = 1;// 当前页

	private Integer num = 3;// 当前页前和后都能显示3页

	private List items = new ArrayList();

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		if (totalCount > 0) {
			this.totalCount = totalCount;
			this.pageCount = totalCount % pageSize > 0 ? totalCount / pageSize + 1 : totalCount / pageSize;
		}

	}

	// 前一页
	public Integer getPrev() {
		return this.page - 1;
	}

	// 下一页
	public Integer getNext() {
		return this.page + 1;
	}

	// 总页数
	public Integer getLast() {
		return this.pageCount;
	}

	// 判断是否有前一页
	public boolean getIsPrev() {
		if (page > 1)
			return true;
		else
			return false;
	}

	// 判断是否有后一页
	public boolean getIsNext() {
		if (pageCount != null && page < pageCount) {
			return true;
		} else {
			return false;
		}
	}

	public List<Integer> getPrevPages() {
		List<Integer> list = new ArrayList<Integer>();
		Integer _front = 1;
		if (page > num) {
			_front = page - num;
		}
		for (Integer i = _front; i < page; i++) {
			list.add(i);
		}
		return list;
	}

	public List<Integer> getNextPages() {
		List<Integer> list = new ArrayList<Integer>();
		Integer _end = 1;
		if (pageCount != null) {
			if (num < pageCount && (page + num) < pageCount) {
				_end = page + num;
			}
		}
		for (Integer i = page + 1; i < _end; i++) {
			list.add(i);
		}
		return list;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public List getItems() {
		return items;
	}

	public void setItems(List items) {
		this.items = items;
	}

}
