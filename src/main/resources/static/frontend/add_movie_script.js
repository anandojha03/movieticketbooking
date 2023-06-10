document.getElementById("movieForm").addEventListener("submit", function(event) {
    event.preventDefault();

    // Get form values
    var name = document.getElementById("name").value;
    var language = document.getElementById("language").value;
    var duration = document.getElementById("durationMinutes").value;
    var imageUrl = document.getElementById("imageUrl").value;

        // Create a URL-encoded query string
        var formData = new URLSearchParams();
        formData.append("name", name);
        formData.append("language", language);
        formData.append("durationMinutes", duration);
        formData.append("imageUrl", imageUrl);

        // Perform an AJAX request to add the doctor
        fetch("/movie", {
            method: "POST",
            body: formData
        })
        .then(response => response.text())
        .then(data => {
            // Handle the response
            window.alert("Movie Created Successfully");
            console.log(data);
            // Redirect to the doctor list page or perform any other action
        })
        .catch(error => {
            // Handle the error
            window.alert("Error creating Movie, please check logs");
            console.error(error);
        });
});
function logout() {
    // Remove user from localStorage
    localStorage.removeItem("admin");

    // Redirect to the login page or perform any other action
    window.location.href = "/admin";
}