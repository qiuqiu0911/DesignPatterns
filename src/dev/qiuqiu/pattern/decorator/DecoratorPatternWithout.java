package dev.qiuqiu.pattern.decorator;

/**
 * 原场景下
 * 咖啡店的饮料类
 * 每种饮料都会创建一个类，每个cost()方法计算出咖啡和订单上各种调料的价钱,形成"类爆炸"
 * 如果在Beverage基类中加入新功能，并不适用于所有的子类
 */
public class DecoratorPatternWithout {
    public static void main(String[] args) {
        Beverage beverage = new HouseBlend();
        System.out.println("HouseBlend cost :" + beverage.cost());
    }
}

abstract class Beverage {
    String description = "unknown beverage";

    public String getDescription() {
        return description;
    }

    public abstract float cost();
}

class HouseBlend extends Beverage {

    String milkPrice = "$2";

    @Override
    public float cost() {
        System.out.println(HouseBlend.class.toGenericString() + " costs $10 ");
        return 10.0f;
    }
}

class DarkBlend extends Beverage {

    @Override
    public float cost() {
        System.out.println(DarkBlend.class.toGenericString() + " costs $11");
        return 11.0f;
    }
}

class Decaf extends Beverage {

    @Override
    public float cost() {
        System.out.println(Decaf.class.toGenericString() + " costs $12");
        return 12.0f;
    }
}