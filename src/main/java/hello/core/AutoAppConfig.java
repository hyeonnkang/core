package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( // @Component이 붙은 클래스를 자동으로 스프링빈으로 등록해준다.
        basePackages = "hello.core",    // hello.core 부터 찾아들어간다.
        basePackageClasses = AutoAppConfig.class,   // AutoAppConfig의 패키지는 현재 hello.core 이므로 hello.core부터 찾아들어간다.
        // 지정하지 않으면 @ComponentScan을 붙이는 클래스의 패키지 (현재 hello.core) 부터 시작하는게 디폴트이다.

        // @Configuration에 @Component가 포함되어있기 때문에 파일을 제외해준다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    @Bean(name="memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
