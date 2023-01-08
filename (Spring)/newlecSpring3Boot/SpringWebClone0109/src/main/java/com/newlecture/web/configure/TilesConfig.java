package com.newlecture.web.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
public class TilesConfig { // 클래스이름은 상관없다.
  @Bean // tiles지시서 config에 대한 객체 // IoC에 담게될 객체를 반환해주는 함수라는 의미이다.
  public TilesConfigurer tilesConfigurer(){
      //객체를 반환하는 함수가 있는데 객체의 이름은 함수이름으로 IoC컨테이너에 담아달라는 의미이다.
      TilesConfigurer tilesConfigurer = new TilesConfigurer();
      tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/tiles.xml"} );
      tilesConfigurer.setCheckRefresh(true);
      return tilesConfigurer;
    }
  @Bean // tiles뷰리졸버를 만든다.
  public TilesViewResolver tilesViewResolver(){
       TilesViewResolver  viewResolver = new TilesViewResolver();
       viewResolver.setViewClass(TilesView.class);
       viewResolver.setOrder(1);
       return viewResolver;
   }
}