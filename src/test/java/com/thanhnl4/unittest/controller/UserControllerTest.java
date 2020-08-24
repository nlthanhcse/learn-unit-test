package com.thanhnl4.unittest.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.thanhnl4.unittest.model.User;
import com.thanhnl4.unittest.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class)
public class UserControllerTest {
	@MockBean
	private UserService userService;
	@Autowired
	private MockMvc mockMvc;
	@Test
	public void getAllUser_Test() {
		List<User> users = new ArrayList<>();
		users.add(new User(1, 10, "Name 1"));
//		users.add(new User(2, 20, "Name 2"));
//		users.add(new User(3, 30, "Name 3"));
		when(userService.getAll()).thenReturn(users);
		RequestBuilder request = MockMvcRequestBuilders
				.get("/users")
				.accept("application/json");
		try {
			MvcResult result = mockMvc
					.perform(request)
					.andExpect(status().isOk())
					.andReturn();
			JSONAssert.assertEquals("[{id:1,age:10,name:\"Name 1\"}]", result.getResponse().getContentAsString(), false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
