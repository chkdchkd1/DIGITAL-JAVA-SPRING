<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>네이버2 (off)</title>
	<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/naver2.css">
	<script src="<%= request.getContextPath() %>/resources/js/jquery.js"></script>
    <script src="<%= request.getContextPath() %>/resources/js/naver2.js"></script>
    <script src="<%= request.getContextPath() %>/resources/js/rolling.js"></script>
</head>
<body>
	<div class="box-whale">
		<div class="container">
			<a href="#" class="link-whale">
				<i class="icon-whale bg-44265f"></i>
				<img class="img-banner-whale" width="150px" height="auto" src="https://s.pstatic.net/static/www/img/uit/2020/img_whale_banner.483e9e.png" alt="네이버웨일 배너">
				<p class="text-banner">
					인터넷의 새로운 시작!
					<span class="text-underline">네이버 웨일</span>로
					차원이 다른 웹서핑을 경험해보세요!
				</p>
				<button class="btn-down-whale">다운로드</button>
				<button class="btn-container-whale">
					<span class="btn-closetext-whale">
						3일 동안 보지 않기
					</span>
					<span class="btn-close-whale bg-44265f"></span>
				</button>f
			</a>
		</div>
	</div>
	<div class="box-container-search">
		<div class="container">
			<a href="//naver.com" class="logo-naver bg-44265f"></a>
			<div class="box-search">
				<form action="">
					<input type="text" name="search"class="input-search">
					<a href="#"class="btn-v-keyboard">
						<i class="icon-v-keyboard bg-44265f"></i>
						<div class="box-msg-keyboard bg-44265f"></div>
					</a>
					<a href="#"class="btn-auto-search">
						<i class="icon-auto-search bg-44265f"></i>
					</a>
					<button class="btn-search">
						<i class="icon-search bg-44265f"></i>
					</button>
					<div class="box-auto-box display-none">
						<div class="box-auto-up">
							현재 자동완성 기능을 사용하고 계십니다.
						</div>
						<div class="box-auto-down">
							<span class="auto-l">
								<a href="#" class="link-help">도움말</a>
								<span class="auto-bar"></span>
								<a href="" class="link-report">신고</a>
							</span>
							<span class="auto-r">
								<a href="#" class="link-auto-close">자동완성 끄기</a>
							</span>
						</div>
					</div>
				</form>
			</div>
			<div class="box-container-service">
				<a href="#" class="link-set">네이버를 시작페이지로</a>
				<i class="icon-service-bar"></i>
				<a href="#" class="link-jr">
					<i class="icon-jr bg-44265f"></i>
				</a>
				<a href="#" class="link-happybean">
					<i class="icon-happybean bg-44265f"></i>
				</a>
			</div>
		</div>
	</div>
	<div class="box-container-menu">
		<div class="container">
            <div class="box-container-green">
                <div class="box-menu-green mail"> 
                    <a href="" class="link-menu-green">
                        <i class="icon bg-44265f"></i>메일
                    </a>
                </div>
                <div class="box-menu-green"> 
                    <a href="" class="link-menu-green">카페</a>
                </div>
                <div class="box-menu-green"> 
                    <a href="" class="link-menu-green">블로그</a>
                </div>
                <div class="box-menu-green"> 
                    <a href="" class="link-menu-green">지식iN</a>
                </div>
                <div class="box-menu-green"> 
                    <a href="" class="link-menu-green">쇼핑</a>
                </div>
                <div class="box-menu-green"> 
                    <a href="" class="link-menu-green">Pay</a>
                </div>
                <div class="box-menu-green tv"> 
                    <a href="" class="link-menu-green">
                        <i class="icon bg-44265f"></i>TV</a>
                </div>
            </div>
            <div class="box-container-black">
                <div class="box-menu-black">
                    <a href="" class="link-menu-black">사전</a>
                </div>
                <div class="box-menu-black">
                    <a href="" class="link-menu-black">뉴스</a>
                </div>
                <div class="box-menu-black">
                    <a href="" class="link-menu-black">증권</a>
                </div>
                <div class="box-menu-black">
                    <a href="" class="link-menu-black">부동산</a>
                </div>
                <div class="box-menu-black">
                    <a href="" class="link-menu-black">지도</a>
                </div>
                <div class="box-menu-black">
                    <a href="" class="link-menu-black">영화</a>
                </div>
                <div class="box-menu-black">
                    <a href="" class="link-menu-black">뮤직</a>
                </div>
                <div class="box-menu-black">
                    <a href="" class="link-menu-black">책</a>
                </div>
                <div class="box-menu-black">
                    <a href="" class="link-menu-black">웹툰</a>
                </div>
            </div>
            <a href="#" class="btn-more">더보기</a>
            <a href="#" class="btn-more fold display-none">접기</a>
            <div class="box-group-keyword">
                <a href="#" class="btn-keyword">
                    <i class="icon-error bg-44265f"></i>
                    <span class="text-keyword">검색어 필터 설정이 필요합니다</span>
                </a>
            </div>
            <div class="box-service-menu display display-none">
                <a href="#" class="link-service-menu">서비스 전체보기</a>
                <a href="#" class="btn-menu-set">메뉴설정</a>
            </div>
            <div class="box-service-menu set display-none">
                <a href="#" class="btn-service-init">초기화</a>
                <a href="#" class="btn-service-save">저장</a>
            </div>
        </div>
        <div class="box-container-servicelist display-none">
           <div class="container display">
               <div class="box-list-service">
                   <div class="box-service-title">ㄱ-ㄷ</div>
                   <a href="#" class="link-service">그라폴리오</a>
                   <a href="#" class="link-service">날씨</a>
                   <a href="#" class="link-service">네이버 예약</a>
                   <a href="#" class="link-service">네이버 클라우드</a>
                   <a href="#" class="link-service">네이버 포스트</a>
                   <a href="#" class="link-service">뉴스</a>
                   <a href="#" class="link-service">데이터랩</a>
                </div>
               <div class="box-list-service">
                   <div class="box-service-title">ㄹ-ㅅ</div>
                   <a href="#" class="link-service">만화/웹툰</a>
                   <a href="#" class="link-service">메모</a>
                   <a href="#" class="link-service">뮤직</a>
                   <a href="#" class="link-service">밴드</a>
                   <a href="#" class="link-service">부동산</a>
                   <a href="#" class="link-service">북마크</a>
                   <a href="#" class="link-service">소프트웨어</a>
                   <a href="#" class="link-service">스포츠</a>
                   <a href="#" class="link-service">시리즈</a>
                   <a href="#" class="link-service">시리즈on</a>
                </div>
               <div class="box-list-service">
                   <div class="box-service-title">ㅇ-ㅈ</div>
                   <a href="#" class="link-service">영화</a>
                   <a href="#" class="link-service">오디오클립</a>
                   <a href="#" class="link-service">오피스</a>
                   <a href="#" class="link-service">웹소설</a>
                   <a href="#" class="link-service">자동차</a>
                   <a href="#" class="link-service">주소록</a>
                   <a href="#" class="link-service">증권(금융)</a>
                   <a href="#" class="link-service">지도</a>
                   <a href="#" class="link-service">지식백과</a>
                </div>
               <div class="box-list-service">
                   <div class="box-service-title">ㅊ-ㅎ</div>
                   <a href="#" class="link-service">책</a>
                   <a href="#" class="link-service">캘린더</a>
                   <a href="#" class="link-service">학술정보</a>
                   <a href="#" class="link-service">항공권</a>
                   <a href="#" class="link-service">호텔</a>
                </div>
               <div class="box-list-service">
                   <div class="box-service-title">A-Z</div>
                   <a href="#" class="link-service">modoo![모두]</a>
                   <a href="#" class="link-service">MY구독</a>
                   <a href="#" class="link-service">PC게임</a>
                   <a href="#" class="link-service">TV연예</a>
                   <a href="#" class="link-service">V LIVE</a>
                </div>
               <div class="box-list-service">
                   <div class="box-service-title">사전</div>
                   <a href="#" class="link-service">사전</a>
                   <a href="#" class="link-service">국어사전</a>
                   <a href="#" class="link-service">영어/영영사전</a>
                   <a href="#" class="link-service">일본어사전</a>
                   <a href="#" class="link-service">중국어사전</a>
                   <a href="#" class="link-service">한자사전</a>
                   <a href="#" class="link-more">사전 더보기</a>


                </div>
               <div class="box-list-service">
                   <div class="box-service-title">인기/신규 서비스</div>
                   <a href="#" class="link-service">네이버플러스 멤버십</a>
                   <a href="#" class="link-service">클로바더빙</a>
                   <a href="#" class="link-service">인플루언서 검색</a>
                   <a href="#" class="link-service">Keep</a>
                   <a href="#" class="link-service">VIBE</a>
                   <a href="#" class="link-service">웨일</a>
                   <a href="#" class="link-service">파파고</a>
                </div>
            </div>
            <div class="container set display-none">
                <div class="box-list-service">
                    <div class="box-service-title">ㄱ-ㄷ</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i> 그라폴리오</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>날씨</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>네이버 예약</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>네이버 클라우드</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>네이버 포스트</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>뉴스</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>데이터랩</div>
                 </div>
                <div class="box-list-service">
                    <div class="box-service-title">ㄹ-ㅅ</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>만화/웹툰</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>메모</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>뮤직</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>밴드</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>부동산</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>북마크</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>소프트웨어</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>스포츠</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>시리즈</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>시리즈on</div>
                 </div>
                <div class="box-list-service">
                    <div class="box-service-title">ㅇ-ㅈ</div>
                    <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>영화</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>오디오클립</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>오피스</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>웹소설</div> 
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>자동차</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>주소록</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>증권(금융)</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>지도</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>지식백과</div>
                 </div>
                <div class="box-list-service">
                    <div class="box-service-title">ㅊ-ㅎ</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>책</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>캘린더</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>학술정보</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>항공권</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>호텔</div>
                 </div>
                <div class="box-list-service">
                    <div class="box-service-title">A-Z</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>modoo![모두]</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>MY구독</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>PC게임</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>TV연예</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>V LIVE</div>
                 </div>
                <div class="box-list-service">
                    <div class="box-service-title">사전</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>사전</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>국어사전</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>영어/영영사전</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>일본어사전</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>중국어사전</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>한자사전</div>
 
                 </div>
                <div class="box-list-service">
                    <div class="box-service-title">인기/신규 서비스</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>네이버플러스</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>클로바더빙</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>인플루언서 검색</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>Keep</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>VIBE</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>웨일</div>
                     <div class="box-service-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>파파고</div>
                 </div>
             </div>
        </div>
	</div>
	<div class="box-container-contents">
		<div class="container">
            <div class="box-left">
                <div class="box-left1">
                    <a href="#"></a>
                    <img width="750" height="135px" src="https://ssl.pstatic.net/tveta/libs/1282/1282740/b7de4ced147a82421056_20200618185424423.jpg" alt="">
                </div>
                <div class="box-left2">
                    <div class="box-issue-area">
                        <a href="" class="link-media">연합뉴스</a>
                        <div class="box-rolling-newlist">
                            <a href="#" class="box-rolling-news">재포장금지, 논란 속 내년 1월로 연기…유예기간 두기로(종합)</a>
                            <a href="#" class="box-rolling-news">집단확진 바로 옆 러 선박서도 선원 1명 양성 판정…같은 선사</a>
                            <a href="#" class="box-rolling-news">日신문 "수출규제, 일본에 타격"…한일 외교 55년 상기하기도</a>
                            <a href="#" class="box-rolling-news">'갓갓' 공범 안승진 얼굴 드러내…작은 체구에 안경 착용</a>
                        </div>
                    </div>
                    <div class="box-direct-area">
                        <a href="#" class="link-new">네이버뉴스</a>
                        <a href="#" class="link-direct">연예</a>
                        <a href="#" class="link-direct">스포츠</a>
                        <a href="#" class="link-direct">경제</a>
                    </div>
                </div>
                <div class="box-left3">
                    <div class="box-group-title">
                        <div class="float-left">
                            <a href="#" class="link-newstand">뉴스스탠드</a> <!-- @들어가는 말 앞뒤로 엔터 치면 공백들어감 주의@  -->
                            <a href="#" class="btn-sort">구독한 언론사</a>
                            <a href="#" class="btn-sort-all">전체언론사</a>
                        </div>
                        <div class="float-right">
                            <a href="#" class="btn-set"><i class="icon-list bg-44265f"></i></a>
                            <a href="#" class="btn-set"><i class="icon-title bg-44265f set"></i></a>
                            <a href="#" class="btn-set not"><i class="icon-set bg-44265f"></i></a>
                        </div>
                    </div>
                    <div class="box-group-contents">
                        <div class="line-row1"></div>
                        <div class="line-row2"></div>
                        <div class="line-row3"></div>
                        <div class="line-col1"></div>
                        <div class="line-col2"></div>
                        <div class="line-col3"></div>
                        <div class="line-col4"></div>
                        <div class="line-col5"></div>
                        <div class="line-col6"></div>
                        <div class="line-col7"></div>
                        <div class="box-row">
                            <div class="box-thumb-area">
                                <img src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/020.png" alt="" height="20">
                                <div class="box-thumb display-none">
                                    <a href="#" class="btn-subs">구독</a>
                                    <a href="#" class="btn-view">기사보기</a>
                                </div>
                            </div>
                            <div class="box-thumb-area">
                                <img src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/327.png" alt="" height="20">
                                <div class="box-thumb display-none">
                                    <a href="#" class="btn-subs">구독</a>
                                    <a href="#" class="btn-view">기사보기</a>
                                </div>
                            </div>
                            <div class="box-thumb-area">
                                <img src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/117.png" alt="" height="20">
                                <div class="box-thumb display-none">
                                    <a href="#" class="btn-subs">구독</a>
                                    <a href="#" class="btn-view">기사보기</a>
                                </div>
                            </div>
                            <div class="box-thumb-area">
                                <img src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/376.png" alt="" height="20">
                                <div class="box-thumb display-none">
                                    <a href="#" class="btn-subs">구독</a>
                                    <a href="#" class="btn-view">기사보기</a>
                                </div>
                            </div>
                            <div class="box-thumb-area">
                                <img src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/038.png" alt="" height="20">
                                <div class="box-thumb display-none">
                                    <a href="#" class="btn-subs">구독</a>
                                    <a href="#" class="btn-view">기사보기</a>
                                </div>
                            </div>
                            <div class="box-thumb-area">
                                <img src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/032.png" alt="" height="20">
                                <div class="box-thumb display-none">
                                    <a href="#" class="btn-subs">구독</a>
                                    <a href="#" class="btn-view">기사보기</a>
                                </div>
                            </div>
                        </div>
                        <div class="box-row">
                            <div class="box-thumb-area">
                                <img src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/308.png" alt="" height="20">
                                <div class="box-thumb display-none">
                                    <a href="#" class="btn-subs">구독</a>
                                    <a href="#" class="btn-view">기사보기</a>
                                </div>
                            </div>
                            <div class="box-thumb-area">
                                <img src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/003.png" alt="" height="20">
                                <div class="box-thumb display-none">
                                    <a href="#" class="btn-subs">구독</a>
                                    <a href="#" class="btn-view">기사보기</a>
                                </div>
                            </div>
                            <div class="box-thumb-area">
                                <img src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/143.png" alt="" height="20">
                                <div class="box-thumb display-none">
                                    <a href="#" class="btn-subs">구독</a>
                                    <a href="#" class="btn-view">기사보기</a>
                                </div>
                            </div>
                            <div class="box-thumb-area">
                                <img src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/910.png" alt="" height="20">
                                <div class="box-thumb display-none">
                                    <a href="#" class="btn-subs">구독</a>
                                    <a href="#" class="btn-view">기사보기</a>
                                </div>
                            </div>
                            <div class="box-thumb-area">
                                <img src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/806.png" alt="" height="20">
                                <div class="box-thumb display-none">
                                    <a href="#" class="btn-subs">구독</a>
                                    <a href="#" class="btn-view">기사보기</a>
                                </div>
                            </div>
                            <div class="box-thumb-area">
                                <img src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/902.png" alt="" height="20">
                                <div class="box-thumb display-none">
                                    <a href="#" class="btn-subs">구독</a>
                                    <a href="#" class="btn-view">기사보기</a>
                                </div>
                            </div>
                        </div>
                        <div class="box-row">
                            <div class="box-thumb-area">
                                <img src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/956.png" alt="" height="20">
                                <div class="box-thumb display-none">
                                    <a href="#" class="btn-subs">구독</a>
                                    <a href="#" class="btn-view">기사보기</a>
                                </div>
                            </div>
                            <div class="box-thumb-area">
                                <img src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/826.png" alt="" height="20">
                                <div class="box-thumb display-none">
                                    <a href="#" class="btn-subs">구독</a>
                                    <a href="#" class="btn-view">기사보기</a>
                                </div>
                            </div>
                            <div class="box-thumb-area">
                                <img src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/936.png" alt="" height="20">
                                <div class="box-thumb display-none">
                                    <a href="#" class="btn-subs">구독</a>
                                    <a href="#" class="btn-view">기사보기</a>
                                </div>
                            </div>
                            <div class="box-thumb-area">
                                <img src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/955.png" alt="" height="20">
                                <div class="box-thumb display-none">
                                    <a href="#" class="btn-subs">구독</a>
                                    <a href="#" class="btn-view">기사보기</a>
                                </div>
                            </div>
                            <div class="box-thumb-area">
                                <img src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/961.png" alt="" height="20">
                                <div class="box-thumb display-none">
                                    <a href="#" class="btn-subs">구독</a>
                                    <a href="#" class="btn-view">기사보기</a>
                                </div>
                            </div>
                            <div class="box-thumb-area">
                                <img src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/911.png" alt="" height="20">
                                <div class="box-thumb display-none">
                                    <a href="#" class="btn-subs">구독</a>
                                    <a href="#" class="btn-view">기사보기</a>
                                </div>
                            </div>
                        </div>
                        <div class="box-row">
                            <div class="box-thumb-area">
                                <img src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/345.png" alt="" height="20">
                                <div class="box-thumb display-none">
                                    <a href="#" class="btn-subs">구독</a>
                                    <a href="#" class="btn-view">기사보기</a>
                                </div>
                            </div>
                            <div class="box-thumb-area">
                                <img src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/986.png" alt="" height="20">
                                <div class="box-thumb display-none">
                                    <a href="#" class="btn-subs">구독</a>
                                    <a href="#" class="btn-view">기사보기</a>
                                </div>
                            </div>
                            <div class="box-thumb-area">
                                <img src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/824.png" alt="" height="20">
                                <div class="box-thumb display-none">
                                    <a href="#" class="btn-subs">구독</a>
                                    <a href="#" class="btn-view">기사보기</a>
                                </div>
                            </div>
                            <div class="box-thumb-area">
                                <img src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/980.png" alt="" height="20">
                                <div class="box-thumb display-none">
                                    <a href="#" class="btn-subs">구독</a>
                                    <a href="#" class="btn-view">기사보기</a>
                                </div>
                            </div>
                            <div class="box-thumb-area">
                                <img src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/908.png" alt="" height="20">
                                <div class="box-thumb display-none">
                                    <a href="#" class="btn-subs">구독</a>
                                    <a href="#" class="btn-view">기사보기</a>
                                </div>
                            </div>
                            <div class="box-thumb-area">
                                <img src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/922.png" alt="" height="20">
                                <div class="box-thumb display-none">
                                    <a href="#" class="btn-subs">구독</a>
                                    <a href="#" class="btn-view">기사보기</a>
                                </div>
                            </div>
                        </div>
                        <a href="#" class="btn-news-prev">
                            <i class="icon-news-prev bg-44265f"></i>
                        </a>
                        <a href="#" class="btn-news-next">
                            <i class="icon-news-next bg-44265f"></i>
                        </a>

                    </div>
                </div>
                <div class="box-left4">
                    <div class="box-theme-head">
                        <div class="box-theme-title">
                            <div class="area-title">
                                <strong class="title">오늘 읽을만한 글</strong>
                                <span class="dsc">주제별로 분류된 다양한 글 모음</span>
                            </div>
                            <div class="area-info">
                                <span class="info"><strong>2,177</strong>개의 글</span>
                                <a href="#" class="btn-setting">관심주제 설정</a>
                            </div>
                        </div>
                        <div class="box-theme-wrap">
                            <a href="#" class="btn-prev bg-44265f"></a>
                            <a href="#" class="btn-next bg-44265f"></a>
                            <div class="box-theme-container">
                                <ul class="list-category">
                                    <li class="category-item">
                                        <a href="#" class="btn-tab" aria-selected="true" data-target="enter">엔터</a>
                                    </li>
                                    <li class="category-item">
                                        <a href="#" class="btn-tab" data-target="sports">스포츠</a>
                                    </li>
                                    <li class="category-item">
                                        <a href="#" class="btn-tab" data-target="car">자동차</a>
                                    </li>
                                    <li class="category-item">
                                        <a href="#" class="btn-tab" data-target="webtoon">웹툰</a>
                                    </li>
                                    <li class="category-item">
                                        <a href="#" class="btn-tab" data-target="economic">경제M</a>
                                    </li>
                                    <li class="category-item">
                                        <a href="#" class="btn-tab" data-target="food">푸드</a>
                                    </li>
                                    <li class="category-item">
                                        <a href="#" class="btn-tab" data-target="game">게임</a>
                                    </li>
                                    <li class="category-item">
                                        <a href="#" class="btn-tab tab-movie" data-target="movie">영화</a>
                                    </li>
                                    <li class="category-item">
                                        <a href="#" class="btn-tab tab-job">JOB&</a>
                                    </li>
                                    <li class="category-item">
                                        <a href="#" class="btn-tab">테크</a>
                                    </li>
                                    <li class="category-item">
                                        <a href="#" class="btn-tab">여행+</a>
                                    </li>
                                    <li class="category-item">
                                        <a href="#" class="btn-tab">과학</a>
                                    </li>
                                    <li class="category-item">
                                        <a href="#" class="btn-tab">리빙</a>
                                    </li>
                                    <li class="category-item">
                                        <a href="#" class="btn-tab">건강</a>
                                    </li>
                                    <li class="category-item">
                                        <a href="#" class="btn-tab">비즈니스</a>
                                    </li>
                                    <li class="category-item">
                                        <a href="#" class="btn-tab tab-wedding">연애·결혼</a>
                                    </li>
                                    <li class="category-item">
                                        <a href="#" class="btn-tab tab-book">책문화</a>
                                    </li>
                                    <li class="category-item">
                                        <a href="#" class="btn-tab">부모i</a>
                                    </li>
                                    <li class="category-item">
                                        <a href="#" class="btn-tab">법률</a>
                                    </li>
                                    <li class="category-item">
                                        <a href="#" class="btn-tab">패션뷰티</a>
                                    </li>
                                    <li class="category-item">
                                        <a href="#" class="btn-tab">동물공감</a>
                                    </li>
                                    <li class="category-item">
                                        <a href="#" class="btn-tab">디자인</a>
                                    </li>
                                    <li class="category-item">
                                        <a href="#" class="btn-tab">중국</a>
                                    </li>
                                    <li class="category-item">
                                        <a href="#" class="btn-tab tab-farm">FARM</a>
                                    </li>
                                    <li class="category-item">
                                        <a href="#" class="btn-tab tab-show">공연전시</a>
                                    </li>
                                    <li class="category-item">
                                        <a href="#" class="btn-tab">함께N</a>
                                    </li>
                                    <li class="category-item">
                                        <a href="#" class="btn-tab">스쿨잼</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="box-theme-body">
                        <div class="box-body enter">엔터</div>
                        <div class="box-body sports">스포츠</div>
                        <div class="box-body car">자동차</div>
                        <div class="box-body webtoon">웹툰</div>
                        <div class="box-body economic">경제M</div>
                        <div class="box-body food">푸드</div>
                        <div class="box-body game">게임</div>
                        <div class="box-body movie">영화</div>
                    </div>
                </div>
            </div>
            <div class="box-right">
                <div class="box-right1">
                    <p class="msg-login">네이버를 더 안전하고 편리하게 이용하세요</p>
                    <a href="#" class="link-login">
                        <i class="icon-login-naver bg-44265f"></i>로그인
                    </a>
                    <div class="box-sub-area">
                        <div class="box-look">
                            <a href="#" class="link-find-id">아이디</a>
                            <a href="#" class="link-find-pw">비밀번호찾기</a>
                        </div>
                        <a href="#" class="link-join">회원가입</a>
                    </div>
                </div>
                <div class="box-right2">
                    <div class="box-card-wrap">
                        <div class="box-card-nav">
                            <a href="#" class="box-card1 card">
                                <i class="badge-news">이슈</i>
                                <span class="text-news">코로나바이러스감염증19 현황</span>
                            </a>
                            <a href="#" class="box-card2 card">
                                <div class="box-current">
                                    <strong class="text-current">23.2°</strong>
                                    <strong class="text-state">흐림</strong>
                                </div>
                                <div class="box-degree">
                                    <span class="text-degree-max">25.0°</span>
                                    <span class="text-degree-min">21.0°</span>
                                </div>
                                <div class="box-location">서초동</div>
                            </a>
                        </div>
                    </div>
                    <div class="box-btn">
                        <div class="box-btn-wrap">
                            <a href="#" class="btn-nav-prev"></a>
                            <a href="#" class="btn-nav-next"></a>
                        </div>
                    </div>
                </div>
                <div class="box-right3">
                    <a href="#">
                       <img src="https://ssl.pstatic.net/tveta/libs/1290/1290876/1b63827ca8a87851ac24_20200601095846743.png" alt="">
                    </a>
                </div>
                <div class="box-right4">
                    <div class="box-shop-header">
                        <div class="text-shop">쇼핑</div>
                        <ul class="shop-tab">
                            <li class="tab-item"><a href="#" class="tab" aria-selected="true" data-target="product">상품</a></li>
                            <li class="tab-item"><a href="#" class="tab" data-target="mall">쇼핑몰</a></li>
                            <li class="tab-item"><a href="#" class="tab" data-target="men">MEN</a></li>
                        </ul>
                    </div>
                    <div class="box-shop-middle">
                        <div class="box-mall">
                            <a href="#" class="link-mall">G마켓</a>
                            <span class="comma"></span>
                            <a href="#" class="link-mall">옥션</a>
                            <span class="comma"></span>
                            <a href="#" class="link-mall">11번가</a>
                            <span class="comma"></span>
                            <a href="#" class="link-mall">위메프</a>
                            <span class="comma"></span>
                            <a href="#" class="link-mall">티몬</a>
                            <span class="comma"></span>
                            <a href="#" class="link-mall">이마트몰</a>
                        </div>
                        <div class="box-mall">
                            <a href="#" class="link-mall">올리브영</a>
                            <span class="comma"></span>
                            <a href="#" class="link-mall">GS샵</a>
                            <span class="comma"></span>
                            <a href="#" class="link-mall">롯데i몰</a>
                            <span class="comma"></span>
                            <a href="#" class="link-mall">CJmall</a>
                            <span class="comma"></span>
                            <a href="#" class="link-mall">신세계몰</a>
                            <span class="comma"></span>
                            <a href="#" class="link-mall">롯데ON</a>
                        </div>
                    </div>
                    <div class="box-shop-body">
                        <div class="box-goods product">
                            <div class="box-shop-control">
                                <div class="box-num">
                                    <span class="current-num">1</span>
                                   / <span class="max-num">19</span>
                                </div>
                                <div class="box-btn">
                                    <a href="#" class="btn-prev"></a>
                                    <a href="#" class="btn-next"></a>
                                </div>
                            </div>
                            <ul class="list-goods">
                                <li class="goods-item">
                                    <a href="#">
                                        <img src="https://s.pstatic.net/shopping.phinf/20200629_26/62a21d87-3b1c-4771-b76a-a21f0cb5f3c7.jpg?type=f214_292" alt="">
                                        <p>
                                        <span>나도모르게손이가</span>
                                        <span>맛보면너도알걸?</span>
                                        </p>
                                    </a>
                                </li>
                                <li class="goods-item">
                                    <a href="#">
                                        <img src="https://s.pstatic.net/shopping.phinf/20200629_26/62a21d87-3b1c-4771-b76a-a21f0cb5f3c7.jpg?type=f214_292" alt="">
                                        <p>
                                        <span>나도모르게손이가</span>
                                        <span>맛보면너도알걸?</span>
                                        </p>
                                    </a>
                                </li>
                                <li class="goods-item">
                                    <a href="#">
                                        <img src="https://s.pstatic.net/shopping.phinf/20200629_26/62a21d87-3b1c-4771-b76a-a21f0cb5f3c7.jpg?type=f214_292" alt="">
                                        <p>
                                        <span>나도모르게손이가</span>
                                        <span>맛보면너도알걸?</span>
                                        </p>
                                    </a>
                                </li>
                                <li class="goods-item">
                                    <a href="#">
                                        <img src="https://s.pstatic.net/shopping.phinf/20200629_26/62a21d87-3b1c-4771-b76a-a21f0cb5f3c7.jpg?type=f214_292" alt="">
                                        <p>
                                        <span>나도모르게손이가</span>
                                        <span>맛보면너도알걸?</span>
                                        </p>
                                    </a>
                                </li>
                                <li class="goods-item">
                                    <a href="#">
                                        <img src="https://s.pstatic.net/shopping.phinf/20200629_26/62a21d87-3b1c-4771-b76a-a21f0cb5f3c7.jpg?type=f214_292" alt="">
                                        <p>
                                        <span>나도모르게손이가</span>
                                        <span>맛보면너도알걸?</span>
                                        </p>
                                    </a>
                                </li>
                                <li class="goods-item">
                                    <a href="#">
                                        <img src="https://s.pstatic.net/shopping.phinf/20200629_26/62a21d87-3b1c-4771-b76a-a21f0cb5f3c7.jpg?type=f214_292" alt="">
                                        <p>
                                        <span>나도모르게손이가</span>
                                        <span>맛보면너도알걸?</span>
                                        </p>
                                    </a>
                                </li>
                                <li class="goods-item">
                                    <a href="#">
                                        <img src="https://s.pstatic.net/shopping.phinf/20200629_26/62a21d87-3b1c-4771-b76a-a21f0cb5f3c7.jpg?type=f214_292" alt="">
                                        <p>
                                        <span>나도모르게손이가</span>
                                        <span>맛보면너도알걸?</span>
                                        </p>
                                    </a>
                                </li>
                                <li class="goods-item">
                                    <a href="#">
                                        <img src="https://s.pstatic.net/shopping.phinf/20200629_26/62a21d87-3b1c-4771-b76a-a21f0cb5f3c7.jpg?type=f214_292" alt="">
                                        <p>
                                        <span>나도모르게손이가</span>
                                        <span>맛보면너도알걸?</span>
                                        </p>
                                    </a>
                                </li>
                                <li class="goods-item">
                                    <a href="#">
                                        <img src="https://s.pstatic.net/shopping.phinf/20200629_26/62a21d87-3b1c-4771-b76a-a21f0cb5f3c7.jpg?type=f214_292" alt="">
                                        <p>
                                        <span>나도모르게손이가</span>
                                        <span>맛보면너도알걸?</span>
                                        </p>
                                    </a>
                                </li>
                                <li class="goods-item">
                                    <a href="#">
                                        <img src="https://s.pstatic.net/shopping.phinf/20200629_26/62a21d87-3b1c-4771-b76a-a21f0cb5f3c7.jpg?type=f214_292" alt="">
                                        <p>
                                        <span>나도모르게손이가</span>
                                        <span>맛보면너도알걸?</span>
                                        </p>
                                    </a>
                                </li>
                                <li class="goods-item">
                                    <a href="#">
                                        <img src="https://s.pstatic.net/shopping.phinf/20200629_26/62a21d87-3b1c-4771-b76a-a21f0cb5f3c7.jpg?type=f214_292" alt="">
                                        <p>
                                        <span>나도모르게손이가</span>
                                        <span>맛보면너도알걸?</span>
                                        </p>
                                    </a>
                                </li>
                                <li class="goods-item">
                                    <a href="#">
                                        <img src="https://s.pstatic.net/shopping.phinf/20200629_26/62a21d87-3b1c-4771-b76a-a21f0cb5f3c7.jpg?type=f214_292" alt="">
                                        <p>
                                        <span>나도모르게손이가</span>
                                        <span>맛보면너도알걸?</span>
                                        </p>
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <div class="box-mall mall">
                            <div class="box-shop-control">
                                <div class="box-num">
                                    <span class="current-num">1</span>
                                    / <span class="max-num">13</span>
                                </div>
                                <div class="box-btn">
                                    <a href="#" class="btn-prev"></a>
                                    <a href="#" class="btn-next"></a>
                                </div>
                            </div>
                        </div>
                        <div class="box-goods men">
                            <div class="box-shop-control">
                                <div class="box-num">
                                    <span class="current-num">1</span>
                                    / <span class="max-num">6</span>
                                </div>
                                <div class="box-btn">
                                    <a href="#" class="btn-prev"></a>
                                    <a href="#" class="btn-next"></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
	</div>
	<div class="box-container-footer">
		<div class="container"></div>
	</div>
	<script>
		
	</script>
</body>
</html>