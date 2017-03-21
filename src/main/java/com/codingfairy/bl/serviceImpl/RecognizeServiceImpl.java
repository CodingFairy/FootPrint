package com.codingfairy.bl.serviceImpl;

import com.codingfairy.bl.service.RecognizeService;
import com.codingfairy.bl.vo.EmotionVo;
import com.codingfairy.web.config.EmotionConfig;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Mr.Zero on 2017/3/20.
 */
@Service
public class RecognizeServiceImpl implements RecognizeService {

    @Autowired
    private EmotionConfig config;

    @Override
    public EmotionVo getImageEmotion(String imgUrl) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("url", imgUrl);
        try {
            HttpResponse<JsonNode> jsonResponse = Unirest.post(config.getApi())
                    .header("Content-Type", "application/json")
                    .header("Ocp-Apim-Subscription-Key", config.getToken1())
                    .body(jsonObject)
                    .asJson();
            JSONArray jsonArray = jsonResponse.getBody().getArray();
            if (jsonArray.length()==0){
                return null;
            } else {
                double anger = 0.0;
                double contempt = 0.0;
                double disgust = 0.0;
                double fear = 0.0;
                double happiness = 0.0;
                double neutral = 0.0;
                double sadness = 0.0;
                double surprise = 0.0;
                int count = 0;
                for (int i = 0 ; i<jsonArray.length();i++){
                    JSONObject scores = jsonArray.getJSONObject(i).getJSONObject("scores");
                    anger+=scores.getDouble("anger");
                    contempt+=scores.getDouble("contempt");
                    disgust+=scores.getDouble("disgust");
                    fear+=scores.getDouble("fear");
                    happiness+=scores.getDouble("happiness");
                    neutral+=scores.getDouble("neutral");
                    sadness+=scores.getDouble("sadness");
                    surprise+=scores.getDouble("surprise");
                    count++;
                }
                return new EmotionVo(anger/count,contempt/count,disgust/count,fear/count,
                        happiness/count,neutral/count,sadness/count,surprise/count);
            }
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }
}
