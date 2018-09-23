
function validation() {
    var name = $("#fname").val();
    var city = $("#city").val();
    var phnumber = $("#phnumber1").val();

    var subject = $("#subject").val();

    if (name.length < 1) {
        alert("name is required");
        return false;
    }
    if (phnumber.length < 10) {
        alert("Enter valid Phone Number");
        return false;
    }
    if (city.length < 2) {
        alert("City is required");
        return false;
    }
    if (subject.length < 2) {
        alert("Subject is required");
        return false;
    }
   
    $.post("ContactUs",
            {
                name: name,
                city: city,
                phnumber: phnumber,
                subject: subject
            },
            function (data1, status) {
                
                if(data1==="success"){
                    alert(" Thanks! we will get back to you soon. ");
                    return true;
                }
                else {
                    alert("Sorry! Unable to submit. Please try later. ");
                    return false;
                }
            });

}



