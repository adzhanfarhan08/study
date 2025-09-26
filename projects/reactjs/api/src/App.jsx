import { useEffect, useState } from "react"
import { getMovielist, searchMovie } from "./api"
const App = () => {
  const [popularMovies, setPopularMovies] = useState([])
  useEffect(() => {
    getMovielist().then((result) => {
      setPopularMovies(result)
    })
  }, [])

  const PopularMovieList = () => {
    return (
      <div className="flex justify-center items-center">
        <div className="container mx-auto px-4 py-8" >
          <div className="grid grid-cols-5 gap-1">
            {popularMovies.map((movie, i) => (
              <div className="bg-gray-500 p-1">
                <div className="text-center text-[#F6F5F5]">{movie.title}
                  <div className="flex justify-center items-center" key={i}>
                    <img className="rounded-xl w-32 m-5" src={`${import.meta.env.VITE_BASEIMGURL}/${movie.poster_path}`} />
                  </div>
                  <div id="Movie-date">{movie.release_date}</div>
                  <div id="Movie-rating">{movie.vote_average}</div>
                </div>
              </div>
            ))}
          </div>
        </div>
      </div>
    )
  }

  const search = async (q) => {
    if (q.length > 3) {
      const query = await searchMovie(q)
      setPopularMovies(query.results)
    }
  }

  return (
    <div className="">
      <div className="flex justify-center m-5 font-extrabold text-[25px]">
        <h1 className="text-[#F6F5F5]">Database Movie</h1>
      </div>
      <div className="flex justify-center">
        <input
          id="Movie-search"
          placeholder="Cari Film..."
          className="font-semibold m-5 border-2 border-black h-10 w-[300px]"
          onChange={({ target }) => search(target.value)} />
      </div>
      <div id="Movie-container">
        <PopularMovieList />
      </div>
    </div>
  )
}

export default App
