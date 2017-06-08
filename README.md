# giphycb

A Clojure web app to explore the Giphy [API](https://github.com/Giphy/GiphyAPI) and more.

This was made for the ClojureBridge NYC Day 2 Workshop held on 6/4/17. The goal of this project is to introduce programmers with some experience in Clojure to web development in Clojure.

It is designed to be simple, fun, and easily extensible.

The program builds up a simple app that uses the giphy API to search for and display gifs. Each step is enumerated in the file STEPS.md and those steps are represented as separate namespaces in the app. Different steps can be run by setting the ring handler in project.clj (i.e. `:ring {:handler giphycb.web/handler}`), and restarting the app with `lein ring server`


## Usage

Run with:
    lein ring server 

Then visit [localhost:3000](http://localhost:3000) in your browser.

## License

Copyright © 2017 ClojureBridge 

Distributed under the Creative Commons Attribution 3.0 Unported [License](http://creativecommons.org/licenses/by/3.0/)
