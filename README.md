# SpringBlog

****

## 简介
  在 PenBlog 项目开发接近完成之时，其 Spring Framework 
版本也开始开发，所以， SpringBlog 即是 PenBlog 的 
Spring 框架版。

## URL

  GET:/,/home -- 网站主页
  
  
  GET:/user/list -- 用户列表
  
  GET:/user/delete/{userId} -- 删除用户，{userId}为用户Id
  
  GET:/user/register -- 用户注册视图
  
  POST:/user/register -- 用户注册提交
  
  GET:/user/profile/{userId} --  用户个人详情，{userId}为用户Id
  
  POST:/user/update/nickname/{userId} -- 用户昵称修改提交，{userId}为用户Id
  
  POST:/user/update/sex/{userId} -- 用户性别修改提交，{userId}为用户Id
  
  
  
## 更新

### 20170809
  * 完成用户头像修改功能

### 20170808
  * 修复邮箱重复注册 bug 。
  * 优化部分视图。
  * 添加用户部分属性更新功能。

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