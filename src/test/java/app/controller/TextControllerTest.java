package app.controller;

import app.entity.Text;
import app.service.TextService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TextControllerTest
{
    @Mock
    TextService textService;
    TextController textController;

    @BeforeEach
    void setUp()
    {
        textController=new TextController(textService);
    }
    @Test
    void save()
    {
        Text text=new Text();
        Mockito.when(textService.save(Mockito.any())).thenAnswer(e->e.getArgument(0,Text.class));
        Text saved=textController.save(text);
        Assertions.assertEquals(text,saved);
    }
    @Test
    void findById()
    {
        Text text=new Text();
        Mockito.when(textService.findById(Mockito.any())).thenReturn(text);
        Text actual=textController.findById(Long.valueOf("1"));
        Assertions.assertEquals(text,actual);
    }
}