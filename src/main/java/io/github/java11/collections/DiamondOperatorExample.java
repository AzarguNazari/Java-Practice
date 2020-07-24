package io.github.java11.collections;

public class DiamondOperatorExample {

    static abstract class MyHandler<T> {

        private T content;

        public MyHandler(T content) {
            this.content = content;
            System.out.println("content : " + content.toString());
        }

        public T getContent() {
            return content;
        }

        public void setContent(T content) {
            this.content = content;
        }

        abstract void handle();
    }

    public static void main(String[] args) {
        MyHandler<Integer> intHandler = new MyHandler<>(1) {
            @Override
            public void handle() {
                System.out.println("printhere > " + getContent());
            }
        };
        intHandler.handle();

        System.out.println("===================================");

        MyHandler<? extends Integer> intHandler1 = new MyHandler<>(10) {
            @Override
            void handle() {
                System.out.println(" " + getContent() );
            }
        };
        intHandler1.handle();

        System.out.println("====================================");

        MyHandler<?> handler = new MyHandler<>("new handler") {
            @Override
            void handle() {
                System.out.println("content [" + getContent() + "] content");
            }
        };
        handler.handle();

    }

}
