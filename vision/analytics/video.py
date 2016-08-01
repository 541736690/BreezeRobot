#!/usr/bin/env python3
import cv2
import numpy as np
from http.server import BaseHTTPRequestHandler, HTTPServer
from io import BytesIO
import time
import detect as detect

class CamHandler(BaseHTTPRequestHandler):
	def do_GET(self):
		if self.path.endswith('.mjpg'):
			self.send_response(200)
			self.send_header('Content-type','multipart/x-mixed-replace; boundary=--jpgboundary')
			self.end_headers()
			while capture.isOpened():
				try:
					ret, frame = capture.read()
					if ret:
						img, cnt = detect.do_detect(frame)
						success, __encoded = cv2.imencode(".jpg", img)
						self.wfile.write(b"--jpgboundary")
						self.send_header('Content-type', b'image/jpeg')
						self.send_header('Content-length', len(__encoded))
						self.end_headers()
						self.wfile.write(__encoded.tobytes())
					else:
						break
				except KeyboardInterrupt:
					break
			return

def main():
	global capture
	capture = cv2.VideoCapture(0)

	try:
		server = HTTPServer(('', 8080), CamHandler)
		server.serve_forever()
	except KeyboardInterrupt:
		capture.release()

if __name__ == '__main__':
	main()
