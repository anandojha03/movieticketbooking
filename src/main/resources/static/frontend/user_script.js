document.addEventListener("DOMContentLoaded", function() {
    // Retrieve user details from localStorage
    var user = JSON.parse(localStorage.getItem("user"));

    if (user === null) {
        window.location.href = "/api/login";
    }

    // Display user details on the page
    document.getElementById("id").textContent = user.id;
    document.getElementById("name").textContent = user.name;
    document.getElementById("email").textContent = user.email;

    // Retrieve bookings for the user
    fetch("/bookings/user/" + user.id)
        .then(response => response.json())
        .then(bookings => {
            const bookingTable = document.getElementById("bookingTable");

            // Create table header
            const tableHeader = bookingTable.createTHead();
            const headerRow = tableHeader.insertRow();
            const headers = ["Date", "Movie Name", "Show Time", "Seats Selected", "Total Price", "Cancel Booking"];
            headers.forEach(headerText => {
                const header = document.createElement("th");
                header.textContent = headerText;
                headerRow.appendChild(header);
            });

            const tableBody = bookingTable.createTBody();

            bookings.forEach(booking => {
                const row = tableBody.insertRow();

                const dateTimeCell = row.insertCell();
                dateTimeCell.textContent = booking.dateTime;

                const movieNameCell = row.insertCell();
                movieNameCell.textContent = booking.movieName;

                const slotTimeCell = row.insertCell();
                slotTimeCell.textContent = booking.showTime;

                const selectedSeatsCell = row.insertCell();
                selectedSeatsCell.textContent = booking.selectedSeats;

                const totalPriceCell = row.insertCell();
                totalPriceCell.textContent = booking.totalPrice;

                const deleteButtonCell = row.insertCell();
                const deleteButton = document.createElement("button");
                deleteButton.textContent = "Cancel";
                deleteButton.addEventListener("click", function() {
                    cancelBooking(booking);
                });
                deleteButtonCell.appendChild(deleteButton);
            });
        });
});

function cancelBooking(booking) {

    if (!booking.id) {
            console.error("Invalid booking ID:", booking.id);
            return;
    }
    fetch("/bookings/" + booking.id, {
        method: "DELETE"
    })
        .then(response => {
            if (response.ok) {
                // Booking successfully canceled
                console.log("Booking canceled:", booking);
                // Reload the page to show the updated bookings
                location.reload();
            } else {
                // Failed to cancel booking
                console.error("Failed to cancel booking:", booking);
                // Handle the error or display a message to the user
            }
        })
        .catch(error => {
            // Error occurred during the request
            console.error("Error canceling booking:", error);
            // Handle the error or display a message to the user
        });
}


function logout() {
    // Remove user from localStorage
    localStorage.removeItem("user");

    // Redirect to the login page or perform any other action
    window.location.href = "/api/login";
}

function home() {
    // Redirect to the login page or perform any other action
    window.location.href = "/index";
}
