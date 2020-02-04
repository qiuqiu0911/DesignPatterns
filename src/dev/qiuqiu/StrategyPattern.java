package dev.qiuqiu;

/**
 * 策略模式
 * 将鸭子的行为抽象出来
 *
 * 策略模式定义了算法族，分别封装起来，让它们之间可以互相替换。
 * 此模式让算法的变化独立于使用算法的客户。
 *
 * @author qiuqiu
 */
public class StrategyPattern {

    public static void main(String[] args) {
        NormalDuck normalDuck = new NormalDuck();
        normalDuck.fly();
        normalDuck.quack();

        normalDuck.setFlyBehavior(new FlyNoWay());
        normalDuck.fly();
    }
}


class Duck {
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void fly() {
        this.flyBehavior.fly();
    }

    public void quack() {
        this.quackBehavior.quack();
    }
}


class NormalDuck extends Duck {
    public NormalDuck() {
        this.setFlyBehavior(new FlyWithWings());
        this.setQuackBehavior(new Quack());
    }
}

interface FlyBehavior {
    void fly();
}

interface QuackBehavior {
    void quack();
}

class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I can fly with wings!");
    }
}

class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I can not fly!");
    }
}

class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("gua gua");
    }
}

class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {

    }
}


