package umc.umc.study;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import umc.umc.study.service.StoreService.StoreCommandService;
import umc.umc.study.service.StoreService.StoreQueryService;

@SpringBootApplication
public class UmcApplication {

	public static void main(String[] args) {
		SpringApplication.run(UmcApplication.class, args);


	}

//	@Bean
//	public CommandLineRunner run(ApplicationContext context) {
//		return args -> {
//			StoreCommandService storeService = context.getBean(StoreCommandService.class);
//
//			// 파라미터 값 설정
//			String name = "요아정";
//			Float score = 4.0f;
//
//			// 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
//			System.out.println("Executing findStoresByNameAndScore with parameters:");
//			System.out.println("Name: " + name);
//			System.out.println("Score: " + score);
//
//
//		};
//
//
//	}
}