package cn.itcast.goods.pager;

import java.util.List;

/**
 * 分页实体类
 * @author jason
 *
 */
public class PageBean<T> {
	private int pc;	//PageCode 		当前页码
	private int tr;	//TotalRecord 	总记录数
	private int ps;	//PageSize		每页记录数
	private List<T> beanList;	//分页上的列表数据
	private String url;			//分页请求参数

	public PageBean() {
		super();
	}
	public PageBean(int pc, int tr, int ps, List<T> beanList, String url) {
		super();
		this.pc = pc;
		this.tr = tr;
		this.ps = ps;
		this.beanList = beanList;
		this.url = url;
	}
	public int getPc() {
		return pc;
	}
	public void setPc(int pc) {
		this.pc = pc;
	}
	public int getTp() {
		int tp = tr / ps;
		return tr%ps==0 ? tp : tp+1;
	}
	public int getTr() {
		return tr;
	}
	public void setTr(int tr) {
		this.tr = tr;
	}
	public int getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "PageBean [pc=" + pc + ", tr=" + tr + ", ps=" + ps
				+ ", beanList=" + beanList + ", url=" + url + "]";
	}
}
