package com.example.helloworld;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * App类的单元测试
 */
public class AppTest {
    
    /**
     * 测试getWelcomeMessage方法
     */
    @Test
    public void testGetWelcomeMessage() {
        String message = App.getWelcomeMessage();
        assertNotNull("欢迎消息不应为null", message);
        assertTrue("欢迎消息应包含'Hello'", message.contains("Hello"));
        assertTrue("欢迎消息应包含'World'", message.contains("World"));
        assertEquals("Hello, World from Maven Java Project!", message);
    }
    
    /**
     * 测试getPersonalizedWelcome方法 - 正常名称
     */
    @Test
    public void testGetPersonalizedWelcomeWithName() {
        String message = App.getPersonalizedWelcome("Alice");
        assertNotNull("个性化欢迎消息不应为null", message);
        assertTrue("消息应包含名称", message.contains("Alice"));
        assertEquals("Hello, Alice! Welcome to Java Maven Project!", message);
    }
    
    /**
     * 测试getPersonalizedWelcome方法 - 空名称
     */
    @Test
    public void testGetPersonalizedWelcomeWithEmptyName() {
        String message = App.getPersonalizedWelcome("");
        assertEquals("空名称应返回默认欢迎消息", "Hello, World!", message);
        
        message = App.getPersonalizedWelcome(null);
        assertEquals("null名称应返回默认欢迎消息", "Hello, World!", message);
    }
    
    /**
     * 测试getPersonalizedWelcome方法 - 带空格名称
     */
    @Test
    public void testGetPersonalizedWelcomeWithSpaces() {
        String message = App.getPersonalizedWelcome("  Bob  ");
        assertTrue("消息应包含名称Bob", message.contains("Bob"));
        assertEquals("Hello, Bob! Welcome to Java Maven Project!", message);
    }
    
    /**
     * 基本断言测试
     */
    @Test
    public void testBasicAssertions() {
        // 基本断言示例
        assertTrue(true);
        assertFalse(false);
        assertEquals(4, 2 + 2);
        assertNotEquals(5, 2 + 2);
    }
    
    /**
     * 测试main方法 - 通过捕获输出
     * 注意：这是一个简单的测试，实际中可能需要使用System Rules库
     */
    @Test
    public void testMainMethod() {
        // 这里我们只是验证main方法可以无错误执行
        // 在实际项目中，可以使用System Rules或Mockito来测试控制台输出
        try {
            App.main(new String[]{});
            // 如果没有异常，测试通过
            assertTrue(true);
        } catch (Exception e) {
            fail("main方法不应抛出异常: " + e.getMessage());
        }
    }
    
    /**
     * 测试main方法带参数
     */
    @Test
    public void testMainMethodWithArgs() {
        try {
            App.main(new String[]{"arg1", "arg2"});
            // 如果没有异常，测试通过
            assertTrue(true);
        } catch (Exception e) {
            fail("main方法带参数不应抛出异常: " + e.getMessage());
        }
    }
}