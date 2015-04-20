package cn.itcast.cstm.domain;

import java.util.List;

public class PageBean<T> {
	private int pc;	//page code 
	private int ps;	//page size
	private int tr;	//total record
	//private int tp;	//total page
	List<T> beanList;
	private String url;	//url

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public PageBean() {
		super();
	}
	public PageBean(int pc, int ps, int tr, int tp, List<T> beanList) {
		super();
		this.pc = pc;
		this.ps = ps;
		this.tr = tr;
		this.beanList = beanList;
	}
	public int getPc() {
		return pc;
	}
	public void setPc(int pc) {
		this.pc = pc;
	}
	public int getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	public int getTr() {
		return tr;
	}
	public void setTr(int tr) {
		this.tr = tr;
	}
	public int getTp() {
		int tp = tr / ps;
		return tr%ps==0 ? tp:tp+1;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	@Override
	public String toString() {
		return "PageBean [pc=" + pc + ", ps=" + ps + ", tr=" + tr + ", tp="
				+ getTp() + ", beanList=" + beanList + "]";
	}
	
}
