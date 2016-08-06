#!/usr/bin/env python3

import cv2
import numpy as np
from http.server import BaseHTTPRequestHandler, HTTPServer
from io import BytesIO
import time
from utils import camserver
from detect import detect
import config

def do_capture(self):
    if capture.isOpened():
        ret, frame = capture.read()
		if ret:
			img, cnt = detect.do_detect(frame)
			return img
		else:
			return None
	else:
		return None

def main():
	global capture
	capture = cv2.VideoCapture(0)
	capture.set(cv2.CAP_PROP_FRAME_WIDTH, 1280)
	capture.set(cv2.CAP_PROP_FRAME_HEIGHT, 720)
	try:
		camserver.serve(config.server, do_capture)
	except KeyboardInterrupt:
		capture.release()

if __name__ == '__main__':
	main()
