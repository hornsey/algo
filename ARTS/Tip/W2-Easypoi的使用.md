# Easypoi使用

## 简介
在项目中，有时会出现需要将数据库数据导出报表等功能，这时一般会用到poi库。poi是一个专门给Java程序提供格式文档读写功能的API接口，包括各种微软的格式文档入excel、word等。最常用的还是Excel格式导入导出。
Easypoi是在poi接口基础上进行了封装，简化了操作。
使用Easypoi导出仅需以下几步：
1. 添加依赖项
2. 改造模型，添加注解
3. 从数据库查询数据，使用Easypoi工具类生成Workbook对象，存储为文件（导出）。


## 添加依赖项
```xml
<dependency>
	<groupId>cn.afterturn</groupId>
	<artifactId>easypoi-base</artifactId>
	<version>3.2.0</version>
</dependency>
<dependency>
	<groupId>cn.afterturn</groupId>
	<artifactId>easypoi-web</artifactId>
	<version>3.2.0</version>
</dependency>
<dependency>
	<groupId>cn.afterturn</groupId>
	<artifactId>easypoi-annotation</artifactId>
	<version>3.2.0</version>
</dependency>
```

## 模型添加注解
Easypoi注解包含下面几类
* Excel 这个是最基本常用的注解，注解在模型字段上，可添加列名、列的排序、列宽、格式等属性
* ExcelTarget 用于外层的模型实体，可注解行高、字体大小等属性
* ExcelEnity  用于标记实体内部类是否继续穿透
* ExcelCollection 用于注解集合字段
* ExcelIgnore 忽略这个属性

示例：
```java
public class StudentEntity implements java.io.Serializable {
    /**
     * id
     */
	@ExcelIgnore 
    private String        id;
	
    /**
     * 学生姓名
     */
    @Excel(name = "学生姓名", height = 20, width = 30, isImportField = "true_st")
    private String        name;
    /**
     * 学生性别
     */
    @Excel(name = "学生性别", replace = { "男_1", "女_2" }, suffix = "生", isImportField = "true_st")
    private int           sex;

    @Excel(name = "出生日期", databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd", isImportField = "true_st", width = 20)
    private Date          birthday;

    @Excel(name = "进校日期", databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd")
    private Date registrationDate;

 }

```

## 生成Workbook对象
```java
Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生"),
            StudentEntity .class, list);
```

参考：[EasyPos教程](https://easypoi.mydoc.io/#category_50222)

















