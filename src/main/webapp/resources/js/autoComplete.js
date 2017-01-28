
$(document).ready(function() {
    $(function() {
        $("#employee").autocomplete({
            source: function(request, response) {
                $.ajax({
                    url: "./getEmployees",
                    type: "POST",
                    data: { term: request.term },

                    dataType: "json",

                    success : function(data) {
						response(data);
					}
               });              
            }    
        });
    });
});