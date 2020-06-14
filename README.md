## MALL（funny商城）
一个基于SSM架构的电商项目（后端部分）

### 项目结构
项目共分为6个模块：

- 用户模块
- 商品分类模块
- 商品管理模块
- 购物车模块
- 收货地址模块
- 支付模块（支付宝沙箱环境）
- 订单管理模块

### 项目环境
- 操作系统：开发系统Windows10，阿里服务器Centos7
- IDEA：Intellij IDEA 2019.3
- JDK：JDK1.8
- Maven：Maven 3.5.4
- Spring : Spring5.2.1
- mybatis：mybatis 3.5.6
- mybatis-spring: 1.3.2
- Restlet Client：接口测试
- Ftp服务器：vsftpd
- 内网穿透工具：natapp
- 数据库：MySQL5.5
- 域名映射&本地目录转发：nginx
- 支付宝SDK&Demo：项目依赖的支付宝SDK [下载地址](https://docs.open.alipay.com/54/103419/) 

### 参考资料
- 项目中使用到的配置文件、sql语句等 [参考文件](https://github.com/PJB0911/funnymall/tree/master/参考文件)
- Restlet Client所有测试接口导出json文件： [mall.restlet.json](https://github.com/PJB0911/funnymall/blob/master/%E5%8F%82%E8%80%83%E6%96%87%E4%BB%B6/mall.restlet.json)

### 接口文档

所有接口均使用Restlet Client测试通过，具体 [接口文档](https://github.com/PJB0911/funnymall/tree/master/接口文档)

### 项目总结


#### （一）开发环境及配置

**vsftpd服务器搭建**
项目中使用vsftpd搭建一个ftp服务器，通过springmvc上传图片到tomcat容器然后再上传到ftp服务器，用于存放产品的主图（mainImage）、子图（subImages）以及扫码支付过程中生成的订单二维码，前端通过访问该ftp服务器，拿到对应的产品图片及支付订单二维码，进行相应显示、回调。

vsftpd服务器搭建过程参考文章：https://blog.51cto.com/andyxu/2168875 

项目中vsftpd配置文件参考： [vsftpd.conf](https://github.com/PJB0911/funnymall/blob/master/参考文件/vsftpd.conf)

**nginx：域名映射和本地目录转发**

首先需要购买一个域名并且备案，阿里云上购买即可。将项目打包部署到阿里云服务器上时，需要使用nginx将备案域名映射到本地服务器ip上。
同时，前端获取vsftpd上的图片的地址，也需要使用nginx进行本地目录转发，转发到阿里云服务器本地磁盘上。

在nginx安装目录的conf下新建一个vhost目录，并且在默认的配置文件nginx.conf中加入：include vhost/*.conf，在vhost目录下创建两个配置文件：

域名映射参考配置文件: [www.funnymall.com.conf](https://github.com/PJB0911/funnymall/blob/master/参考文件/www.funnymall.com.conf)

本地目录转发参考配置文件: [img.funny.com.conf](https://github.com/PJB0911/funnymall/blob/master/参考文件/img.funnymall.com.conf)

**内网穿透工具natapp**
支付宝支付模块中，对订单二维码扫描支付时，支付宝会回调对应的回调接口，可以采用远程debug方式或者使用内网穿透，本项目使用内网穿透。
开发阶段使用内网穿透，项目部署时，将对应的回调地址改成线上实际的回调接口。项目中使用natapp作为内网穿透工具。

**支付宝SDK**
支付宝SDK的jar文件下载完成后，需要在web/WEB-INF目录下创建一个lib文件夹，加入alipay的SDK及源码jar文件，
同时在pom.xml中引入maven插件，以便在项目部署时可以找到这些jar文件
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <configuration>
        <source>1.8</source>
        <target>1.8</target>
        <encoding>UTF-8</encoding>
        <compilerArguments>
            <extdirs>${project.basedir}/src/main/web/WEB-INF/lib</extdirs>
        </compilerArguments>
    </configuration>
</plugin>
```

**其它环境配置**
其它项目配置包括Centos7上配置JDK、MySQL、Maven等，参考相关教程

#### （二）数据库表设计
数据库表对应sql文件参考： [mall.sql](https://github.com/PJB0911/funnymall/blob/master/参考文件/mall.sql)

#### （三）用户模块
**目标**
- 横向越权、纵向越权安全漏洞
- MD5明文加密&salt
- Guava缓存：用户忘记密码时需要携带一个包含有效期的token进行密码重置（Guava真的很好用！）。
  本项目未使用redis，后续开发可引入。
- 封装一个高可用的相应对象

**功能**
- 用户登录、注销
- 用户名、手机、邮箱有效性验证
- 忘记密码-提交问题答案-重置密码、登录状态下重置密码
- 获取、更新用户信息

**对应接口测试文档**
- [门户用户模块](https://github.com/PJB0911/funnymall/blob/master/接口文档/门户接口/门户_用户模块.md)
- [后台用户模块](https://github.com/PJB0911/funnymall/blob/master/接口文档/后台接口/后台_用户模块.md)

#### （四）分类管理模块
**目标**
- 设计和封装无限层级的树状数据结构：分类管理时通常根据某一分类id递归查询该分类的所有子分类id
- 复杂对象的排重：在使用到散列表相关数据结构时需要重写hashcode和equals方法0

**功能**
- 获取、增加分类节点
- 修改分类节点名称
- 获取给定分类id的下一层分类id
- 递归获取给定分类id的所有子分类id

**对应接口测试文档**
- [后台分类管理模块](https://github.com/PJB0911/funnymall/blob/master/接口文档/后台接口/后台_分类管理模块.md)

#### （五）商品管理模块
**目标**
- ftp服务器对接：FTPClient类的使用及封装
- SpringMVC文件上传
- Properties配置文件配置读取工具类的封装
- POJO、BO、VO对象之间的转换关系和解决思路

**功能**
- 增加商品、显示商品详情、搜索商品以及显示所有商品列表
- 商品图片上传以及富文本文件上传
- 商品上下架

**对应接口测试文档**
- [门户商品管理模块](https://github.com/PJB0911/funnymall/blob/master/接口文档/门户接口/门户_商品管理模块.md)
- [后台商品管理模块](https://github.com/PJB0911/funnymall/blob/master/接口文档/门户接口/门户_商品管理模块.md)

### （六）购物车模块
**目标**
- 购物车模块的设计思想
- 封装一个高复用的购物车核心方法
- 使用BigDecimal解决商业运算浮点数丢失精度问题，可以将价格单位设置为分，直接使用long类型

**功能**
- 增加购物车商品、更新购物车中商品数量、查询购物车中商品数量、移除购物车中商品
- 显示购物车中所有商品列表
- 单选、取消选择购物车中商品
- 全选、全不选购物车中商品

**对应接口测试文档**
- [门户购物车模块](https://github.com/PJB0911/funnymall/blob/master/接口文档/门户接口/门户_购物车模块.md)

### （七）收货地址模块
**目标**
- SpringMVC数据绑定中对象绑定
- mybatis自动生成主键的配置和使用
- 横向越权漏洞避免

**功能**
- 添加地址、删除地址、更新地址、地址分页以及地址详情

**对应接口测试文档**
- [门户收货地址模块](https://github.com/PJB0911/funnymall/blob/master/接口文档/门户接口/门户_收货地址模块.md)

### （八）支付&订单模块
**目标**
- 支付宝沙箱环境的使用、配置和参考文档以及支付的生命周期流程图
- 支付宝SDK、官方demo、支付模块整合实现及回调接口逻辑注意事项
- 订单模块需要避免横向越权安全漏洞
- 设计高可用、可拓展的常量、枚举类
- 订单号生成规则、订单严谨性判断

**功能**
- 前台：创建订单、取消订单、订单详情、订单分页列表
- 后台：所有订单分页列表、订单搜索、订单详情
- 支付宝沙箱环境扫码支付和回调接口设计以及订单支付状态查询

**对应接口测试文档**
- [门户订单模块](https://github.com/PJB0911/funnymall/blob/master/接口文档/门户接口/门户_订单模块.md)
- [后台订单模块](https://github.com/PJB0911/funnymall/blob/master/接口文档/后台接口/后台_订单模块.md)
- [门户支付模块](https://github.com/PJB0911/funnymall/blob/master/接口文档/门户接口/门户_支付模块.md)

### 后续开发
- 开发SpringBoot版电商项目
- [架构演进:Tomcat集群+Nginx负载均衡+Redis分布式](https://github.com/PJB0911/funnymall-ii)
