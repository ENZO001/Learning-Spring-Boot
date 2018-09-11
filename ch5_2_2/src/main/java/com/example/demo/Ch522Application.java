package com.example.demo;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.ResourceBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Ch522Application {

	@Value("${book.author}")
	private String bookAuthor;

	@Value("${book.name}")
	private String bookName;

	@RequestMapping("/")
	public String index() {
		return "book name is : \"" + bookName + "\" and book author is : " + bookAuthor;
	}

	public static void main(String[] args) {
		// ====================================================================
		// --------------- 一般預設的 ---------------
//		 SpringApplication.run(Ch522Application.class, args);
		// ====================================================================

		// ====================================================================
		// --------------- 關閉 banner 顯示 (在程式中設定) ---------------
//		SpringApplication application = new SpringApplication(Ch522Application.class);
//		application.setBannerMode(Banner.Mode.OFF);
//		application.run(args);

		// --------------- 關閉 banner 顯示 (在properties中設定) ---------------
		// spring.main.banner-mode=off
		// ====================================================================

		// ====================================================================
		// --------------- 更換 banner ----------------
		// 在 src/main/resources/banner 下新增一個 banner.txt

		// --------------- 更換 banner (普通API) ----------------
		SpringApplication application = new SpringApplication(Ch522Application.class);
		Banner banner = new ResourceBanner(new FileSystemResource(new File("src/main/resources/banner-fuck.txt")));
		application.setBanner(banner);
		application.run(args);

		// --------------- 更換 banner (Fluent Builder API) ----------------
//		new SpringApplicationBuilder()
//				.sources(Ch522Application.class)
//				.banner(new ResourceBanner(new FileSystemResource(new File("src/main/resources/banner-fuck.txt"))))
//				.run(args);
		// ====================================================================

	}
}
