# SpringBlog

****

## 简介
  在 PenBlog 项目开发接近完成之时，其 Spring Framework 
版本也开始开发，所以， SpringBlog 即是 PenBlog 的 
Spring 框架版。

## URL

  (ALL)GET:/,/home -- 网站主页
  
  
  (ADMIN)GET:/user/list -- 用户列表
  
  (ADMIN)GET:/user/delete/{userId} -- 删除用户，{userId}为用户Id
  
  (ALL)GET:/user/register -- 用户注册视图
  
  (ALL)POST:/user/register -- 用户注册提交
  
  (ALL)GET:/user/login -- 用户登录视图
  
  (ALL)POST:/user/login -- 用户登录提交
  
  (AUTHENTICATED)POST:/user/logout -- 用户注销提交
  
  (AUTHENTICATED)GET:/user/profile --  用户个人详情
  
  (AUTHENTICATED)POST:/user/update/nickname -- 用户昵称修改提交
  
  (AUTHENTICATED)POST:/user/update/sex -- 用户性别修改提交
  
  (AUTHENTICATED)POST:/user/update/head_image -- 用户头像修改提交
  
  
  (ALL)GET:/passage/category/{category_id}  -- 属于 categoryId 的文章列表，{categoryId}文章类别的id
  
  (ADMIN)POST:/passage/category/add -- 添加文章类别提交
  
## 更新

### 20170814
  * 实现文章添加功能和前端渲染
  * 实现文章查看功能和前端渲染
  * 需求功能基本实现，开发接近完成

### 20170812
  * 实现文章分类功能

### 20170810
  * 添加 Spring Security 安全机制
  * 采用 SpringSecurityDialect 方言保护视图

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