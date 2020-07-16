package kr.green.spring.pagination;

public class Criteria {
	
	//Criteria 클래스는 한 페이지에 나타낼 콘텐츠의 갯수와 현재 페이지 번호를 나타낸다.
	
	//현재페이지
	private int page;
	//한 페이지 당 컨텐츠 갯수
	private int perPageNum;
	private String search;
	private int type;
	
	public Criteria() {
		page = 1;
		perPageNum = 3;
		search = "";
		type = 0;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page <= 0)
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

	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
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

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", search=" + search + ", type=" + type + "]";
	}

	public int getPageStart() {
		// 쿼리문 limit a(시작위치),b(반환갯수) 에서 a 자리에  (0번지) 들어갈 것 
		return (page - 1 )* perPageNum;
		// BoardMapper에서 #{cri.pageStart}는 변수를 말하는게 아니라 getter/setter를 가르키는 용어 
		//#{프로퍼티명} 예를 들어 #{title} 자리에는 getTitle()의 반환값이 놓인다. 
		//${}랑 헷갈리지말것 ~~.~~ 
		
	}
}
