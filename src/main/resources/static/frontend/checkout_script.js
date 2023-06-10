const queryString = window.location.search;

    // Remove the leading '?' character from the query string
    const queryStringWithoutLeadingChar = queryString.substring(1);

    // Parse the query string as JSON
    const bookingDataURL = JSON.parse('{"' + decodeURI(queryStringWithoutLeadingChar).replace(/"/g, '\\"').replace(/&/g, '","').replace(/=/g, '":"') + '"}');


// Store the bookingData in local storage
localStorage.setItem('bookingData', JSON.stringify(bookingDataURL));


// Retrieve the booking data from local storage
const bookingData = JSON.parse(localStorage.getItem('bookingData'));


console.log(bookingData);

if (bookingData) {
  // Get the checkout elements
  const totalPriceElement = document.getElementById('total-price');
  const selectedSeatsElement = document.getElementById('selected-seats');
  const movieIdElement = document.getElementById('movie-id');
  const movieNameElement = document.getElementById('movie-name');
  const dateElement = document.getElementById('date');
  const showTimeElement = document.getElementById('show-time');

  // Display the booking details on the page
  totalPriceElement.textContent = bookingData.totalPrice;
  selectedSeatsElement.textContent = bookingData.selectedSeats;
  movieIdElement.textContent = bookingData.movieId;
  movieNameElement.textContent = bookingData.movieName;
  dateElement.textContent = bookingData.dateTime;
  showTimeElement.textContent = bookingData.showTime;

  // Clear the booking data from local storage
  localStorage.removeItem('bookingData');
} else {
  // Handle the case when no booking data is found
  console.log('No booking data found.');
}

function redirectToLoginPage() {
        window.location.href = "/index";
}