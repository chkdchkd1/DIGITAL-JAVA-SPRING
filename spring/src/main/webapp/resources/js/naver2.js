$(function(){
	var defaultMenu = ['사전','뉴스','증권','부동산','지도','영화','뮤직','책','웹툰'];
	var defaultMenuLink 
	= ['https://dict.naver.com/',
		'https://news.naver.com/',
		'https://finance.naver.com/',
		'https://land.naver.com/',
		'https://map.naver.com/',
		'https://movie.naver.com/',
		'https://vibe.naver.com/?from=naver_main',
		'https://book.naver.com/',
		'https://comic.naver.com/',
		]
	var selectMenu = []; // == 배열 
	var selectMenuLink =[];
	var allMenuLink =['모든 링크가 위에처럼 있어야함'];
	var tempMenu = []; // 내가 선택한 메뉴 임시로 저장 

	$('html').scrollTop(0);
	$('.btn-container-whale').click(function(e){
		$('.box-whale').addClass('display-none');
		//3일동안 보지 않기 버튼을 클릭했을 때 URL에 #이 붙는걸 방지
		e.preventDefault();
	})
	//자동 완성 버튼을 클릭하면 
	$('.btn-auto-search').click(function(){
		//자동 완성 기능이 활성화/비활성화
		$('.box-auto-box').toggleClass('display-none');
		//자동 완성 버튼 모양을 위로/아래로
		$('.icon-auto-search').toggleClass('active');
	})
	$('.link-auto-close').click(function(e){
		$('.btn-auto-search').click();
		e.preventDefault();
	})
	//더보기/접기 버튼 클릭 
    $('.btn-more').click(function(){
        $('.box-group-keyword').toggleClass('display-none');
        $('.box-service-menu.display').toggleClass('display-none');
        $('.box-container-servicelist').toggleClass('display-none');
		$('.btn-more').toggleClass('display-none');
		if ($(this).hasClass('fold')){
			initMenu();
		}
	})
	
	//메뉴설정에서 메뉴 선택시 
	$('.box-service-check').click(function(){
		var selMenu = $(this).text();
		// 이미 선택된 메뉴를 클릭해서 선택을 해제하는 경우 
		if(tempMenu.indexOf(selMenu) >=0){
		//indexof = 검색함수 없으면 -1 
			tempMenu.splice(tempMenu.indexOf(selMenu),1);
			//array.splice(start[, deleteCount[, item1[, item2[, ...]]]]) 메서드는 배열의 기존 요소를 삭제 또는 교체하거나 새 요소를 추가하여 배열의 내용을 변경합니다.
			$(this).find('input').prop('checked',false);
		//메뉴를 선택한 경우
		}else{
			if(tempMenu.length == 5 ){
				alert('최대5개까지 설정할 수 있습니다');
				return;
			}
			tempMenu.push(selMenu);
			//선택된 요소의 자손 중 input태그의 checked 속성을 true로 설정 
			$(this).find('input').prop('checked',true);
		}

		$(this).find('.icon-check').toggleClass('checked');
		var cnt = 0;
		var max = 5;
		$('.box-menu-black').each(function(){
			if (cnt < tempMenu.length){
				$(this).removeClass('box-empty select'); 
				// 여러 클래스를 한번에 지울려면 띄어쓰기로 구분한다.; 
				$(this).find('.link-menu-black').text(tempMenu[cnt]);
			}else{
				if(cnt == tempMenu.length && cnt < 5 ){
					$(this).addClass('select');
				} else{
					$(this).removeClass('select');
				} 
				$(this).addClass('box-empty')
				$(this).find('.link-menu-black').text('');
			}
				cnt++;
		})
	})



	//메뉴 설정 버튼 클릭 
	$('.btn-menu-set').click(function(){
		$('.box-service-menu.display').addClass('display-none');
		$('.box-service-menu.set').removeClass('display-none');
		$('.box-container-servicelist .container.display').addClass('display-none');
		$('.box-container-servicelist .container.set').removeClass('display-none');
		// 검은색 메뉴 박스 부분
		var cnt = 0;
		var max = 5; 
		$('.box-menu-black').each(function(){
			if (cnt < selectMenu.length){
			
			}
			else if(cnt < max){
				if(selectMenu.length == cnt)
						$(this).addClass('select');
					$(this).addClass('box-empty');
					$(this).find('.link-menu-black').text('');
					$(this).removeClass('display-none');
			} else{
				$(this).addClass('display-none');
			}
			cnt++;
		})

		$('.box-service-check input').each(function(){
			var isChecked = $(this).prop('checked');
			if(isChecked){
				$(this).siblings('.icon-check').addClass('checked')
			}
		})
	
	})

	//저장 버튼
		$('.btn-service-save').click(function(){
			selectMenu = tempMenu.slice();
			$('.fold').click();
		})

		$('.fold').click(function(){
			$('.box-menu-black').removeClass('box-empty select');
			var cnt = 0;
			var max = 5;
			$('.box-menu-black').each(function(){
				if(selectMenu.length != 0 ){
					if(cnt >= selectMenu.length)
						$(this).addClass('display-none');
				}else{
					$(this).removeClass('display-none');
					$(this).find('.link-menu-black').text(defaultMenu[cnt]);
				}
				cnt++;
			});
		})
		//기본 메뉴에서 메뉴 설정 클릭 후 메뉴를 선택 후 접기 버튼을 클릭하거나 
		// 메뉴 설정 클릭 후 메뉴를 선택하지 않고 접기 버튼을 클릭 
	
	//초기화 버튼 
	$('.btn-service-init').click(function(){
		alert('초기설정으로 돌아갑니다.');
		selectMenu = [];
		$('.box-service-check>input').prop('checked',false);	
		$('.fold').click();
	})


	$('.btn-set').click(function(){
		if(!$(this).hasClass('not')){
			$('.btn-set>i').removeClass('set');
			$(this).find('i').addClass('set');
		}
	})

	$('.btn-set').hover(function(){
		$(this).find('i').toggleClass('hover');
	})

	$('.box-thumb-area').hover(function(){
		$(this).find('img').toggleClass('display-none');
		$(this).find('.box-thumb').toggleClass('display-none');
	})

	$('.box-thumb>a').hover(function(){
		$(this).toggleClass('active');
		$(this).siblings().toggleClass('disable')
	})

	$('.btn-nav-prev').click(function(e){
		/*.box-card-nav>.card 요소가 애니메이션 중이 아니면 동작하고, 애니메이션 중이면 아무일도 안함*/
		/*첫 애니메이트가 동작 중인데 또 클릭해서 동작시켜서 겹쳐 보이는걸 방지 ㅇㅇ */ 
		if(!$('.box-card-nav>.card').is(':animated')){
		$('.box-card-nav>.card').last().detach().prependTo('.box-card-nav').css('margin-left','-281px');
		$('.box-card-nav>.card').first().animate({'margin-left':'0'},1000);
		}
	})

	$('.btn-nav-next').click(function(e){
		if(!$('.box-card-nav>.card').is(':animated')){
		$('.box-card-nav>.card').first().animate({'margin-left':'-281px'},1000,function(){
			$(this).detach().appendTo('.box-card-nav').removeAttr('style');
			e.preventDefault();
		});
		}
	})

	$('.box-theme-wrap .btn-tab').click(function(e){
		e.preventDefault();
		$('.box-theme-wrap .btn-tab').attr('aria-selected','false');
		$(this).attr('aria-selected','true');
		themeBtnView();
		themeBodyView();


		// 태그안에 속성의 값을 설정할때 사용 =attr (속성이란 형광연하늘색으로 표시되는것들)
		/* $(선택자).attr('속성명','값A') : 해당 요소의 속성의 값을 값A로 설정
		   $(선택자).attr('속성명') : 해당 요소의 속성의 값을 가져옴 
		   $(선택자).prop('속성명','값A') : 해당 요소의 속성의 값을 값A로 설정
		   $(선택자).prop('속성명') : 해당 요소의 속성의 값을 가져옴 
		   */ 
	})
	//find()는 선택자 밑에 ()<-에들어가는게 있는지 확인 하는 
	$('.box-theme-wrap .btn-prev').click(function(e){
		e.preventDefault();
		if($('.btn-tab[aria-selected=true]').hasClass('tab-job')){
			$('.list-category').animate({'margin-left':'0px'},1000)
		}
		if($('.btn-tab[aria-selected=true]').hasClass('tab-book')){
			$('.list-category').animate({'margin-left':'-750px'},1000)
		}
		if($('.btn-tab[aria-selected=true]').hasClass('tab-show')){
			$('.list-category').animate({'margin-left':'-1500px'},1000)
		}

		$('.btn-tab[aria-selected=true]').attr('aria-selected','false').parent().prev().find('.btn-tab').attr('aria-selected','true');
		themeBtnView();
		themeBodyView();

	})

	$('.box-theme-wrap .btn-next').click(function(e){
		e.preventDefault();
		if($('.btn-tab[aria-selected=true]').hasClass('tab-movie')){
			$('.list-category').animate({'margin-left':'-750px'},1000)
		}
		if($('.btn-tab[aria-selected=true]').hasClass('tab-wedding')){
			$('.list-category').animate({'margin-left':'-1500px'},1000)
		}
		if($('.btn-tab[aria-selected=true]').hasClass('tab-farm')){
			$('.list-category').animate({'margin-left':'-2250px'},1000)
		}

		$('.btn-tab[aria-selected=true]').attr('aria-selected','false').parent().next().find('.btn-tab').attr('aria-selected','true');
		themeBtnView();
		themeBodyView();

	})


	themeBodyView();
	function themeBodyView(){
		var target = $('.btn-tab[aria-selected=true]').attr('data-target');
		$('.box-theme-body .box-body').addClass('display-none');
		$('.box-theme-body>.'+target).removeClass('display-none')
	}

	themeBtnView();

	//버튼 보이는 경우 or 안보이는 경우 
	function themeBtnView(){
		$('.box-theme-wrap .btn-prev').removeClass('display-none')
		$('.box-theme-wrap .btn-next').removeClass('display-none')
		if($('.box-theme-wrap .btn-tab').first().attr('aria-selected') == 'true'){
			$('.box-theme-wrap .btn-prev').addClass('display-none');
		}
		if($('.box-theme-wrap .btn-tab').last().attr('aria-selected') == 'true'){
			$('.box-theme-wrap .btn-next').addClass('display-none');
		}
	} 

	function initMenu(){
		$('.box-service-menu.display').addClass('display-none');
		$('.box-service-menu.set').addClass('display-none');
		$('.box-container-servicelist .container.display').removeClass('display-none');
		$('.box-container-servicelist .container.set').addClass('display-none');	
		// 메뉴 설정에서 선택된 체크박스를 전부 해지 
		$('.icon-check').removeClass('checked');

	}

	$('.box-shop-header .tab').click(function(e){
		e.preventDefault();
		$('.box-shop-header .tab').attr('aria-selected','false');
		$(this).attr('aria-selected','true');
		shopView();
		tabRamdom();
		var target = $(this).attr('data-target');
		if(target == 'mall'){
			$('.box-shop-middle').addClass('display-none');
		} else {
			$('.box-shop-middle').removeClass('display-none');
		}
	})



	/*오른쪽 3번째 컨텐츠에서 상품/쇼핑몰/MEN이 선택되면 선택된 내용에 맞는 body가 보이도록 하는 함수  */
	function shopView(){
		var target = $('.box-shop-header .tab[aria-selected=true]').attr('data-target');
		$('.box-shop-body>div').addClass('display-none');
		$('.box-shop-body>.'+target).removeClass('display-none');
	}

	shopView();
	tabRamdom();

	function tabRamdom(){
		var arr = [];
		$('.box-shop-middle>.box-mall>.link-mall').removeClass('random');
		for( ; arr.length < 4; ){
			var r = getRnadom(1,12);
			if(arr.indexOf(r) >= 0){
				continue;
			}
			arr.push(r)
			if ( r <= 6 ){
				$('.box-shop-middle>.box-mall').eq(0).find('.link-mall').eq(r-1).addClass('random');
			}else {
			$('.box-shop-middle>.box-mall').eq(1).find('.link-mall').eq(r-7).addClass('random');
		}
		}
	}
	
	function getRnadom(min, max){
		return Math.floor(Math.random()*(max-min+1 + min))
	}

	//indexOf() 메서드는 배열에서 지정된 요소를 찾을 수 있는 첫 번째 인덱스를 반환하고 존재하지 않으면 -1을 반환합니다

	$('.box-shop-control>.box-btn>a').click(function(e){
		//a태그의 링크나 싱커 기능을 막는 역할 > 페이지 변동이 없도록함 
		e.preventDefault();
		// var currentObj = $('.box-shop-control>.box-num>.current-num');
		var currentObj = $(this).parents('.box-shop-control').find('.box-num>.current-num');
		var current = currentObj.text();
		current = parseInt(current);
		var change;
		// var max = $('.box-shop-control>.box-num>.max-num').text();
		var max = $(this).parents('.box-shop-control').find('.box-num>.max-num').text();
		max = parseInt(max);
		//이전 버튼인경우 , 해당 버튼은 btn-prev  클래스를 가지고 있음
		if($(this).hasClass('btn-prev')){
			change = current - 1 ;
			if (change == 0)
			change = max;
		}
		//다음 버튼인경우
		else{
			change = current + 1 ;
			if (change == max+1)
			change = 1; 
		}
		currentObj.text(change);

	})

	

})