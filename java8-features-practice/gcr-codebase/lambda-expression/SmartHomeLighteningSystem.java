package lamdaexpression;

public class SmartHomeLighteningSystem {

    @FunctionalInterface
    interface LightAction {
        void execute();
    }

    static class SmartLight {
        void activate(LightAction action) {
            action.execute();
        }
    }

    public static void main(String[] args) {

        SmartLight light = new SmartLight();

        light.activate(() ->
                System.out.println("Motion detected → Lights ON at full brightness")
        );

        light.activate(() ->
                System.out.println("Night time → Lights ON at 30% warm light")
        );

        light.activate(() ->
                System.out.println("Voice command received → Blue ambient lights activated")
        );
    }
}