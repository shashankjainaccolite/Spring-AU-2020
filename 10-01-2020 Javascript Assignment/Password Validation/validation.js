function validation(){

    var user = document.getElementById('user').value;
    var pass = document.getElementById('pass').value;
    var conpass = document.getElementById('conpass').value;

    var regex1 = /[a-z]/;
    var regex2 = /[A-Z]/;
    var regex3 = /[0-9]/;
    var regex4 = /^abc/;
    var regex5 = /[*@$]/;

    if(user == "" || pass == "" || conpass == ""){
        if(user == ""){
            document.getElementById('username').innerHTML = " * Username can't be empty";
        }

        if(pass == ""){
            document.getElementById('password').innerHTML = " * Password can't be empty";
        }

        if(conpass == ""){
            document.getElementById('confirmpass').innerHTML = " * Confirm Password can't be empty";
        }

        return false;
        
    }

    var passLowerCase = pass.toLowerCase();

    if(pass.length < 8){
        document.getElementById('password').innerHTML = " * Password should be minimum of length 8";
        return false;
    } else if(!(/^[abc]/).test(passLowerCase)){
        document.getElementById('password').innerHTML = " * Password should start with abc";
        return false;
    } else if(!regex2.test(pass)){
        document.getElementById('password').innerHTML = " * Password should contain atleast 1 uppercase letter";
        return false;
    } else if(!regex3.test(pass)){
        document.getElementById('password').innerHTML = " * Password should contain atleast 1 digit";
        return false;
    } else if(!regex5.test(pass)){
        document.getElementById('password').innerHTML = " * Password should contain atleast 1 symbol from *, $ or @";
        return false;
    }
    
    if(pass != conpass){
        document.getElementById('password').innerHTML = " * Password and Confirm Password field doesn't match";
        document.getElementById('confirmpass').innerHTML = " * Password and Confirm Password field doesn't match";
        return false;
    }
    
    alert('Username : ' + user + '\n' + 'Password : ' +pass);

    document.getElementById('login').reset();

}