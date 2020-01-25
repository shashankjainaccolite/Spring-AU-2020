package configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import model.Point;

@Configuration
@PropertySource("value.properties")
public class ApplicationConfiguration {
	
	@Autowired
	public Environment environment;
	
	@Bean(name = "point")
	public Point getValueFromProperty() {
		Point point = new Point();
		point.setX(Integer.parseInt(this.environment.getProperty("x")));
		point.setY(Integer.parseInt(this.environment.getProperty("y")));
		return point;
	}

}
