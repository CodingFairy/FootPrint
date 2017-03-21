package com.codingfairy.bl.serviceImpl;

import com.codingfairy.BaseTest;
import com.codingfairy.bl.vo.EmotionVo;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by Mr.Zero on 2017/3/20.
 */
public class RecognizeServiceImplTest extends BaseTest {

    @Resource
    private RecognizeServiceImpl recognizeService;

    @Test
    public void getImageEmotion() throws Exception {
        EmotionVo emotionVo = recognizeService.getImageEmotion("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490685603&di=ce5b97a4df33a4f7378098532b2528b0&imgtype=jpg&er=1&src=http%3A%2F%2Fwww.th7.cn%2Fd%2Ffile%2Fp%2F2016%2F06%2F15%2F06e67e3076d05f6634706f083ce19b89.jpg");
        assertNotNull(emotionVo);
    }

}