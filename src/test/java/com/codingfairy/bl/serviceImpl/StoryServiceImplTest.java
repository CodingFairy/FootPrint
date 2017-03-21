package com.codingfairy.bl.serviceImpl;

import com.codingfairy.BaseTest;
import com.codingfairy.bl.vo.ResultVo;
import com.codingfairy.bl.vo.StoryVo;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Mr.Zero on 2017/3/21.
 */
public class StoryServiceImplTest extends BaseTest{

    @Resource
    private StoryServiceImpl storyService;

    @Test
    public void createStory() throws Exception {
//        List<String> imageList = new ArrayList<>();
//        imageList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490685600&di=db5aae986d28c963be3f804984a2ee21&imgtype=jpg&er=1&src=http%3A%2F%2Fwww.cd-pa.com%2Fbbs%2Fdata%2Fattachment%2Fforum%2F201504%2F19%2F095103mtvibaabibb6i8jx.jpg");
//        imageList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490685603&di=ce5b97a4df33a4f7378098532b2528b0&imgtype=jpg&er=1&src=http%3A%2F%2Fwww.th7.cn%2Fd%2Ffile%2Fp%2F2016%2F06%2F15%2F06e67e3076d05f6634706f083ce19b89.jpg");
//        ResultVo<StoryVo> resultVo = storyService.createStory(1,"service层测试story",120.0, 23.0, imageList);
//        assertNotNull(resultVo);
    }

    @Test
    public void deleteStory() throws Exception {
        assertNotNull(storyService.deleteStory(15));
    }

    @Test
    public void getStory() throws Exception {
        assertNotNull(storyService.getStory(16));
    }

    @Test
    public void starStory() throws Exception {
        assertNotNull(storyService.starStory(1,17));
        assertNotNull(storyService.starStory(1,16));
    }

    @Test
    public void unStarStory() throws Exception {

    }

    @Test
    public void comment() throws Exception {
        assertNotNull(storyService.comment(1,17,"这是1号用户对17号故事的评论",-1));
    }

    @Test
    public void deleteComment() throws Exception {

    }

    @Test
    public void getCommentList() throws Exception {

    }

    @Test
    public void getStoryList() throws Exception {
        assertNotNull(storyService.getCommentList(17));
    }

    @Test
    public void getRouteList() throws Exception {

    }

    @Test
    public void getRecommendStory() throws Exception {

    }

}