 function show()
  {
	var xmlhttp;
	if (window.XMLHttpRequest)
	{
		//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xmlhttp=new XMLHttpRequest();
	}
	else
	{
		// IE6, IE5 浏览器执行代码
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
            var message = JSON.parse(xmlhttp.responseText);
			if(message.status=="1"){
					var message = JSON.parse(xmlhttp.responseText);
					var ying = document.getElementById('ying');
					for (var i = 0; i < message.data.length; i++) {
						var a = document.createElement("a");
						a.setAttribute("href","performance.html?movieId="+message.data[i].id);
						var li = document.createElement("li");
						var div = document.createElement("div");
						var p1 = document.createElement("p");
						var p2 = document.createElement("p");
						var img = document.createElement("img");
						img.setAttribute("src",message.data[i].img);
						p1.innerHTML=message.data[i].nm;
						p2.innerHTML="购买";
						p1.className="movieName";
						p2.className="buy";
						div.appendChild(p1);
						div.appendChild(p2);
						li.appendChild(img);
						li.appendChild(div);
						a.appendChild(li);
						ying.appendChild(a);
					}
			}
		}
	}
	xmlhttp.open("GET","/TTMS/movies/selected",true);
	xmlhttp.send();
 }