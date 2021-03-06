package com.javatoolbox.unit;

import com.javatoolbox.AdminController;
import com.javatoolbox.groups.Group;
import com.javatoolbox.groups.GroupsRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class AdminControllerTest {
    @InjectMocks
    AdminController adminController;

    @Mock
    GroupsRepository groupsRepository;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(adminController).build();
    }

    @Test
    public void index_rendersIndex() throws Exception {
        List<Group> groups = new ArrayList<>();

        when(groupsRepository.findAll()).thenReturn(groups);

        mockMvc.perform(get("/admin"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/index"))
                .andExpect(model().attribute("groups", groups));
    }
}