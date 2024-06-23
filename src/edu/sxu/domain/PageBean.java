package edu.sxu.domain;
 
import java.util.List;

public class PageBean<T> {
	
	public PageBean(int currentPage, int size, int rowCount) {
		this.size = size;
		this.countPage = currentPage;
		this.count =rowCount;
		
//		����һ���ܵ�ҳ��
		countPage =(int)Math.ceil(count * 1.0 / size);
//		��һҳ  ÿҳ5������  limit 0,5   �ڶ�ҳ limit 5,5  ����ҳ limit 10,5
		startLine = (currentPage - 1) * size;
		
//		�ٶԵ�ǰҳ��һ�¼��
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
	
//	��ǰҳ
	private int currentPage;
	
	private int next;
	private int prev;
//	��ʼ��
	private int startLine;
//	������
	private int count;
//	��ҳ��
	private int countPage;
	
	private List<T> datas;
	
//	��ʼҳ
	private int startPage;
	private int endPage;
//	ÿҳ��������
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
