package top.pengcheng789.java.controller;

import org.hibernate.validator.HibernateValidator;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import top.pengcheng789.java.springblog.controller.UserController;
import top.pengcheng789.java.springblog.service.UserService;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * UserController 的测试类
 *
 * CreateDate:2017-08-07
 *
 * @author pen
 */
public class UserControllerTest {

    @Test
    public void shouldProcessRegistration() throws Exception {
        UserService mockService = mock(UserService.class);

        UserController controller = new UserController(mockService);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/user/register")
                .param("mail", "55@mail.com")
                .param("nickname", "1233")
                .param("password", "133333")
                .param("sex", "男")
        ).andExpect(redirectedUrl("/user/list"));
    }
}
