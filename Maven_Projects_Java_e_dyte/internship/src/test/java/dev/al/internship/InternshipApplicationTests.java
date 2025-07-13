package dev.al.internship;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
 class LanguageController {

	// GET endpoint që kthen mesazh statik
	@GetMapping("/hello")
	public String getHello() {
		return "Përshëndetje nga Spring Boot!";
	}

	// POST endpoint qe kthen mesazh bazuar ne gjuhen qe zgjedh
	@PostMapping("/message")
	public String getMessage(@RequestBody LanguageRequest request) {
		String language = request.getLanguage().toLowerCase();

		switch (language) {
			case "albanian":
				return "Përshëndetje!";
			case "english":
				return "Hello!";
			case "french":
				return "Bonjour!";
			default:
				return "Language not supported!";
		}
	}

	//  Klasa qe merr gjuhen e zgjedhur
	public static class LanguageRequest {
		private String language;

		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}
	}
}
