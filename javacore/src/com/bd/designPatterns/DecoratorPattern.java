package com.bd.designPatterns;

/**
 * @program: javacore
 * @description: 装饰器模式
 * @author: Mr.zhang
 * @create: 2019-08-28 17:19
 **/
public class DecoratorPattern {
    public static void main(String[] args) {
        Component c = new ComponentImp();
        RealDecorator realDecorator = new RealDecorator(c);
        realDecorator.operation();
    }
}

interface Component {
    void operation();
}

class ComponentImp implements Component {
    @Override
    public void operation() {
        System.out.println("实际操作");
    }
}

abstract class Decorator implements Component {
    Component c;
    public Decorator() {}
}

class RealDecorator extends Decorator {
    public RealDecorator(Component c) {
        this.c = c;
    }

    @Override
    public void operation() {
        System.out.println("装饰器下");
        c.operation();
        System.out.println("装饰器下");
    }
}
