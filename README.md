# PConnect
这是一个耍java的项目

## 参考资料
Spring guides：https://spring.io/guides

## 编译打包
使用maven编译打包，打成war包，可以直接用java -jar PConnect*.war启动自服务运行，或者讲war包放在tomcat下运行都行，请使用tomcat9+.


## 关于Spring cloud

按照官网示例（http://projects.spring.io/spring-cloud/）做不下去，说maven仓库找不到对应的版本jar。所以暂时搁置。

后来发现Gateway的老版本可以用。
```
	<dependencyManagement>
	    <dependencies>
	        <dependency>
	            <groupId>org.springframework.cloud</groupId>
	            <artifactId>spring-cloud-gateway</artifactId>
	            <version>1.0.1.RELEASE</version>
	            <type>pom</type>
	            <scope>import</scope>
	        </dependency>
	    </dependencies>
	</dependencyManagement>
```
又发现spring-cloud-starter-gateway不能用，还是暂时搁置。