package in.gmsk;

import in.gmsk.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

    private final Logger logger =
            LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(DatabaseDemoApplication.class, args);
    }

    @Override
    public void run(String... args) {

        logger.trace("All Users -> {} ", repository.findAll());
        logger.trace("User Id 1 -> {} ", repository.findById(1));
        logger.trace("User name Jay Kumar -> {} ", repository.findByName("Jay Kumar"));
        logger.trace("Deleting 2 -> No of Rows Deleted {} ", repository.deleteById(3));

        /*logger.info("All Users -> {} ", repository.findAll());
        logger.info("User Id 1 -> {} ", repository.findById(1));
        logger.info("User name Jay Kumar -> {} ", repository.findByName("Jay Kumar"));
        logger.info("Deleting 2 -> No of Rows Deleted {} ", repository.deleteById(3));*/
    }
}
