var MjpegProxy = require('mjpeg-proxy').MjpegProxy;
var express = require('express');
var app = express();

app.get('/index.mjpg', new MjpegProxy('http://localhost:8080/camera.mjpg').proxyRequest);
app.listen(8081);
