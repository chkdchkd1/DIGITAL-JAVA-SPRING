package kr.green.springtest.pagination;

public class Criteria {
	
	private int page;
	private int perPageNum;
	private int type;
	private String search;
	
	
	public Criteria() {
		page = 1;
		perPageNum = 3;
		type = 0;
		search = "";
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		if(perPageNum <1 )
			this.perPageNum = 10; 
		this.perPageNum = perPageNum;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		if(type < 0 || type > 3) 
			this.type = 0;
		else 
			this.type = type;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
	public int getPageStart () {
		return (page - 1)*perPageNum;
	}
	
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", type=" + type + ", search=" + search + "]";
	}
	
	
	

}
