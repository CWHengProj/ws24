package com.ws24.ws24;

import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.ws24.ws24.Service.MessagePoller;


@SpringBootApplication
@EnableAsync
public class Ws24Application implements CommandLineRunner {
	@Autowired
	MessagePoller mPoller;
	public static void main(String[] args){
		SpringApplication.run(Ws24Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (args.length>0){
			//if there is any argument, it will start listening
			String channelTopic = args[0];
			System.out.println("Looking at server to see if there is anything for "+channelTopic);
			mPoller.start(channelTopic);
		}
	}


}
