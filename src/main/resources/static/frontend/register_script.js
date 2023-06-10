window.onload = function() {
    var registrationForm = document.getElementById("registrationForm");
    registrationForm.addEventListener("submit", function(event) {
        event.preventDefault(); // Prevent form submission

        var name = document.getElementById("name").value;
        var email = document.getElementById("email").value;
        var password = document.getElementById("password").value;
        var phoneNumber = document.getElementById("phoneNumber").value;
        var role = document.getElementById("role").value;

        // Validate form fields (add your own validation logic)
        var errors = [];
        if (name.trim() === "") {
            errors.push("Name is required");
        }
        if (email.trim() === "") {
            errors.push("Email is required");
        }
        if (password.trim() === "") {
            errors.push("Password is required");
        }
        if (phoneNumber.trim() === "") {
            errors.push("Phone Number is required");
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
                name: name,
                email: email,
                password: password,
                phoneNumber: phoneNumber,
                role: role
            };

            localStorage.setItem('user' , user);
            // Use AJAX or fetch to send the data to the server
            // Example using fetch:
            fetch("/api/register", {
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
                    throw new Error("Error: " + response.status);
                }
            })
            .then(function(data) {
                console.log("Registration successful:", data);
                // Redirect to a success page or perform any other action
            })
            .catch(function(error) {
                console.error("Registration failed:", error);
                // Display an error message or perform any other action
            });
        }
    });
};
