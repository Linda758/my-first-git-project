package com.example.helloworld;

/**
 * HelloWorld应用程序主类
 * 这是一个简单的Java控制台程序，演示Maven项目的基本结构
 */
public class App {
    
    /**
     * 主方法 - 程序入口点
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 输出Hello World消息
        System.out.println("Hello, World!");
        
        // 如果有命令行参数，显示参数信息
        if (args.length > 0) {
            System.out.println("命令行参数:");
            for (int i = 0; i < args.length; i++) {
                System.out.println("  args[" + i + "] = " + args[i]);
            }
        } else {
            System.out.println("没有提供命令行参数");
        }
        
        // 显示当前Java版本信息
        System.out.println("Java版本: " + System.getProperty("java.version"));
        System.out.println("程序执行完成！");
    }
    
    /**
     * 返回欢迎消息
     * @return 欢迎消息字符串
     */
    public static String getWelcomeMessage() {
        return "Hello, World from Maven Java Project!";
    }
    
    /**
     * 返回带有自定义名称的欢迎消息
     * @param name 用户名称
     * @return 个性化的欢迎消息
     */
    public static String getPersonalizedWelcome(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "Hello, World!";
        }
        // 去除名称两端的空格
        return "Hello, " + name.trim() + "! Welcome to Java Maven Project!";
    }
}