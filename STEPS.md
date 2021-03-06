# STEPS

Run this teaching app by running `lein ring server` at the project root. This should open up your browser at `http://localhost:3000`.

## 01-init
* Familiarize yourself with the organization of the clojure web app project
* 01-init files are identical to files at the root
* You can run different steps by changing the ring handler definition in project.clj and restarting the server
    * i.e. To run this step, in project.clj `:ring {:handler giphycb.01-init.web/handler}` then run `lein ring server`.

## 02-hiccup
* Add dependencies for hiccup, cheshire, and clj-http
* In web.clj add a `layout` function which renders hiccup content within a common hiccup layout
* Modify `main-page` function in web.clj to render the result of `rand-hello` in the hiccup layout
* See results at `http://localhost:3000`

## 03-call-api
* In core.clj implement `get-api` function to call giphy search api with search term
* NOTE: don't forget the giphy api key!
* Write a function in web.clj that calls `get-api` with a hard-coded search-term and returns the results as a string within a hiccup `:div`, i.e. `[:div results]`.
* Add a new route in web.clj to show search results (`/results`)
* Call your new function from your new route and browse to new route at `http:localhost:3000/results`

## 04-search-form
* Make a form in hiccup that submits a new search term to the results route
* Pass the search term to the api call, replacing the hard-coded search term, returning actual results
* Render results as text like before

## 05-render-gifs
* Parse json API response with cheshire, creating a list of maps in clojure
* Iterate across the list of results, creating a hiccup list of animated gifs
* Replace the text results with the hiccup list of animated gifs as the response from `/results`
* Check it out in your browser

## 06-have-fun
* Limit or filter the results from the giphy API
* Add better navigation
* Call other giphy APIs
* Render a list of thumbnails at `/results` and link to a landing page for each thumbnail for showing the full-sized animated gif
* Using the random API, create a page that shows a random gif and a "shuffle" button that displays a new random gif every time you click it
* Add sorting to your search results
* Mash up the giphy API with other APIs. Ask an instructor for ideas.
