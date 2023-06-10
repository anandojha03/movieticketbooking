document.addEventListener('DOMContentLoaded', function() {
    const container = document.getElementById('seats-container');
    const selectedSeatsElement = document.getElementById('selected-seats');
    const totalPriceElement = document.getElementById('total-price');
    const bookButton = document.getElementById('book-btn');
    const dateSelect = document.getElementById('date-select');
    var dateValue = dateSelect.value;
    const showTime = document.getElementById('show-time-select');
    var showTimeValue = showTime.value;
    var movieData = {};
    var bookingData = {};
    const totalSeats = 120; // Total number of seats
    const userId = JSON.parse(localStorage.getItem("user")).id;
    console.log(userId);

    // Function to create seats
    function createSeats(bookedSeats) {
        for (let i = 1; i <= totalSeats; i++) {
            const seat = document.createElement('div');
            seat.className = 'seat';
            seat.innerText = i;

            if (bookedSeats.includes(i)) {
                seat.classList.add('booked');
                seat.removeEventListener('click', selectSeat);
            } else {
                seat.addEventListener('click', selectSeat);
            }

            container.appendChild(seat);
        }
    }

    // Function to handle seat selection
    function selectSeat(event) {
        const seat = event.target;

        if (seat.classList.contains('selected')) {
            seat.classList.remove('selected');
        } else {
            seat.classList.add('selected');
        }

        updateBookingDetails();
    }

    // Function to update booking details
    function updateBookingDetails() {
        const selectedSeats = container.querySelectorAll('.seat.selected');
        const totalPrice = selectedSeats.length * 10; // Assuming $10 per seat

        selectedSeatsElement.innerText = selectedSeats.length;
        totalPriceElement.innerText = totalPrice;

        const selectedSeatNumbers = Array.from(selectedSeats).map(seat => seat.innerText);

        bookingData = {
            totalPrice: totalPrice,
            selectedSeats: selectedSeatNumbers,
            movieId: movieData.movieId,
            movieName: movieData.movieName,
            dateTime : dateValue,
            showTime : showTimeValue,
            userId : userId
        };

    }

    // Function to populate date selection options
    function populateDateOptions() {
        const dateSelect = document.getElementById('date-select');
        const today = new Date();
        const maxDate = new Date();
        today.setDate(today.getDate() + 1);
        maxDate.setDate(today.getDate() + 10); // Add 10 days to the current date

        while (today < maxDate) {
            const option = document.createElement('option');
            option.value = today.toISOString().split('T')[0];
            option.textContent = today.toDateString();
            dateSelect.appendChild(option);

            today.setDate(today.getDate() + 1); // Increment the date by 1 day
        }
    }


    dateSelect.addEventListener('change', function() {
      dateValue = dateSelect.value;
      updateBookingDetails();
    });

    showTime.addEventListener('change', function() {
      showTimeValue = showTime.value;
      updateBookingDetails();
    });




    // Event listener for book button click
    bookButton.addEventListener('click', function(event) {
            event.preventDefault();

//            console.log(bookingData);

            // Send the bookingData to the /checkout endpoint
            fetch('/checkout', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(bookingData)

            })
            .then(response => {
                // Handle the response as needed
                if (response.ok) {
                    // Redirect to the checkout.html page
                    console.log(bookingData);
                    // Construct the query string with JSON data as query parameters
                    const queryString = new URLSearchParams(bookingData).toString();

                    // Redirect to the checkout.html page with the query string
                    window.location.href = '/frontend/checkout.html?' + queryString;

                    console.log(bookingData);
                } else {
                    // Handle the error case
                    console.log('Error occurred while processing the booking.');
                }
            })
            .catch(error => {
                // Handle any errors that occurred during the request
                console.log('An error occurred:', error);
            });
        });

    function getMovieData(){
        const queryString = window.location.search;
        const urlParams = new URLSearchParams(queryString);
        const movieId = urlParams.get('movieId');
        const movieName = urlParams.get('movieName');

        // Pass the movieId and movieName to the JavaScript code
        movieData = {
            movieId: movieId,
            movieName: movieName
        };

    }

    getMovieData();
    createSeats([]);
    populateDateOptions();



});
