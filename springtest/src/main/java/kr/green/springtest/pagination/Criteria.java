package kr.green.springtest.pagination;

public class Criteria {
	
	private int page;
	//현재페이지

	private int perPageNum;
	private int type;
	private String search;
	
	
	public Criteria() {
		page = 1;
		perPageNum = 5;
		type = 0;
		// 생략 가능, int는 기본 초기값이 0이기 때문에
		search = "";
		// search는 참조변수라 기본 초기값은 null 그래서 빈 문자열을 넣어주어야 
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if(page <=0)
			this.page = 1;
		else
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
	//this.type = (type < 0 || type > 3 ) ? 0 : type;
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
