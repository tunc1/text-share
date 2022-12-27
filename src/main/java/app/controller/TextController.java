package app.controller;

import app.entity.Text;
import app.service.TextService;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/text")
public class TextController
{
	private TextService textService;
	public TextController(TextService textService)
	{
		this.textService=textService;
	}
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public Text save(@RequestBody Text text)
	{
		text.setId(0L);
		return textService.save(text);
	}
	@GetMapping("/{id}")
	public Text findById(@PathVariable Long id)
	{
		return textService.findById(id);
	}
}