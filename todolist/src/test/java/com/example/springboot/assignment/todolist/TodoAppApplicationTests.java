package com.example.springboot.assignment.todolist;

import com.example.springboot.assignment.todolist.dao.TodoRepo;
import com.example.springboot.assignment.todolist.entity.TodoItem;
import com.example.springboot.assignment.todolist.service.TodoServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
class TodoAppApplicationTests {
	private MockMvc mockMvc;
	@Autowired
	private TodoServiceImpl todoService;
	
	@MockBean
	private TodoRepo todoRepo;

	@Test
	void findAllTest() {
		when(todoRepo.findAll())
				.thenReturn(Stream.of(new TodoItem(1,"Dummy",true), new TodoItem(2,"Dummy2",false))
						.collect(Collectors.toList()));
		assertEquals(2,todoService.findAll().size());

	}


	@Test
	void failHandlerShouldReturnView() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/access-denied"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(view().name("denied"));
	}

	@Test
	void saveTest(){
		TodoItem item=new TodoItem(1,"Dummy",false);
		todoService.save(item);
		verify(todoRepo,times(1)).save(item);
	}
	@Test
	void deleteTest(){
		TodoItem item=new TodoItem(1,"Dummy",false);
		int id=1;
		todoService.deleteById(id);
		verify(todoRepo,times(1)).deleteById(id);
	}

}
