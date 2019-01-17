package omega;


import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJSONDoc
public class ProjectSchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectSchoolApplication.class, args);
	}

}

