#!/usr/bin/env python3

import cv2
import numpy as np
import logging
from networktables import NetworkTable
import time
import config

from utils import camserver
from detect import detect

logging.basicConfig(level=logging.DEBUG)

def do_capture(self):
    if capture.isOpened():
        ret, frame = capture.read()
        if ret:
            img, cnt = detect.do_detect(frame)
            ntable.putNumber("auto_enabled", 0)
            ntable.putNumber("manual_exposure", 0)
            if cnt == 0:
                ntable.putNumber("target_count", 2)
            elif cnt == 1:
                ntable.putNumber("target_count", 0)
            elif cnt >= 2:
                ntable.putNumber("target_count", 1)

            ntable.putNumber("target_angle", 0)
            ntable.putNumber("robotdrive_status", 0)
            ntable.putNumber("target_count_number", cnt)
            ntable.putNumber("target_angle_number", 0)


            return cv2.resize(img, (320, 240))
        else:
            return None
    else:
        return None

def init_ntable():
    global ntable
    NetworkTable.setTeam(config.team)
    NetworkTable.initialize()

    ntable = NetworkTable.getTable('vision');

def main():
    global capture
    capture = cv2.VideoCapture(0)
    try:
        camserver.serve(config.server, do_capture)
    except KeyboardInterrupt:
        capture.release()

if __name__ == '__main__':
    main()
