function loadDoc(url, cfunc, taskid) {
    var xhttp;
    showWaitModal();
    xhttp=new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            cfunc(xhttp,taskid);
        }
    };
    xhttp.open("GET", url, true);
    xhttp.send();
}


$(document).on({
    ajaxStart:showWaitModal(),
    ajaxStop: hideWaitModal()
});

function showWaitModal(){
    var wmodal = document.getElementById('pleaseWaitDialog');
    wmodal.style.display = "block";
}

function hideWaitModal(){
    var wmodal = document.getElementById('pleaseWaitDialog');
    wmodal.style.display = "none";
}

function myFunction(xhttp , taskid) {

    var modal = document.getElementById('myModal');
    modal.style.display = "block";

    hideWaitModal();
    var text = xhttp.responseText;
    document.getElementById("codedis").innerHTML = text;

    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

    // When the user clicks on <span> (x), close the modal
    span.onclick = function() {
        modal.style.display = "none";
    }

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }

}


