# PConnect
这是一个耍java的项目

## 参考资料
Spring guides：https://spring.io/guides

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