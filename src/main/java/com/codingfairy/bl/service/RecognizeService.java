package com.codingfairy.bl.service;

import com.codingfairy.bl.vo.EmotionVo;

/**
 * invoke ms recognize api to analyse emotion
 */
public interface RecognizeService {

    public EmotionVo getImageEmotion(String imgUrl);
}
