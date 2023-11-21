package com.apiMobile.ApiMobileEducarParaTransformar;

import com.apiMobile.ApiMobileEducarParaTransformar.Entity.*;
import com.apiMobile.ApiMobileEducarParaTransformar.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ApiMobileEducarParaTransformarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiMobileEducarParaTransformarApplication.class, args);
	}

}
