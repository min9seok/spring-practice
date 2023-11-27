package org.doit.ky.di2;

import org.doit.ky.di.RecordImpl;
import org.doit.ky.di.RecordViewImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config { // application-context.xml p 85
	
		@Bean
		public RecordImpl recordImpl() {
			return new RecordImpl();
		}
//		@Bean
//		public RecordViewImpl rvi() {
//			return new RecordViewImpl(recordImpl());
//		}
		@Bean(name = "rvi")
		public RecordViewImpl getrecordViewImpl() {
		RecordViewImpl rvi = new RecordViewImpl();
		rvi.setRecordImple(recordImpl());
			return rvi;
		}
			
		
						
}
