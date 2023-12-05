<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
<link rel="shortcut icon" href="http://localhost/images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/cdn-main/example.css">
<script src="/resources/cdn-main/example.js"></script>
<style>
 span.material-symbols-outlined{
    vertical-align: text-bottom;
 }
</style>
</head>
<body>
<h1>
	Hello world!  
</h1>
<P>  The time on the server is ${serverTime}. </P>
<div>
<xmp class="code">
 1. JSP MVC 패턴 구현
  웹서버(Tomcat) 시작 > web.xml 읽기 > ㄱ. MV[C] 컨트롤러 서블릿 1 생성
                                 > commandHandler.properties
                                 > init(){ k,v map = "/board/list.do", ListHandler.java
                                 
                                 > ㄴ. 필터 생성(등록)
                                 > ㄷ. DBCP 설정 정보
                                 
  								
  /board/list.do > 모든 *.do
                   MV[C] 컨트롤러
                   ArrayList<BoardDTO> list = ListHandler.process()
                   
                 > ListService         > BoardDAO > 
                 list = selectService() list = selectBoard()
                 
                 > ListHandler.process()
                  request.setAttribute("list",list);
                 return "/board/list.jsp";
                 > MV[C] 컨트롤러   
                  포워딩
  /board/list.jsp 응답       
 2. Spring MVC 패턴 구현                                      컨트롤러메서드
             요청URL > 컨트롤러 검색 > Front Controller > RA > 컨트롤(ListHandler) > 결과저장 > VR > Front Controller > View(jsp)
                     @RequestMapping
                                                
  list.do > Front Controller( MV[C] 서블릿 )
 
 
 3. Servers Start
11월 22, 2023 4:34:46 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: 서버 버전 이름:    Apache Tomcat/8.5.93
11월 22, 2023 4:34:46 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: Server 빌드 시각:  Aug 23 2023 22:43:14 UTC
11월 22, 2023 4:34:46 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: Server 버전 번호:  8.5.93.0
11월 22, 2023 4:34:46 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: 운영체제 이름:     Windows 10
11월 22, 2023 4:34:46 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: 운영체제 버전:     10.0
11월 22, 2023 4:34:46 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: 아키텍처:          amd64
11월 22, 2023 4:34:46 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: 자바 홈:           C:\Program Files\Java\jdk-11
11월 22, 2023 4:34:46 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: JVM 버전:          11.0.19+9-LTS-224
11월 22, 2023 4:34:46 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: JVM 벤더:          Oracle Corporation
11월 22, 2023 4:34:46 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: CATALINA_BASE:     E:\Class\WORKSPACE\SpringClass\.metadata\.plugins\org.eclipse.wst.server.core\tmp0
11월 22, 2023 4:34:46 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: CATALINA_HOME:     C:\apache-tomcat-8.5.93
11월 22, 2023 4:34:46 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: 명령 행 아규먼트:  -Dcatalina.base=E:\Class\WORKSPACE\SpringClass\.metadata\.plugins\org.eclipse.wst.server.core\tmp0
11월 22, 2023 4:34:46 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: 명령 행 아규먼트:  -Dcatalina.home=C:\apache-tomcat-8.5.93
11월 22, 2023 4:34:46 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: 명령 행 아규먼트:  -Dwtp.deploy=E:\Class\WORKSPACE\SpringClass\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps
11월 22, 2023 4:34:46 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: 명령 행 아규먼트:  --add-opens=java.base/java.lang=ALL-UNNAMED
11월 22, 2023 4:34:46 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: 명령 행 아규먼트:  --add-opens=java.base/java.io=ALL-UNNAMED
11월 22, 2023 4:34:46 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: 명령 행 아규먼트:  --add-opens=java.base/java.util=ALL-UNNAMED
11월 22, 2023 4:34:46 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: 명령 행 아규먼트:  --add-opens=java.base/java.util.concurrent=ALL-UNNAMED
11월 22, 2023 4:34:46 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: 명령 행 아규먼트:  --add-opens=java.rmi/sun.rmi.transport=ALL-UNNAMED
11월 22, 2023 4:34:46 오후 org.apache.catalina.startup.VersionLoggerListener log
INFO: 명령 행 아규먼트:  -Dfile.encoding=UTF-8
11월 22, 2023 4:34:46 오후 org.apache.catalina.core.AprLifecycleListener lifecycleEvent
INFO: 프로덕션 환경들에서 최적의 성능을 제공하는, APR 기반 Apache Tomcat Native 라이브러리가, 다음 java.library.path에서 발견되지 않습니다: [C:\Program Files\Java\jdk-11\bin;C:\WINDOWS\Sun\Java\bin;C:\WINDOWS\system32;C:\WINDOWS;C:/Program Files/Java/jdk-11/bin/server;C:/Program Files/Java/jdk-11/bin;C:\oraclexe\app\oracle\product\11.2.0\server\bin;;C:\Program Files\Java\jdk-11\bin;C:\Program Files\Common Files\Oracle\Java\javapath;C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\iCLS\;C:\Program Files\Intel\Intel(R) Management Engine Components\iCLS\;C:\WINDOWS\system32;C:\WINDOWS;C:\WINDOWS\System32\Wbem;C:\WINDOWS\System32\WindowsPowerShell\v1.0\;C:\WINDOWS\System32\OpenSSH\;C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\DAL;C:\Program Files\Intel\Intel(R) Management Engine Components\DAL;C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\IPT;C:\Program Files\Intel\Intel(R) Management Engine Components\IPT;C:\Program Files\Bandizip\;C:\Program Files\Git\cmd;C:\Users\user\AppData\Local\Microsoft\WindowsApps;;C:\spring-tool-suite-3.9.18.RELEASE-e4.21.0\sts-bundle\sts-3.9.18.RELEASE;;.]
11월 22, 2023 4:34:46 오후 org.apache.coyote.AbstractProtocol init
INFO: 프로토콜 핸들러 ["http-nio-80"]을(를) 초기화합니다.
11월 22, 2023 4:34:46 오후 org.apache.catalina.startup.Catalina load
INFO: Initialization processed in 596 ms
11월 22, 2023 4:34:46 오후 org.apache.catalina.core.StandardService startInternal
INFO: 서비스 [Catalina]을(를) 시작합니다.
11월 22, 2023 4:34:46 오후 org.apache.catalina.core.StandardEngine startInternal
INFO: 서버 엔진을 시작합니다: [Apache Tomcat/8.5.93]
11월 22, 2023 4:34:47 오후 org.apache.jasper.servlet.TldScanner scanJars
INFO: 적어도 하나의 JAR가 TLD들을 찾기 위해 스캔되었으나 아무 것도 찾지 못했습니다. 스캔했으나 TLD가 없는 JAR들의 전체 목록을 보시려면, 로그 레벨을 디버그 레벨로 설정하십시오. 스캔 과정에서 불필요한 JAR들을 건너뛰면, 시스템 시작 시간과 JSP 컴파일 시간을 단축시킬 수 있습니다.
11월 22, 2023 4:34:47 오후 org.apache.catalina.core.ApplicationContext log
INFO: No Spring WebApplicationInitializer types detected on classpath
11월 22, 2023 4:34:47 오후 org.apache.catalina.core.ApplicationContext log
INFO: Initializing Spring root WebApplicationContext
INFO : org.springframework.web.context.ContextLoader - Root WebApplicationContext: initialization started
INFO : org.springframework.web.context.support.XmlWebApplicationContext - Refreshing Root WebApplicationContext: startup date [Wed Nov 22 16:34:47 KST 2023]; root of context hierarchy
INFO : org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loading XML bean definitions from ServletContext resource [/WEB-INF/spring/root-context.xml]
INFO : org.springframework.beans.factory.support.DefaultListableBeanFactory - Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@11d6ecb2: defining beans []; root of factory hierarchy
INFO : org.springframework.web.context.ContextLoader - Root WebApplicationContext: initialization completed in 676 ms
11월 22, 2023 4:34:48 오후 org.apache.catalina.core.ApplicationContext log
INFO: Initializing Spring FrameworkServlet 'appServlet'
INFO : org.springframework.web.servlet.DispatcherServlet - FrameworkServlet 'appServlet': initialization started
INFO : org.springframework.web.context.support.XmlWebApplicationContext - Refreshing WebApplicationContext for namespace 'appServlet-servlet': startup date [Wed Nov 22 16:34:48 KST 2023]; parent: Root WebApplicationContext
INFO : org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loading XML bean definitions from ServletContext resource [/WEB-INF/spring/appServlet/servlet-context.xml]
INFO : org.springframework.context.annotation.ClassPathBeanDefinitionScanner - JSR-250 'javax.annotation.ManagedBean' found and supported for component scanning
INFO : org.springframework.context.annotation.ClassPathBeanDefinitionScanner - JSR-330 'javax.inject.Named' annotation found and supported for component scanning
INFO : org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor - JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
INFO : org.springframework.beans.factory.support.DefaultListableBeanFactory - Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@52384cd3: defining beans [org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping#0,org.springframework.format.support.FormattingConversionServiceFactoryBean#0,org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter#0,org.springframework.web.servlet.handler.MappedInterceptor#0,org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver#0,org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver#0,org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver#0,org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping,org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter,org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter,org.springframework.web.servlet.resource.ResourceHttpRequestHandler#0,org.springframework.web.servlet.handler.SimpleUrlHandlerMapping#0,org.springframework.web.servlet.view.InternalResourceViewResolver#0,homeController,org.springframework.context.annotation.internalConfigurationAnnotationProcessor,org.springframework.context.annotation.internalAutowiredAnnotationProcessor,org.springframework.context.annotation.internalRequiredAnnotationProcessor,org.springframework.context.annotation.internalCommonAnnotationProcessor,org.springframework.context.annotation.ConfigurationClassPostProcessor$ImportAwareBeanPostProcessor#0]; parent: org.springframework.beans.factory.support.DefaultListableBeanFactory@11d6ecb2
INFO : org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping - Mapped "{[/],methods=[GET],params=[],headers=[],consumes=[],produces=[],custom=[]}" onto public java.lang.String org.doit.ky.HomeController.home(java.util.Locale,org.springframework.ui.Model)
INFO : org.springframework.web.servlet.handler.SimpleUrlHandlerMapping - Mapped URL path [/resources/**] onto handler 'org.springframework.web.servlet.resource.ResourceHttpRequestHandler#0'
INFO : org.springframework.web.servlet.DispatcherServlet - FrameworkServlet 'appServlet': initialization completed in 868 ms
11월 22, 2023 4:34:49 오후 org.apache.coyote.AbstractProtocol start
INFO: 프로토콜 핸들러 ["http-nio-80"]을(를) 시작합니다.
11월 22, 2023 4:34:49 오후 org.apache.catalina.startup.Catalina start
INFO: Server startup in 2705 ms
INFO : org.doit.ky.HomeController - Welcome home! The client locale is ko_KR.         
</xmp>  
<xmp class="code">
1. 처리 순서(과정) 이해
a. web.xml  
  - MV[C] 프론트컨트롤러 등록 + servlet-content.xml 설정파일 읽어와서 처리
                       context:component-scan base-package="" 안에 있는 패키지 이름 을 참조 > 스프링 빈 객체 생성 > 컨트롤러 메서드 사용
                       
  - /WEB-INF/spring/root-context.xml     스프링 빈 객체 생성, 설정
    /WEB-INF/spring/security-context.xml 스프링 시큐리티 (인증,권한) 설정                             
b. 브라우저 http://localhost > home.jsp 응답 

2. 오류해결 과정
a. src/main/resources > log4jdbc.log4j2.properties 추가 : 이유 root-context.xml 에 있는 내용 
<property name="driverClassName"    value="net.sf.log4jdbc.sql.jdbcapi.DriverSpy"></property>
<property name="jdbcUrl" value="jdbc:log4jdbc:oracle:thin:@localhost:1521:xe"></property>
b. ojdbc6.jar 모듈 설정 
                        
스프링 + mybatis 연동 
1. root-context.xml  스프링 빈 객체들은 DB 연동할 떄 사용하는 빈 객체가 등록    
  <bean id="hikariConfig">
  <bean id="dataSource">
  -- pom.xml
  <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis p91 -->
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis</artifactId>
			<version>3.4.6</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis-spring</artifactId>
			<version>1.3.2</version>
		</dependency>
		
  -- mybaits 연동 빈 객체		
   <!-- p91 -->
   <bean id="sqlSessionFactoryBean" class="org.mybatis.spring.SqlSessionFactoryBean">
     <property name="dataSource" ref="dataSource"></property>
   </bean>
      
   <!-- p95 -->
   <mybatis-spring:scan base-package="org.doit.ky.mapper"/>   
   
 jsp 수업 DB 연동
  list.do  > ListHandler > ListService > BoardDAO
             list        < list        < list  select()
             request.setAttribute("list",list)
             return "list.jsp" 
  list.jsp <     
  
(1) org.doit.ky.mapper 패키지 생성    
(2) TimeMapper.java 인터페이스 추가 String getTime(); 코딩               
(3) src/main/resources
    org 폴더 > doit 폴더 > ky 폴더 > mapper 폴더 > xml 파일 추가
(4) <h3><a href="/time">/time</a></h3> 추가
 - MybatisController.java 추가           
</xmp>  
</div>
</body>
</html>
