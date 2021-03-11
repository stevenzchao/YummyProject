/**
 * 
 */
document.addEventListener("DOMContentLoaded", function () {
            document.getElementById("btn").addEventListener("click", CreateElement); 
        });
        
        function CreateElement(){
            var display_area = document.getElementById("display_area");
            var p = document.createElement("span");
            var icon = document.createElement("div");
            p.className="span_content";
            var content_val = document.getElementById("content").value;
            if (content_val!=""){
                let txtP = document.createTextNode(content_val);
                p.appendChild(txtP);
                icon.className="trashcan";
                icon.innerHTML="<i class='fas fa-trash-alt'></i>";
                let trashalert = document.createElement("span");
                trashalert.className="tooltiptext";
                let trashtxt = document.createTextNode("刪除");
                trashalert.appendChild(trashtxt);
                icon.appendChild(trashalert);
                p.appendChild(icon);
                display_area.appendChild(p);
            
            }
            else {
                document.getElementById("alert1").innerHTML=" <font color=red>please enter";
                content.style.border="1px solid red";
            }

            icon.onclick = function(){
                p.parentNode.removeChild(p);
            };
};//createelement