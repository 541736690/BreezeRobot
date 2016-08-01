#!/usr/bin/env python3
import cv2
import detect as detect

cap = cv2.VideoCapture(0)

fcnt = 0

while cap.isOpened():
    ret, frame = cap.read()
    if ret:
        img = frame
        # img, cnt = detect.do_detect(frame)
        cv2.imwrite("/mnt/ramdisk/%d.jpg" % fcnt, img)
        fcnt = fcnt + 1
    else:
        break

cap.release()

    
