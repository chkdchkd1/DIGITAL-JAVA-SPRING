$(function(){



    var newsRollingNum = newsRolling();

    $('.box-rolling-newlist').hover(function(){
        clearInterval(newsRollingNum);
    },function(){
        newsRollingNum = newsRolling();
    })


    var cardRollingNum = cardRolling();
    
    $('.box-right2').hover(function(){
        //마우스가 요소 안으로 들어갈 때 
            clearInterval(cardRollingNum);
        },function(){
            //마우스가 요소 밖으로 나갈 때 
            cardRollingNum = cardRolling();
            //등록을 다시하는 것 
        })
        // 동작이 다르기 때문에 function을 두번쓰는 것 
    



    function newsRolling(){
        return setInterval(function(){
            $('.box-rolling-news').first().animate({'margin-top':'-24px'},700,function(){
                $(this).detach().appendTo('.box-rolling-newlist').css('margin-top','0px').removeAttr('style');
            });
        },2000)
    }

    function cardRolling(){
        return setInterval(function(){
            $('.box-card-nav>.card').first().animate({'margin-left':'-281px'},1000,function(){
                $(this).detach().appendTo('.box-card-nav').removeAttr('style');
            });
        }, 1500)
    }
})


