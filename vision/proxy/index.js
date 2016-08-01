var MjpegProxy = require('mjpeg-proxy').MjpegProxy;
var express = require('express');
var app = express();

app.use('/', express.static('../webdashboard'));
app.get('/stream.mjpg', new MjpegProxy('http://localhost:8080/camera.mjpg').proxyRequest);
app.listen(8081, "0.0.0.0");
