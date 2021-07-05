package main

import (
    "encoding/json"
    "fmt"
    "log"
    "net/http"
    "io/ioutil"
)

// Ads ...
type Ads []string

func homePage(w http.ResponseWriter, r *http.Request) {
  fmt.Println("Endpoint Hit: root")
}

func getAds(w http.ResponseWriter, r *http.Request) {

  data, err := ioutil.ReadFile("./ads.json")     // the file is inside the local directory
  if err != nil {
      fmt.Println("Err")
  }

  var ads Ads
  err = json.Unmarshal(data, &ads)
  if err != nil {
      fmt.Println("error:", err)
  }

  fmt.Println("Endpoint Hit: ads")
  json.NewEncoder(w).Encode(ads)
}

func handleRequests() {
    http.HandleFunc("/", homePage  )
    http.HandleFunc("/ads", getAds)
    log.Fatal(http.ListenAndServe(":8080", nil))
}

func main() {
    handleRequests()
}
