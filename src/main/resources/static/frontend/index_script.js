function fetchMovies() {
    fetch("/all_movies")
        .then(response => response.json())
        .then(data => {
            var movieList = document.getElementById("movieList");
            movieList.innerHTML = ""; // Clear the movie list

            data.forEach(movie => {
                var movieItem = document.createElement("div");
                movieItem.classList.add("movie-item");

                var image = document.createElement("img");
                image.src = movie.imageUrl;
                movieItem.appendChild(image);

                var details = document.createElement("div");
                details.classList.add("details");

                var title = document.createElement("h3");
                title.textContent = movie.name;
                details.appendChild(title);

                var language = document.createElement("p");
                language.textContent = "Language: " + movie.language;
                details.appendChild(language);

                var duration = document.createElement("p");
                duration.textContent = "Duration: " + movie.durationMinutes + " minutes";
                details.appendChild(duration);


                movieItem.addEventListener("click", function() {
                    window.location.href = "/seat_selection?movieId=" + movie.id + "&movieName=" + encodeURIComponent(movie.name);
                });

                movieItem.appendChild(details);

                movieList.appendChild(movieItem);
            });
        })
        .catch(error => {
            console.error(error);
        });
}

document.addEventListener("DOMContentLoaded", function() {
    fetchMovies();
});

