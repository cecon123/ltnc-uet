public class Hero extends ActionCharacter implements CanFly, CanSwim, CanFight {

    @Override
    public void fly() {
        System.out.println("Hero is flying");
    }

    @Override
    public void swim() {
        System.out.println("Hero is swimming");
    }

    // fight() không cần implement lại vì ActionCharacter đã có fight()
    // ActionCharacter.fight() tự động được dùng làm implementation của CanFight.fight()
}
