$body = $("body");

function evalTask(xhttp ,taskId){

    $body.addClass("waitModal");


    var taskId_i = document.getElementById("taskid_i");
    var t_result_i = document.getElementById("taskresult_i");
    
    taskId_i.value=taskId;
    var expression = xhttp.responseText;
    window.onbeforeunload = function() {
        return "Are you realy want to exit? Think of the poor people who need your CPU!";
    }
    setTimeout(function () {
        try {
            var result = eval('(' + expression + ')');
        } catch (e) {
            if (e instanceof SyntaxError) {
                $body.removeClass("waitModal");
                window.onbeforeunload = null;
            }
        }
        t_result_i.value = result;
        document.getElementById("taskresultform").submit();
        $body.removeClass("waitModal");
        alert("your result:"+ result);

        window.onbeforeunload = null;
    }, 5000);

}