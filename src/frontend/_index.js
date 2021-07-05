const http = require('http'); // Import Node.js core module
const fs = require('fs');
const PORT = 8080;

let server = http.createServer(function (req, res) {
  //create web server
  if (req.url == '/') {
    // set response header
    res.writeHead(200, { 'Content-Type': 'text/html' });
    body = fs.readFileSync('index.html');
    res.write(body);
    res.end();
  } else {
    res.writeHead(404, { 'Content-Type': 'text/html' });
    res.write(
      '<html><body><h1>Ups ...</h1><h2>I think you got lost</h2></body></html>'
    );
    res.end();
  }
});

server.listen(PORT);

console.log(`Webserver running on port ${PORT}`);
