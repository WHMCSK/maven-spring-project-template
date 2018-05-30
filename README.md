# PConnect
这是一个耍java的项目

## 参考资料
Spring guides：https://spring.io/guides

## 编译打包
使用maven编译打包，打成war包，可以直接用java -jar PConnect*.war启动自服务运行，或者讲war包放在tomcat下运行都行，请使用tomcat9+.


## 使用的技术参考

* spring mvc
* hibernate
* mysql
* OrientDB图库
* TinkerPop3

## 关于如何连接OrientDB

经过一番折磨，终于敲定了使用TinkerPop3 Java (native) API to work with OrientDB。

心路：
```
罪过罪过，一开始想着spring的便利，就想用OrientDB Spring Data，想着这个可能会更偷懒，但是没想到，这东东把源码下载下来折腾了两个小时，硬是没办法把源码运行起来，最后只能省省用java api，没想到当我看到java api的代码的一瞬间，感觉前面花的时间白费了，这个java api真好用的感觉。
```

## 关于Spring cloud

心路：
```
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
```

