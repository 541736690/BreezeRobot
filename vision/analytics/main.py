#!/usr/bin/env python3

import cv2
import numpy as np
from matplotlib import pyplot

MAX_RANGE = 543

config_prev = {
    "hls": ([58,112,48], [105,255,152]),
    "bgr": ([96,78,0], [216,173,101])
}

config = {
    "hls": ([0,55,0], [180,255,255]),
    "bgr": ([0,0,0], [0,0,0])
}

def drawHist(data):
    pyplot.hist(data, 60)
    pyplot.xlabel('Target')
    pyplot.ylabel('Frequency')
    pyplot.title('Vision Process')
    pyplot.show()

def get_hls_image(img):
    # Hue Luminance Saturation
    lower = np.array(config["hls"][0])
    upper = np.array(config["hls"][1])
    return cv2.inRange(
        cv2.cvtColor(img, cv2.COLOR_BGR2HLS),
        lower, upper
    )

def get_bgr_image(img):
    # Blue Green Read
    lower = np.array(config["bgr"][0])
    upper = np.array(config["bgr"][1])
    return cv2.inRange(img, lower, upper)

def filter_contours(contours, hierarchy):
    for cnt, hier in zip(contours, hierarchy[0]):
        M = cv2.moments(cnt)

        if M['m00'] == 0:
            continue

        cx = M['m10']/M['m00']
        cy = M['m01']/M['m00']
        area = cv2.contourArea(cnt)

        hull = cv2.convexHull(cnt)
        hull_area = cv2.contourArea(hull)
        solidity = float(area) / hull_area
        x,y,w,h = cv2.boundingRect(cnt)
        aspect_ratio = float(w) / h

        if cx >= 10 and cx <= 1000 and cy >= 10 and cy <= 300 and area >= 100 and hier[3] == -1 and solidity <= 60 \
            and 0.3 <= aspect_ratio and aspect_ratio <= 5:
            yield cnt

data = []

for i in range(MAX_RANGE):
    img = cv2.imread("TestData/RealFullField/%d.jpg" % (i))

    if not img is None:
        mask = cv2.add(get_hls_image(img), get_bgr_image(img))

        im2, contours, hierarchy = cv2.findContours(mask, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)

        contours = list(filter_contours(contours, hierarchy))

        data.append(len(contours))

        cv2.drawContours(img, contours, -1, (0,255,0), 3)

        cv2.imwrite("TestData/Result/res%d.png" % (i), img)

        print("%d/%d" % (i + 1, MAX_RANGE))

drawHist(data)
