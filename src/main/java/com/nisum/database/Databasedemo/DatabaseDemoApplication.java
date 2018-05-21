package com.nisum.database.Databasedemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
/*@PropertySource(ignoreResourceNotFound = true, value = "classpath:external.properties")*/
public class DatabaseDemoApplication implements CommandLineRunner {
	
	/*@Autowired
	private PersonDAO dao;*/
	
	@Value("${foo.name}")
	public String name;
	
	

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
		
		
		/*DatabaseDemoApplication db=new DatabaseDemoApplication();
		*/
		
		
		/*new SpringApplicationBuilder(DatabaseDemoApplication.class)
		.properties("spring.config.name:external")
		.build()
		.run(args);*/
		
		
		/*System.out.println("HEY_______________________-------------" + db.name);*/
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(name);
	}

}
