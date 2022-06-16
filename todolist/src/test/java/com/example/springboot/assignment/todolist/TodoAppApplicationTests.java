package com.example.springboot.assignment.todolist;

import com.example.springboot.assignment.todolist.dao.TodoRepo;
import com.example.springboot.assignment.todolist.entity.TodoItem;
import com.example.springboot.assignment.todolist.service.TodoServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

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
//	@Test
//	void findByIdTest() {
//		TodoItem item=new TodoItem(1,"Dummy",false);
//		Optional<TodoItem> result = todoRepo.findById(1);
//		TodoItem theTodoitem = null;
//		if (result.isPresent()) {
//			theTodoitem = result.get();
//		}
//		when(todoRepo.findById(1)).thenReturn(Optional.ofNullable(theTodoitem));
//		assertEquals(1,todoService.findById(1));
	//}



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
