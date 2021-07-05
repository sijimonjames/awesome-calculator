const express = require('express');
const app = express();
const path = require('path');
const router = express.Router();
const fetch = require('node-fetch');
const port = 8080;
const fs = require('fs');

router.get('/', (req, res) => {
  res.sendFile(path.join(__dirname + '/assets/index.html'));
  //__dirname : It will resolve to your project folder.
});

router.get('/factorial', async (req, res) => {
  let body = {
    number: req.query.number,
  };
  const response = await fetch('http://backend:8080/factorial', {
    method: 'POST',
    body: JSON.stringify(body),
    headers: { 'Content-Type': 'application/json' },
  });
  const data = await response.json();

  res.send(JSON.stringify(data));
});

router.get('/newAd', async (req, res) => {
  const response = await fetch('http://adserver:8080/ads');
  const data = await response.json();

  res.send(JSON.stringify(data[Math.floor(Math.random() * data.length)]));
});

app.use('/', router);
app.listen(process.env.port || port, () => {
  console.log(
    `Example app listening at http://localhost:${process.env.port || port}`
  );
});
