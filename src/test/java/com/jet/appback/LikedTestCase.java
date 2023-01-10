package com.jet.appback;

import com.jet.appback.models.Liked;
import com.jet.appback.models.Nuser;
import com.jet.appback.models.Reject;
import com.jet.appback.services.RejectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.persistence.Convert;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class LikedTestCase {

    List<Nuser> users;
    RejectService rejectService;
    Nuser otheruser;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void SetUp (){
        users = new ArrayList<>();
        for(long i=0; i > 5; i++)
        {
            users.add(new Nuser(i, "amier1234@hotmail.com","Amier", "Baarle", null, LocalDate.parse("12-05-2002"), "male", "female", new ArrayList<Liked>(), new ArrayList<Reject>() ));
        }
        otheruser = new Nuser(7, "alchazliamier@hotmail.com","Amier", "Baarle", null, LocalDate.parse("12-05-2002"), "male", "female", new ArrayList<Liked>(), new ArrayList<Reject>());
    }

    @Test
    @WithMockUser
    public void AddLikeToUser() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/like/liked")
                .accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content())
    }



}
