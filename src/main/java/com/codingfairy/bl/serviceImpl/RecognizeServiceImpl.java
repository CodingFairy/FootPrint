package com.codingfairy.bl.serviceImpl;

import com.codingfairy.bl.service.RecognizeService;
import com.codingfairy.bl.vo.EmotionVo;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Mr.Zero on 2017/3/20.
 */
public class RecognizeServiceImpl implements RecognizeService {
    @Override
    public EmotionVo getImageEmotion(String imgUrl) {
        String testUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490605057&di=ee127846a5e30ca87ddec5fabc12740f&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.cmol.com%2Fimages%2Fuploadfile%2F2015%2F0728%2F20150728012521632.jpg";
        HttpClient httpClient = new DefaultHttpClient();
        try {
            URIBuilder uriBuilder = new URIBuilder("https://westus.api.cognitive.microsoft.com/emotion/v1.0/recognize");
            URI uri = uriBuilder.build();
            HttpPost request = new HttpPost(uri);

            // Request headers. Replace the example key below with your valid subscription key.
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", "aa04808f99754e89b42bb72da5965dfc");

            // Request body. Replace the example URL below with the URL of the image you want to analyze.
            StringEntity reqEntity = new StringEntity("{ \"url\": \""+testUrl+"\" }");
            request.setEntity(reqEntity);

            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                System.out.println("=================================================");
                System.out.println(EntityUtils.toString(entity));
                System.out.println("=================================================");
            }

        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new EmotionVo();
    }
}
