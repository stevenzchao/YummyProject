/**
 * 
 */
document.addEventListener("DOMContentLoaded",function(){
    switchHWK = true;//控制四個function的開關，開始設true(over跟out都設true，因為一開始進入就要執行)
    navlist = document.getElementsByClassName("nav");
    // console.log(imglist);
    navlen = navlist.length;            
    for (let i =0;i<navlen;i++){
        navlist[i].addEventListener("mouseover",showhw);
    }
});


function showhw(){
    let navpoint = this.id.substr(1);
    if(navpoint==1){
        document.getElementById("side1").style.display="block";
        document.getElementById("side2").style.display="none";
        document.getElementById("side3").style.display="none";
        document.getElementById("side4").style.display="none";
    }
    else if (navpoint==2){
        document.getElementById("side1").style.display="none";
        document.getElementById("side2").style.display="block";
        document.getElementById("side3").style.display="none";
        document.getElementById("side4").style.display="none";
    }
    else if (navpoint==3){
        document.getElementById("side1").style.display="none";
        document.getElementById("side2").style.display="none";
        document.getElementById("side3").style.display="block";
        document.getElementById("side4").style.display="none";
    }
    else if (navpoint==4){
       	document.getElementById("side1").style.display="none";
        document.getElementById("side2").style.display="none";
        document.getElementById("side3").style.display="none";
        document.getElementById("side4").style.display="block";
    }
    // containlist[this.id.substr(2)].style.display="unset";
    
}