# HelloWorld Maven Java 项目

这是一个使用Maven构建的简单Java HelloWorld项目，演示了标准的Maven项目结构和基本的Java编程实践。

## 项目概述

- **项目名称**: helloworld
- **GroupId**: com.example
- **ArtifactId**: helloworld
- **版本**: 1.0-SNAPSHOT
- **Java版本**: 1.8 (Java 8)
- **构建工具**: Apache Maven 3.x

## 项目结构

```
helloworld/
├── pom.xml                    # Maven项目配置文件
├── README.md                  # 项目说明文档
├── .gitignore                 # Git忽略文件配置
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/
    │   │       └── example/
    │   │           └── helloworld/
    │   │               └── App.java      # 主应用程序类
    │   └── resources/                    # 资源文件目录
    └── test/
        └── java/
            └── com/
                └── example/
                    └── helloworld/
                        └── AppTest.java  # 单元测试类
```

## 功能特性

1. **HelloWorld程序**: 基本的控制台输出功能
2. **命令行参数支持**: 可以接收和处理命令行参数
3. **Java版本显示**: 显示当前运行的Java版本信息
4. **单元测试**: 包含完整的JUnit测试用例
5. **可执行JAR**: 支持打包为可执行的JAR文件

## 构建和运行

### 前提条件
- Java 8或更高版本
- Apache Maven 3.x

### 常用Maven命令

```bash
# 清理项目
mvn clean

# 编译项目
mvn compile

# 运行单元测试
mvn test

# 打包项目（生成JAR文件）
mvn package

# 运行应用程序
mvn exec:java -Dexec.mainClass="com.example.helloworld.App"

# 清理并打包
mvn clean package
```

### 运行应用程序

1. **使用Maven直接运行**:
   ```bash
   mvn exec:java -Dexec.mainClass="com.example.helloworld.App"
   ```

2. **使用打包的JAR文件运行**:
   ```bash
   # 首先打包项目
   mvn clean package
   
   # 运行生成的JAR文件
   java -jar target/helloworld-1.0-SNAPSHOT.jar
   
   # 或者运行包含依赖的fat jar
   java -jar target/helloworld-1.0-SNAPSHOT-jar-with-dependencies.jar
   ```

3. **带参数运行**:
   ```bash
   java -jar target/helloworld-1.0-SNAPSHOT.jar arg1 arg2 arg3
   ```

## 代码示例

### 主类 (App.java)
```java
package com.example.helloworld;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        // ... 更多代码
    }
}
```

### 运行示例输出
```
Hello, World!
没有提供命令行参数
Java版本: 1.8.0_301
程序执行完成！
```

## 测试

项目包含完整的单元测试，使用JUnit 4.12框架。

运行测试:
```bash
mvn test
```

测试覆盖率报告:
```bash
mvn test jacoco:report
```

## 依赖管理

- **JUnit 4.12**: 单元测试框架
- **Maven编译器插件**: Java 8编译器配置
- **Maven Assembly插件**: 创建可执行JAR文件

## 开发指南

### 扩展项目
1. 在`src/main/java/com/example/helloworld/`目录下添加新的Java类
2. 在`src/test/java/com/example/helloworld/`目录下添加对应的测试类
3. 更新`pom.xml`添加新的依赖（如果需要）

### 代码规范
- 遵循Java编码规范
- 使用有意义的类名和方法名
- 添加必要的注释和文档
- 编写单元测试覆盖主要功能

## 许可证

本项目仅供学习和演示使用。

## 贡献

欢迎提交Issue和Pull Request来改进这个项目。

## 联系方式

如有问题或建议，请通过项目Issue页面提交。