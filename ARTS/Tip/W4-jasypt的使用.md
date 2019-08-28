
# jasypt库的使用 

## 1.简介
Jasypt是一个Java简易加密库，用于加密配置文件中的敏感信息，如数据库密码。jasypt库与springboot集成，在实际开发中非常方便。

## 2.添加依赖
jasypt开发者开发了starter，添加jasypt-spring-boot-starter依赖就可以了。该库中有使用到slf4j依赖，若单独测试，需添加相应依赖，或直接添加spring-boot-starter依赖。
```xml
    <dependency>
        <groupId>com.github.ulisesbocchio</groupId>
        <artifactId>jasypt-spring-boot-starter</artifactId>
        <version>2.1.0</version>
    </dependency>
```

## 3.添加注解
在Application应用类上添加注解
>@EnableEncryptableProperties
启用jasypt。

## 4.配置使用
将加密后的配置信息使用ENC函数，添加到配置文件中，应用启动加载配置文件时，会自动解密。
Jasypt默认使用的算法为`PBEWithMD5AndDES`，该算法需要一个加密密钥，可以在应用启动时指定。也可以直接写入配置文件，安全性稍差。
```yml
jasypt:
  encryptor:
    password: password
```

## 5.测试示例
### 5.1 准备工作
添加依赖，应用类添加注解。

### 5.2 添加加密后的属性配置
在配置文件中加入加密后的属性配置信息，我们加密了字符串`Password@1`,使用的加密密钥为password，添加到application.yml文件中。
```yaml
jasypt:
  encryptor:
    password: password

encrypted:
  property: ENC(uTSqb9grs1+vUv3iN8lItC0kl65lMG+8)
```
### 5.3 添加属性解析类
添加一个类，加载配置文件中的配置信息。
```java
@Service
public class PropertyServiceForJasyptStarter {

	@Value("${encrypted.property}")
	private String property;

	public String getProperty() {
		return property;
	}

	public String getPasswordUsingEnvironment(Environment environment) {
		return environment.getProperty("encrypted.property");
	}
}
```

### 5.4 添加测试函数
```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class JasyptSimpleIntegrationTest {

	@Autowired
	PropertyServiceForJasyptStarter service;

	@Autowired
	Environment environment;

	@Test
	public void whenDecryptedPasswordNeeded_GetFromService() {
		System.out.println("service.getProperty() = " + service.getProperty());

		System.out.println("service = " + service.getPasswordUsingEnvironment(environment));
	}
	
	/**
     * 生成加密密文
     * 每次加密后密文不一样
     */
    @Test
    public void testPBECli(){
        String[] args = {"input='Password@1",
                "password=password", "algorithm=PBEWithMD5AndDES"};
        JasyptPBEStringEncryptionCLI.main(args);
    }
}
```

执行结果如下：
>service.getProperty() = Password@1
>service = Password@1


## 6、加密函数
```
public static void main(String[] args) {
    // 创建加密对象，默认 PBEWithMD5AndDES
    BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
    // 加密所需的密钥
    textEncryptor.setPassword("password");
    // 加密后的数据（数据库的用户名或密码）
    String encData = textEncryptor.encrypt("Password@1");
    // 解密后的数据（原数据）
    String decData = textEncryptor.decrypt(encData);
    System.out.println("encData: " + encData);
    System.out.println("decData: " + decData);
}
```
输出：
```
encData: uK6xyed60q9NlSBAVb0pFyxA23TYFgtQ
decData: Password@1
```
