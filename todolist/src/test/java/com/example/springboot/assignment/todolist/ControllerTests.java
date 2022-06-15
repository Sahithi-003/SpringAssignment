package com.example.springboot.assignment.todolist;

import com.example.springboot.assignment.todolist.controller.TodoController;
import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class ControllerTests {
    private MockMvc mockMvc;
    TodoController todoController;
    @org.junit.jupiter.api.BeforeEach
    public void setup()
    {
       todoController = new TodoController();
        mockMvc= MockMvcBuilders.standaloneSetup(todoController).build();
    }

    @Test
    void contextLoads()
    {
        assertThat(todoController).isNotNull();
    }


}
