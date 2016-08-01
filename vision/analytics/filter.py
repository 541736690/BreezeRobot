import detect as detect

def filter_fn(img):
    '''
        :param img: A numpy array representing the input image
        :returns: A numpy array to send to the mjpg-streamer output plugin
    '''
    img, cnt = detect.do_detect(img)
    
    return img

def init_filter():
    return filter_fn
