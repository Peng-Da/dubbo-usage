# dubbo-usage
本项目展示使用dubbo+nacos实现分布式系统的搭建
系统架构：
一个分布式系统架构最基础的组件包括rpc远程过程调用和服务注册发现中心
- rpc：dubbo
- 服务注册发现：nacos

单个服务架构：
springboot+jooq+postgresql
采用了flyway工具做数据库迁移

业务：
本项目包含两个应用：comment（评论），text-detection（敏感词检测），在分布式系统中对应两个service（服务），实现了基本的功能
text-detection -- 维护敏感词库，对外提供检测接口
comment -- 提供评论的crud，在添加内容时调用敏感词服务进行敏感内容处理

环境搭建：
1.安装postgresql，并创建用户及database
2.安装nacos服务端，并运行
3.idea分别导入comment和text-detection项目，修改对应的数据库及nacos参数
4.运行单个应用的XXApplication，代码中调用了flyway会在对应database生成src/main/resource/db/migration中sql文件定义的表格， 然后执行gradle generatJooq 会生成对应的java文件
