package java8;

public class LambdaDemo1 {

    @FunctionalInterface
    interface Printer{
        void printer(String val);

        //定义接口 不用实现
        default void pp(){
            System.out.println("pppp");
        }
    }

    public void pringSomething(String something,Printer printer){
        printer.printer(something);
    }

    public static void main(String[] args) {
        LambdaDemo1 lambdaDemo1=new LambdaDemo1();
        String some="aaa";
/*        Printer printer=new Printer() {
            @Override
            public void printer(String val) {
                System.out.println(val);
            }
        };*/

//        Printer printer=(String val)->{
//            System.out.println(val);
//        };

//        Printer printer=(val)->{
//            System.out.println(val);
//        };
        //只有一个参数可以简化
//        Printer printer=val->{
//            System.out.println(val);
//        };

//        Printer printer=val->System.out.println(val);



        Printer p=new Printer() {
            @Override
            public void printer(String val) {

            }
            //非必须实现类
            @Override
            public void pp(){

            }
        };

//        lambdaDemo1.pringSomething(some,printer);

        lambdaDemo1.pringSomething(some,val->System.out.println(val));

        //不含参数
//        ()-> System.out.println("")

    }
}
