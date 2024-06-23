package edu.sxu.domain;
 
import java.util.List;

public class PageBean<T> {
	
	public PageBean(int currentPage, int size, int rowCount) {
		this.size = size;
		this.countPage = currentPage;
		this.count =rowCount;
		
//		计算一下总的页数
		countPage =(int)Math.ceil(count * 1.0 / size);
//		第一页  每页5条数据  limit 0,5   第二页 limit 5,5  第三页 limit 10,5
		startLine = (currentPage - 1) * size;
		
//		再对当前页做一下检查
		if(currentPage > countPage) {
			currentPage = countPage;
			endPage = countPage;
			startPage = currentPage - 4;
			if(startPage <= 1) {
				startPage = 1;
			}
			
		}else if(currentPage <= 1) {
			startPage = 1;
			currentPage = 1;
			endPage = currentPage + 4;
			if(endPage >= countPage) {
				endPage = countPage;
			}
		}
		
		next = currentPage + 1;
		prev = currentPage - 1;
		
		
		
	}
	
//	当前页
	private int currentPage;
	
	private int next;
	private int prev;
//	起始行
	private int startLine;
//	总数量
	private int count;
//	总页数
	private int countPage;
	
	private List<T> datas;
	
//	开始页
	private int startPage;
	private int endPage;
//	每页的数据量
	private int size;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public int getPrev() {
		return prev;
	}
	public void setPrev(int prev) {
		this.prev = prev;
	}
	public int getStartLine() {
		return startLine;
	}
	public void setStartLine(int startLine) {
		this.startLine = startLine;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCountPage() {
		return countPage;
	}
	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", next=" + next + ", prev=" + prev + ", startLine=" + startLine
				+ ", count=" + count + ", countPage=" + countPage + ", datas=" + datas + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", size=" + size + "]";
	}
	
	
	

}
