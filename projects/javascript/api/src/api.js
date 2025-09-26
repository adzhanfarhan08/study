import axios from "axios";

const apiKey = import.meta.env.VITE_API_KEY;
const baseUrl = import.meta.env.VITE_BASEURL;

export const getMovielist = async () => {
  const movie = await axios.get(
    `${baseUrl}/movie/popular?page=1&api_key=${apiKey}`
  );
  //   console.log({ movieList: movie });
  return movie.data.results;
};

export const searchMovie = async (q) => {
  const search = await axios.get(
    `${baseUrl}/search/movie?query=${q}&page=1&api_key=${apiKey}`
  );
  return search.data;
};
