package jp.co.jti.ims.tc.batch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.lang.reflect.Method;
import java.util.Arrays;

@SpringBootApplication
public class BatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Running Spring Boot Application");
		if (args.length > 0 ) {
			for (String arg : args) {
				System.out.println("Command line argument: " + arg);
			} 
			this.invokeClass(args);
		}
		
	}

	private void invokeClass(String[] args) {
		try {
			Class<?> c = Class.forName("jp.co.jti.ims.tc.batch." + args[0]);
			Class[] argTypes = new Class[] { String[].class };
			Method main = c.getDeclaredMethod("main", argTypes);
			String[] mainArgs = Arrays.copyOfRange(args, 1, args.length);
			System.out.format("invoking %s.main()%n", c.getName());
			main.invoke(null, (Object) mainArgs);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
