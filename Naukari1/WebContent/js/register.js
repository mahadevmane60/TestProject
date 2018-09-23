/*function validateform(){  
	
	var name = document.forms["signupform"]["username"].value;
	var email = document.forms["signupform"]["email"].value;
	var dob = document.forms["signupform"]["dob"].value;
	var phno = document.forms["signupform"]["phno"].value;
	var address = document.forms["signupform"]["address"].value;
	var city = document.forms["signupform"]["city"].value;
	var state = document.forms["signupform"]["state"].value;
	var pass = document.forms["signupform"]["userpass"].value; 
	var repeat_pass = document.forms["signupform"]["userpass_repeat"].value;
	var name_letters = /^[a-zA-Z\s,-]*$/;   
	 var address_letters = /^[a-zA-Z0-9\s,-]*$/;
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	var passwordformat=  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
    var letters = /^[A-Za-z]+$/;
   

    if(name=="")
	{
    alert("Name can't blank ");
	return false;
	}
    else if(!name.match(name_letters))
	{
    alert("User name must have alphabet characters only");
	return false;
	}
	else if (email=="" ) {  
	alert("Email can't be blank");  
	return false;  
		}
	else if(!email.match(mailformat) ) {
		alert("Enter an email in format someone@abc.com");
		return false;
	}
	else if (dob > currentDate ) 
	  {
	   alert("Choose correct date");
	   return false;
	  }
	  else if(phno.length != 10) {
        alert("Phone number must be 10 digits.");
        return false;
    }
   
	 else if(!address.match(address_letters))
    {
    alert("Address must have alphanumeric characters only");
    return false;
    }
    else if(pass=="") {
		alert("Password can't be blank");
		return false;
	}
	else if(!pass.match(passwordformat))
		{
		alert("Password must be  8 to 15 characters which contain at least one lowercase letter, one uppercase letter, one numeric digit, and one special character ");
		return false;
		}
	else if (pass != repeat_pass) {
        alert("Passwords do not match.");
        return false;
    }
}

*/

var currentEmpty = "";
var Currerntdata = ""
function CheckIsEmpty(SrtingToCheck,selectedFild){
	if(SrtingToCheck == undefined || SrtingToCheck == null || SrtingToCheck =="" ){
		currentEmpty=selectedFild;
		Currerntdata = SrtingToCheck;
		return false ; 
	}
	else{
		return true;
	}
}
function validateCaseSensitiveEmail(email) 
{ 
 var reg = /^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,4})$/;
 if (reg.test(email)){
 return true; 
}
 else{
 return false;
 } 
} 
function validateUserForm(){
	
	var name = document.forms["signupform"]["username"].value;
	var email = document.forms["signupform"]["email"].value;
	var dob = document.forms["signupform"]["dob"].value;
	var phno = document.forms["signupform"]["phno"].value;
	var address = document.forms["signupform"]["address"].value;
	var city = document.forms["signupform"]["city"].value;
	var state = document.forms["signupform"]["state"].value;
	
	
	var pass = document.forms["signupform"]["userpass"].value; 
	var repeat_pass = document.forms["signupform"]["confirmpass"].value;
//	var name_letters = /^[a-zA-Z\s,-]*$/;   
//	 var address_letters = /^[a-zA-Z0-9\s,-]*$/;
//	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
//	var passwordformat=  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
//    var letters = /^[A-Za-z]+$/;
	
	
	if(CheckIsEmpty(pass,"password") && CheckIsEmpty(repeat_pass,"confirm password") && CheckIsEmpty(name,"User Name") && CheckIsEmpty(email,"Email") && CheckIsEmpty(dob,"Date of birth")  && CheckIsEmpty(phno,"phone number") 
			&& CheckIsEmpty(address,"address") && CheckIsEmpty(city,"city") && CheckIsEmpty(state,"state")){
						
			if(pass !== repeat_pass){				
				alert("password not matching");
				return false;
			}
			else if(!validateCaseSensitiveEmail(email)){
				alert("enter valid email");
				return false;
			}
			
			alert("Registration done successfully");
			return true;
	}
	else{
		alert(currentEmpty+" "+"should not empty");
		
		return false;
		
	}
}