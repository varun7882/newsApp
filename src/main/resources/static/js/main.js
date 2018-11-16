console.log("Js loaded");
var offset=0;
var newsArticles=[];
function searchArticles()
{
    var g = $("#searchbox").val().toLowerCase();
    //console.log(g);
    $(".articleLink .newsArticleDiv .titleArticle").each( function(){
        var s = $(this).text().toLowerCase();
   //     console.log(s);
        if (s.indexOf(g)!=-1) {
            $(this).parent().parent().show();
        }
        else {
            $(this).parent().parent().hide();
        }
    });
}
function clearSearch(){    
	$("#searchbox").val("");
	searchArticles();
}
function addArticles(data)
{
	var divMain=document.getElementById("main");
	for(var i=0;i<data.length;i++)
	{
		newsArticles.push(data[i]);
		var div1 = document.createElement('div');
		div1.className='row newsArticleDiv';
		var div2 = document.createElement('div');
		div2.className='col-md-9 titleArticle';
		div2.innerHTML=data[i].articleTitle;
		var div3 = document.createElement('div');
		div3.className='publisherName';
		div3.innerHTML="-"+data[i].publisherName;
		var aTag = document.createElement('a');
		aTag.setAttribute('href',data[i].articleUrl);
		aTag.setAttribute('class','articleLink');
		aTag.appendChild(div1);
		div1.appendChild(div2);
		div1.appendChild(div3);
		divMain.appendChild(aTag);
	}
}
function loadAllNewsArticle()
{
	$.get("http://localhost:8080/article/all",function(data, status){
        addArticles(data);
    });
}
function loadNewsArticles()
{
	$.get("http://localhost:8080/article/offset/"+offset,function(data, status){
        addArticles(data);
    });
	offset++;
}
function sortByPublisher()
{
	var $divs = $(".articleLink");
	    var orderedBypublisher = $divs.sort(function (a, b) {
	        var x= $(a).find(".publisherName").text();
	        var y=$(b).find(".publisherName").text();
	        return x>y;
	    });
	    $("#main").html(orderedBypublisher);

}
function sortByTitle()
{
	var $divs = $(".articleLink");
    var orderedBytitle = $divs.sort(function (a, b) {
        var x= $(a).find(".titleArticle").text();
        var y=$(b).find(".titleArticle").text();
        return x>y;
    });
    $("#main").html(orderedBytitle);
}
$(window).scroll(function() {
    if($(window).scrollTop() == $(document).height() - $(window).height()) {
    	loadNewsArticles();
    	if($("#searchbox").val().toLowerCase()!="")
    		{
    			clearSearch();
    		}
    }
});
