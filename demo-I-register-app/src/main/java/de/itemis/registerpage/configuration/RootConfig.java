package de.itemis.registerpage.configuration;

import de.itemis.registerpage.RegisterPageController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import java.util.regex.Pattern;

@Configuration
@ComponentScan(basePackageClasses= RegisterPageController.class)
public class RootConfig {
  public static class WebPackage extends RegexPatternTypeFilter {
    public WebPackage() {
      super(Pattern.compile("passwordchecker\\.web"));
    }    
  }
}
