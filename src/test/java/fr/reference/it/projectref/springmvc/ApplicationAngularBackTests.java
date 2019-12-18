package fr.reference.it.projectref.springmvc;


import fr.reference.it.projectref.domaine.dto.Utilisateur;
import fr.reference.it.projectref.domaine.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

@WebMvcTest
class ApplicationAngularBackTests {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    void getAllUsersTest() throws Exception
    {
        Mockito.when(userService.getAllUsers()).thenReturn(Arrays.asList(new Utilisateur("jaouad@gmail.com","jaouad","hba",new Date())));
        mockMvc.perform(MockMvcRequestBuilders.get("/users?pageNumber=1")).andDo(MockMvcResultHandlers.print());
    }
    @Test
    void shold_Get_User_With_GivenId()throws Exception{
        Mockito.when(userService.findUserById(1)).thenReturn(Optional.of(new Utilisateur("jaouad@gmail.com","jaouad","hba",new Date())));
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/users/1")).andDo(MockMvcResultHandlers.print()).andReturn().getResponse();
        Assertions.assertEquals(200,response.getStatus());
        Mockito.verify(userService).findUserById(1);
    }
    @Test
    void shold_Delete_User_With_GiverId()throws Exception{
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.delete("/users/user/1")).andDo(MockMvcResultHandlers.print()).andReturn().getResponse();
        Assertions.assertEquals(200,response.getStatus());
        Mockito.verify(userService).deleteUserById(1);
    }
}
