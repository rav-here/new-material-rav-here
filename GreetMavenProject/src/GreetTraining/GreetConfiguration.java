package GreetTraining;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import GreetDemo.*;

@Configuration
public class GreetConfiguration {

	@Bean(name = "mrng")
	public GoodMorning getGoodMoring() {
		return new GoodMorning();
	}
	
	@Bean(name="eve")
	public GoodEvening getGoodEvening() {
		return new GoodEvening();
	}
	
	public GoodAfterNoon getGoodAfterNoon() {
		return new GoodAfterNoon();
	}
}