Comment
===============

评论

### Q&A
+ springboot项目是否必须引入spring-boot-starter-web(非web应用) ?  
非必要，只要包含对应的依赖就行，比如org.springframework.boot:spring-boot-starter-jooq
+ gitignore 最佳实践？  
先创建.gitignore文件，ignore本地环境相关的文件，后初始化git仓库
+ dubbo 生产者service实现的interface增加新的method，依赖interface的消费者service是否需要同步更新依赖？

+ 消费者通过注解@DubboReference引用生产者，version属性什么含义如何使用？



### todos  
- 对外提供的：增删改查
- 对管理系统提供的：查询，隐藏/显示
