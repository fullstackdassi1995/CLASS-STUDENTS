package full.mypostgresql.demo;

import full.mypostgresql.demo.model.Gender;
import full.mypostgresql.demo.model.Student;
import full.mypostgresql.demo.repository.StudentRepo;
import full.mypostgresql.demo.service.ClassRoomService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@EnableFeignClients
public class DemoApplication{

		public static void main(String[] args) {

			ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
	}

}
