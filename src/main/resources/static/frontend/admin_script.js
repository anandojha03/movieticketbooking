window.onload = function() {
    var loginForm = document.getElementById("loginForm");
    loginForm.addEventListener("submit", function(event) {
        event.preventDefault(); // Prevent form submission

        var email = document.getElementById("email").value;
        var password = document.getElementById("password").value;

        if(email === "admin@movieticketbooking.com" && password === "MyAdmin@123"){
            var admin = {
                email: email,
                password: password
            };
            var adminString = JSON.stringify(admin);
            localStorage.setItem("admin" , adminString);

            window.location.href = "/movie";
        }else{
            console.log("Wrong Credentials");
            window.alert("Wrong Credentials");
        }

    });
};
