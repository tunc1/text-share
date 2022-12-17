package app.service;

import app.entity.Text;
import app.repository.TextRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class TextServiceTest
{
    @Mock
    TextRepository textRepository;
    TextService textService;

    @BeforeEach
    void setUp()
    {
        textService=new TextService(textRepository);
    }
    @Test
    void save()
    {
        Text text=new Text();
        Mockito.when(textRepository.save(Mockito.any())).thenAnswer(e->e.getArgument(0,Text.class));
        Text saved=textService.save(text);
        Assertions.assertEquals(text,saved);
    }
    @Test
    void findById_returnsText()
    {
        Text text=new Text();
        Mockito.when(textRepository.findByIdAndExpireDateGreaterThan(Mockito.any(),Mockito.any())).thenReturn(Optional.of(text));
        Text actual=textService.findById(Long.valueOf("1"));
        Assertions.assertEquals(text,actual);
    }
    @Test
    void findById_throwsEntityNotFoundException()
    {
        Mockito.when(textRepository.findByIdAndExpireDateGreaterThan(Mockito.any(),Mockito.any())).thenReturn(Optional.empty());
        Assertions.assertThrows(EntityNotFoundException.class,()->textService.findById(Long.valueOf("1")));
    }
    @Test
    void delete()
    {
        textService.delete();
        Mockito.verify(textRepository).deleteByExpireDateLessThan(Mockito.any());
    }
}