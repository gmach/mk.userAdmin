$(function() {
    function rest(event) {
        var postData = $(this).serializeArray();
        var formURL = "http://localhost:8080/api/customer";
        var type = event.data.type;
        if (type == 'DELETE') {
            formURL += '?id=' + postData[0].value;
        }
        $.ajax({
            type: type,
            url: formURL,
            data: postData,
            success: function(data) {
                $("#results").html(JSON.stringify(data));
            } ,
            error: function(jqXHR, textStatus, errorThrown)
            {
                console.log("ERROR!");
            }
        });
        event.preventDefault();
    }

    $("#createform").submit({"type": "POST"}, rest);
    $("#readform").submit({"type": "GET"}, rest);
    $("#updateform").submit({"type": "PUT"}, rest);
    $("#deleteform").submit({"type": "DELETE"}, rest);
}());