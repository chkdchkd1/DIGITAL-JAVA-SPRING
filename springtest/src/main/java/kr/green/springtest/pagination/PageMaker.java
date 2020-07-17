package kr.green.springtest.pagination;

public class PageMaker {

	//PageMaker 클래스는 현재 활성화된 페이지가 포함된 페이지들을 나타내는 클래스이다.
			// 클래스 초기화 순서 
		
		
			// 전체 컨텐츠의 수 (전제 게시글)
			private int totalCount;
			private int startPage;
			private int endPage;
			//현재 활성화된 페이지를 포함하는 페이지들의 시작페이지와 마지막페이지
			// 이전버튼 활성화 여부
			private boolean prev;
			// 다음버튼 활성화 여부 
			private boolean next;
			// 페이지네이션에서 보여주는 페이지의 갯수 (숫자를 몇개씩 보여줄지) ex)3 이면 123/ 456/ 789 이렇게 들어옴
			private int displayPageNum = 3;
			// '현재' 페이지 정보 
			private Criteria criteria;

			//math.ceil = 올림 (반올림X)
			
			public void calcData() {
				/* starPage와 endPage는 현재 페이지 정보인 criteria와 displayPageNum을 이용하여 계산
				 * displayPageNum이 10이고 현재 페이지가 3페이지면 startPage = 1, endPage = 10이 되도록 계산 */
				endPage = (int) (Math.ceil(criteria.getPage()/(double) displayPageNum)*displayPageNum);
				
				startPage = (endPage - displayPageNum)+1;
				/* 총 콘텐츠 갯수를 이용하여 마지막 페이지 번호를 계산 */
				int tempEndPage = (int)(Math.ceil(totalCount/(double)criteria.getPerPageNum()));
				
				/* 현재 페이지에 계산된 현재 페이지메이커의 마지막 페이지 번호와 실제 마지막 페이지 번호를 비교하여
				 * 작은 값이 마지막 페이지 번호가 됨 */
				if(endPage > tempEndPage) {
					endPage = tempEndPage;
				}
				/* 현재 페이지메이커에 시작페이지가 1페이지면 prev가 없어야 함 */
				prev = startPage == 1 ? false : true;
				/* 현재 페이지메이커에 마지막 페이지에 컨텐츠의 마지막이 포함되어 있으면 next가 없어야 함 */
				next = endPage * criteria.getPerPageNum() >= totalCount ? false:true;
			}

			public int getTotalCount() {
				return totalCount;
			}

			public void setTotalCount(int totalCount) {
				this.totalCount = totalCount;
				calcData();
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

			public boolean isPrev() {
				return prev;
			}

			public void setPrev(boolean prev) {
				this.prev = prev;
			}

			public boolean isNext() {
				return next;
			}

			public void setNext(boolean next) {
				this.next = next;
			}

			public int getDisplayPageNum() {
				return displayPageNum;
			}

			public void setDisplayPageNum(int displayPageNum) {
				this.displayPageNum = displayPageNum;
			}

			public Criteria getCriteria() {
				return criteria;
			}

			public void setCriteria(Criteria criteria) {
				this.criteria = criteria;
			}
			
			public int getLastEndPage() {
				return (int)(Math.ceil(totalCount/(double)criteria.getPerPageNum()));
			}
			
			@Override
			public String toString() {
				return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage
						+ ", prev=" + prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", criteria="
						+ criteria + "]";
			}
				
}
