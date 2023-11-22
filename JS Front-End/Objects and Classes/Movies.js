function manageMovies(input) {
    let movies = [];

    function findMovie(movieName) {
        return movies.find(movie => movie.name == movieName);
    }

    function addMovie(movieName) {
        if (!findMovie(movieName)) {
            movies.push({ name: movieName });
        }
    }

    function addDirector(movieName, director) {
        let movie = findMovie(movieName);
        if (movie) {
            movie.director = director;
        }
    }

    function addDate(movieName, date) {
        let movie = findMovie(movieName);
        if (movie) {
            movie.date = date;
        }
    }

    function printMoviesWithInfo() {
        // Filter out movies that do not have all the required information (name, director, date)
        let moviesWithInfo = movies
            .filter(movie => movie.name && movie.director && movie.date)
            .forEach(m => console.log(JSON.stringify(m)));    
    }

    input.forEach(command => {
        let tokens = command.split(' ');

        if (tokens[0] === 'addMovie') {
            // Extract the movie name by combining all tokens after 'addMovie'
            addMovie(tokens.slice(1).join(' '));
        } else {
            let movieName;
            let directorIndex = tokens.indexOf('directedBy');
            let dateIndex = tokens.indexOf('onDate');

            if (directorIndex !== -1 && (dateIndex === -1 || directorIndex < dateIndex)) {
                // 'directedBy' is present and comes before 'onDate'
                movieName = tokens.slice(0, directorIndex).join(' ');
            } else if (dateIndex !== -1) {
                // 'onDate' is present
                movieName = tokens.slice(0, dateIndex).join(' ');
            }

            if (findMovie(movieName)) {
                if (directorIndex !== -1) {
                    addDirector(movieName, tokens.slice(directorIndex + 1).join(' '));
                } else if (dateIndex !== -1) {
                    addDate(movieName, tokens.slice(dateIndex + 1).join(' '));
                }
            }
        }
    });

    printMoviesWithInfo();
}

manageMovies(
    [
    'addMovie Fast and Furious',
    'addMovie Godfather',
    'Inception directedBy Christopher Nolan',
    'Godfather directedBy Francis Ford Coppola',
    'Godfather onDate 29.07.2018',
    'Fast and Furious onDate 30.07.2018',
    'Batman onDate 01.08.2018',
    'Fast and Furious directedBy Rob Cohen'
    ]      
);

manageMovies(
    [
    'addMovie The Avengers',
    'addMovie Superman',
    'The Avengers directedBy Anthony Russo',
    'The Avengers onDate 30.07.2010',
    'Captain America onDate 30.07.2010',
    'Captain America directedBy Joe Russo'
    ]   
);