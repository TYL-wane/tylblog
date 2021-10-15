$(function(){

     //找到 下拉列表的标签  header_top_ul
     $(".header_nesting").css("display","none");
     //找到所有的li标签
     $(".heder_ul_li").mouseover(function(){
         $(this).find(".header_nesting").css("display","block");
         $(this).find("label").text("∧");
     })
     $(".heder_ul_li").mouseout(function(){
         $(this).find(".header_nesting").css("display","none");
         $(this).find("label").text("∨");
     })
 
})