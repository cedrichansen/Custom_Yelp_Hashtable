# csc365HW01
Custom Hashtable for Yelp Business Data. Uses similarity metrics to compare businesses based on proximity and similar categories


This project parses data from the business.json file from https://www.yelp.com/dataset, which is not included in this
repo because the file is too big for GitHub.

This data is stored using a custom hashtable. Based on each businesses lattitude/longitude, along with their categories 
(Ex. Restaurants, Cosmetics, Barbershops, etc..), the program can find both the most similar element to the one the user 
searches, or can find a list of several similar businesses. For example, if a user enters "Subway", which in this dataset is
in Charlotte, NC, the program will find the best match to Subway, which will be a sandwhich shop in close proximity to that 
Subway.
