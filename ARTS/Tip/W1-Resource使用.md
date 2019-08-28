# Resource接口

## 1、Spring对应Resource接口实现类
- ClassPathResource
- FileSystemResource
- URLResource
- ByteArrayResource
- ServletContextResource
- InputStreamResource

## 2、Resource接口支持的方法
exists
isReadable
isOpen
getURL
getFile
getInputStream

## 3、获取Resource
### 1）使用查找器
```
// 设置查找器 
PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(); 
// 自动扫描mybatis文件 
sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
```

### 2）ResourceLoader 
```java
 ResourceLoader loader = new DefaultResourceLoader();  
 Resource resource = loader.getResource("http://www.google.com.hk");  
```

### 3）通过ApplicationContext的getResource
```java
ApplicationContext context = new ServletWebServerApplicationContext();
Resource[] resources = new Resource[]{context.getResource("classpath:mapper/*.xml")};
sqlSessionFactory.setMapperLocations(resources);
```

















