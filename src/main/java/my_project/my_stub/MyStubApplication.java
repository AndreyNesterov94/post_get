package my_project.my_stub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyStubApplication {

	public static void main(String[] args) {
		System.out.println("start service");
		SpringApplication.run(MyStubApplication.class, args);
	}

}
