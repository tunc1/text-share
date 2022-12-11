package app.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import app.entity.Text;
import app.repository.TextRepository;

import java.time.LocalDateTime;

@Service
public class TextService
{
	private TextRepository textRepository;
	public TextService(TextRepository textRepository)
	{
		this.textRepository=textRepository;
	}
	public Text save(Text text)
	{
		return textRepository.save(text);
	}
	public Text findById(Long id)
	{
		return textRepository.findByIdAndExpireDateGreaterThan(id,LocalDateTime.now()).orElseThrow(EntityNotFoundException::new);
	}
}