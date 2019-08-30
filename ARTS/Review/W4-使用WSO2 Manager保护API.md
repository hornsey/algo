
## 使用WSO2 API Manager保护API

[Securing APIs with WSO2 API Manager](https://wso2.com/library/articles/2018/07/securing-apis-with-wso2-api-manager/?utm_source=infoq&utm_medium=resources&utm_campaign=ping_wso2_apim_2019)

文件描述了企业提供公开API服务可能遇到的问题，以及使用WSO2 API Manager来保护API。

API驱动的业务模型在当前的商业世界发挥越来越大的作用，有不少企业正提供公开API服务。
公开API服务通常需要解决以下问题：
 * 身份认证
 * 授权
 * 安全性（机密性、完整性、不可否认性）
WSO2 API Manager可以解决这些问题，保护API。 
 
### 传输层安全性 
WSO2 API Manager可以提供开箱即用的传输层安全性。可以轻松配置禁用SSL，启用TLS。SSl协议存在漏洞，可能暴露客户端和服务器之前加密的安全数据。而TLS协议使用改进的加密算法可以提供安全性。
此外，WSO2 API Manager 可以配置为禁用弱密码，防止系统遭到攻击。也支持在HTTP响应头中更改服务器名称。

### 支持OAuth2
OAuth2是一个访问委派的开放标准，很多企业如Google、Facebook、Twitter都支持此标准。OAuth2授予消费者一个访问令牌，凭借令牌访问资源，令牌有一个生命周期，到期后消费者必选刷新令牌。WSO2 API Manager的密钥管理器组件可以生成令牌并验证。另外，也可以插入第三方服务器进行密钥验证。

### 授予类型
WSO2 API Manager支持多种授权类型，如果需要，也可以定义其他类型。授权类型包括：
* 授权代码授予。对客户端身份验证后直接将访问令牌发送到客户端。
* NTLM 授予。NTLM是微软专有的身份验证协议。使用质询-响应机制进行身份验证。提供身份验证、机密性和完整性，支持单点登录。
* 密码授予。客户端询问资源所有者的用户名密码，连同自身凭证发送到授权服务器。客户端消费时，向授权服务器发送一个调用。
* SAML扩展资助。
* 客户凭证授权。
* Kerberos OAuth2 授予。这是支持操作系统和开源发行版的安全协议。
* 刷新令牌授权。令牌要过期时请求刷新令牌。
 