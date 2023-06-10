window.onload = function() {
    var loginForm = document.getElementById("loginForm");
    loginForm.addEventListener("submit", function(event) {
        event.preventDefault(); // Prevent form submission

        var email = document.getElementById("email").value;
        var password = document.getElementById("password").value;

        // Validate form fields (add your own validation logic)
        var errors = [];
        if (email.trim() === "") {
            errors.push("Email is required");
        }
        if (password.trim() === "") {
            errors.push("Password is required");
        }

        if (errors.length > 0) {
            var errorContainer = document.getElementById("errorContainer");
            errorContainer.innerHTML = ""; // Clear previous errors

            errors.forEach(function(error) {
                var errorElement = document.createElement("p");
                errorElement.textContent = error;
                errorElement.className = "error";
                errorContainer.appendChild(errorElement);
            });
        } else {
            // Form is valid, submit the data to the server
            var user = {
                email: email,
                password: password
            };

            // Use AJAX or fetch to send the data to the server
            // Example using fetch:
            fetch("/api/login", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(user)
            })
            .then(function(response) {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error("Error: " + "UserName and password not matched");
                }
            })
            .then(function(data) {
                if (data !== null) {
                            // Successful login
                            console.log("Login successful:", data);
                            var userString = JSON.stringify(data);
                            localStorage.setItem('user', userString);
                            // Redirect to another page or perform any other action
                            window.location.href = "/index";
                        } else {
                            // Failed login
                            console.log("Login failed: Invalid credentials");
                        }
            })
            .catch(function(error) {
                console.error("Login failed:", error);
                // Display an error message or perform any other action
            });
        }
    });
};

function register(){
    window.location.href = "/api/register";
}
