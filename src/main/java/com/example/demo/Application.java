package com.example.demo;

import com.example.demo.model.*;
import com.github.mhewedy.expressions.ExpressionsRepositoryImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
@EnableJpaRepositories(repositoryBaseClass = ExpressionsRepositoryImpl.class)
public class Application implements CommandLineRunner {

	private final EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {
		log.info("setting up");
		List<Employee> employees = Arrays.asList(
				new Employee(null,
						"ahmed",
						"ibrahim",
						new LingualString("ahmed ar", "ahmed en"),
						LocalDate.of(1980, 10, 10),
						10,
						Instant.parse("2007-12-03T10:15:30.00Z"),
						(short) 1,
						true,
						new Department(null, "hr", new City(null, "cairo")),
						Arrays.asList(new Task(null, "fix hr", Status.ACTIVE), new Task(null, "fix hr", Status.ACTIVE)),
						UUID.fromString("2dfb7bc7-38a6-4826-b6d3-297969d17244")
				),
				new Employee(null,
						"mohammad",
						"ibrahim",
						new LingualString("mohammad ar", "mohammad en"),
						LocalDate.of(1985, 10, 10),
						20,
						Instant.parse("2009-12-03T10:15:30.00Z"),
						(short) 1,
						true,
						new Department(null, "sw arch", new City(null, "giaz")),
						Arrays.asList(new Task(null, "fix sw arch", Status.ACTIVE), new Task(null, "fix sw arch", Status.ACTIVE)),
						UUID.randomUUID()
				),
				new Employee(null,
						"mostafa",
						"ahmed",
						new LingualString("mostafa ar", "mostafa en"),
						LocalDate.of(1988, 10, 10),
						30,
						Instant.parse("2011-12-03T10:15:30.00Z"),
						(short) 2,
						true,
						new Department(null, "sw dev", new City(null, "alex")),
						Arrays.asList(new Task(null, "fix sw dev", Status.ACTIVE), new Task(null, "fix sw dev", Status.ACTIVE)),
						UUID.randomUUID()
				),
				new Employee(null,
						"wael",
						"ibrahim",
						new LingualString("wael ar", "wael en"),
						LocalDate.of(1990, 10, 10),
						40,
						Instant.parse("2015-12-03T10:15:30.00Z"),
						(short) 2,
						true,
						new Department(null, "hr", new City(null, "cairo")),
						Arrays.asList(new Task(null, "fix hr", Status.ACTIVE), new Task(null, "fix hr", Status.ACTIVE)),
						UUID.randomUUID()
				),
				new Employee(null,
						"farida",
						"abdullah",
						new LingualString("farida ar", "farida en"),
						LocalDate.of(1979, 10, 10),
						50,
						Instant.parse("2017-12-03T10:15:30.00Z"),
						(short) 2,
						false,
						new Department(null, "hr", new City(null, "cairo")),
						Arrays.asList(new Task(null, "fix hr", Status.ACTIVE), new Task(null, "fix hr", Status.NOT_ACTIVE)),
						UUID.randomUUID()
				),
				new Employee(null,
						"fofo",
						"bobo",
						new LingualString("fofo ar", "fofo en"),
						LocalDate.of(1979, 10, 10),
						50,
						Instant.parse("2017-12-03T10:15:30.00Z"),
						(short) 2,
						false,
						null,
						null,
						UUID.randomUUID()
				)
		);
		employeeRepository.saveAll(employees);

		log.info("we have {} employees in the database", employeeRepository.count());
	}
}
