package com.gwkim.posting.controller;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
//Test for controller
@WebAppConfiguration
//@ContextConfiguration({
//	"file:src/main/webapp/WEB-INF/spring/root-context.xml"
//	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
//})
@ContextConfiguration(classes = {
		com.gwkim.posting.config.RootConfig.class,
		com.gwkim.posting.config.ServletConfig.class
})
@Log4j
public class BoardControllerTests {

}
