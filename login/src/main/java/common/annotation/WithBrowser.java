package common.annotation;

import common.environment.driver.Browser;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface WithBrowser {

	Browser browser() default Browser.fireFox;

	boolean withCookies() default true;
}
