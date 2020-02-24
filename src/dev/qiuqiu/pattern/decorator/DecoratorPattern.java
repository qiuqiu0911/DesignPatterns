package dev.qiuqiu.pattern.decorator;

/**
 * 装饰者模式：动态的将责任附加到对象上。
 * 若要扩展功能，装饰者提供了比继承更有弹性的替代方案
 */
public class DecoratorPattern {
    public static void main(String[] args) {
        Beverage beverage = new DarkRoast();
        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);
        System.out.println("total description:" + beverage.getDescription());
        System.out.println("total cost:" + beverage.cost());
    }
}

class DarkRoast extends Beverage {

    public DarkRoast(){
        description = "darkRoast";
    }
    @Override
    public float cost() {
        System.out.println(DarkRoast.class.toGenericString() + " cost $5");
        return 5;
    }
}

abstract class CondimentDecorator extends Beverage {

    public abstract String getDescription();

    @Override
    public float cost() {
        return 0;
    }
}

class Mocha extends CondimentDecorator {

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return "mocha decorator," + beverage.getDescription();
    }

    @Override
    public float cost() {
        System.out.println(Mocha.class.toGenericString() + " cost $6 extra");
        return 6 + beverage.cost();
    }
}


class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return "whip decorator," + beverage.getDescription();
    }

    @Override
    public float cost() {
        System.out.println(Whip.class.toGenericString() + " cost $7 extra");
        return 7 + beverage.cost();
    }
}