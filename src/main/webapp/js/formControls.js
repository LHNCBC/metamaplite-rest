// clear textarea element named "inputtext"
function clearInputTextArea() {
    document.getElementById("inputtext").value = "";
}

//
// SemanticType List controls
//
function selectDisorders() {
    // acab,anab,bact,cgab,dsyn,emod,inpo,mobd,neop,patf,sosy
    let disorders = new Set();
    disorders.add('acab');
    disorders.add('anab');
    disorders.add('bact');
    disorders.add('cgab');
    disorders.add('dsyn');
    disorders.add('emod');
    disorders.add('inpo');
    disorders.add('mobd');
    disorders.add('patf');
    disorders.add('sosy');
    
    var elementlist = document.getElementById('iForm').elements;
      
    // using reference to elementlist obtained above
    for (var i=0, len=elementlist.length; i<len; i++) {
        // dbg: console.info(elementlist[i]);
        var nameval = elementlist[i].getAttribute("name");
        if (nameval == "semanticTypeString") {
	    var value = elementlist[i].getAttribute("value");
	    if (disorders.has(value)) {
		elementlist[i].setAttribute("checked","");
	    }
        }
    }    
}

function clearSemanticTypes() {
        var elementlist = document.getElementById('iForm').elements;
      
    // using reference to elementlist obtained above
    for (var i=0, len=elementlist.length; i<len; i++) {
        // dbg: console.info(elementlist[i]);
        var nameval = elementlist[i].getAttribute("name");
        if (nameval == "semanticTypeString") {
	    elementlist[i].removeAttribute("checked");
        }
    }    
}
