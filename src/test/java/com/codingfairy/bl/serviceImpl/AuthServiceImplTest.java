package com.codingfairy.bl.serviceImpl;

import com.codingfairy.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by Mr.Zero on 2017/3/21.
 */
public class AuthServiceImplTest extends BaseTest {

    @Resource
    private AuthServiceImpl authService;

    @Test
    public void register() throws Exception {
        assertNotNull(authService.register("testUser1", "1234qwer", "13913913139", "male"));
    }

    @Test
    public void login() throws Exception {
        assertNotNull(authService.login("cuiods", "123456"));
    }

}