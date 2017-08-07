# SpringBlog

****

## 简介
  在 PenBlog 项目开发接近完成之时，其 Spring Framework 
版本也开始开发，所以， SpringBlog 即是 PenBlog 的 
Spring 框架版。

## URL

  GET:/,/home -- 网站主页
  
## 更新

### 20170807
  * 修复注册表单验证失效 bug 。

### 20170806
  * 添加 User 控制器和服务。
  * 添加用户注册、更新功能。
  * 修复部分 bug 。
  * 存在注册表单验证失效 bug 。

### 20170805
  * 配置数据源。
  * 配置 Spring Jdbc Template 作为 JDBC 模板，操作数据的样板代码。
  * 配置 User 域的 DAO 层。
  * 添加页面的基础布局。

### 20170804
  * 搭建项目框架
  * 模板技术采用 Thymeleaf 。
  * 使用 Thymeleaf 的扩展方言 thymeleaf-layout-dialect 作为布局方案。