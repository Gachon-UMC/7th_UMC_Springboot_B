package umc.study;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.study.domain.Store;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.service.StoreService.StoreQueryService;

@SpringBootApplication
@EnableJpaAuditing
public class StudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			StoreRepository storeRepository = context.getBean(StoreRepository.class);
			StoreQueryService storeService = context.getBean(StoreQueryService.class);

			// 더미 데이터 저장
			Store dummyStore = Store.builder()
					.name("요아정")
					.address("서울특별시")
					.rating(4.5f)
					.build();
			storeRepository.save(dummyStore);

			// 쿼리 실행
			String name = "요아정";
			Float rating = 4.0f;

			System.out.println("Executing findStoresByNameAndScore with parameters:");
			System.out.println("Name: " + name);
			System.out.println("Rating: " + rating);

			storeService.findStoresByNameAndScore(name, rating)
					.forEach(System.out::println);
		};
	}
}