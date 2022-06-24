package com.example.springboot.assignment.todolist.controller;

import com.example.springboot.assignment.todolist.dao.TodoRepo;
import com.example.springboot.assignment.todolist.dto.TodoItemDto;
import com.example.springboot.assignment.todolist.entity.TodoItem;
import com.example.springboot.assignment.todolist.entity.User;
import com.example.springboot.assignment.todolist.service.TodoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@RunWith(SpringRunner.class)
@SpringBootTest
class ControllerTests {

    private MockMvc mockMvc;
    @Autowired
    @MockBean
    private TodoServiceImpl todoService;

    @MockBean
    private TodoRepo todoRepo;

    TodoController basicController;
    @Autowired
    WebApplicationContext webApplicationContext;
    @Mock
    TodoItem item;
    @Mock
    TodoItemDto itemDto;
    @Mock
    User user;
    @Mock
    List<TodoItem> items;


    @Test
    void successPageTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/todolist/success"))
                .andExpect(status().isOk())
                .andExpect(view().name("todolist/success"));
    }


    @Test
    void getAccessDeniedTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        mockMvc.perform(get("/todolist/access-denied")).andExpect(status().is(200))
                .andExpect(view().name("access-denied"));
    }

    @org.junit.jupiter.api.BeforeEach
    public void setup()
    {
        basicController = new TodoController(todoService);
        mockMvc= MockMvcBuilders.standaloneSetup(basicController).build();
    }

    @Test
    void contextLoads()
    {
        assertThat(basicController).isNotNull();
    }


    @Test
    void shouldReturnListOfAllItemsView() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/todolist/lists"))
                .andExpect(status().isOk())
                .andExpect(view().name("todolist/list-items"));
    }

    @Test
    void shouldReturnListIndexView() throws Exception {
        TodoItem item = new TodoItem("Dummy", false);
        user = new User("username","password");
        items.add(item);
        Mockito.when(todoService.findByUserName("username")).thenReturn(user);
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        user.setItems(new ArrayList<>());
        Assertions.assertEquals(0, user.getItems().size());
    }


    @Test
    void formForAddTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/todolist/showFormForAdd"))
                .andExpect(status().isOk())
                .andExpect(view().name("todolist/todos"));
    }

    @Test
    void delete() throws Exception {
        TodoItem item = new TodoItem("Dummy", false);
        Mockito.when(todoService.findById(0)).thenReturn(item);
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        mockMvc.perform(get("/todolist/delete").queryParam("itemId","0")).andExpect(status().is(302))
                .andExpect(view().name("redirect:/todolist/lists"));
    }
    @Test
    void saveListItem() throws Exception {
        TodoItem item = new TodoItem("Dummy", false);
        items = new ArrayList<>();
        items.add(item);
        itemDto = new TodoItemDto("Dummy", false);
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        mockMvc.perform(post("/todolist/savelist").flashAttr("item",itemDto )).andExpect(status().is(302)).andExpect(view().name("redirect:/todolist/list"));

    }

    @Test
    void saveItemDtoTest() throws Exception {
        TodoItem item = new TodoItem("Dummy", false);
        items = new ArrayList<>();
        items.add(item);
        itemDto = new TodoItemDto("Dummy", false);
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        mockMvc.perform(post("/todolist/save").flashAttr("item",itemDto )).andExpect(status().is(302)).andExpect(view().name("redirect:/todolist/lists"));

    }
    @Test
    void showUpdateStatusFormTest() throws Exception {
        TodoItem item = new TodoItem("Dummy", false);
        Mockito.when(todoService.findById(0)).thenReturn(item);
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        mockMvc.perform(get("/todolist/showFormForUpdateStatus").queryParam("itemId", "0")).andExpect(status().is(200))
                .andExpect(view().name("status-page"));
    }
    @Test
    void updateWholeTaskTest() throws Exception {
        TodoItem item=new TodoItem("Dummy",false);
        Mockito.when(todoService.findById(0)).thenReturn(item);
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        mockMvc.perform(get("/todolist/showFormForUpdate").queryParam("itemId","0")).andExpect(status().is(200))
                .andExpect(view().name("todolist/todos"));
    }

}