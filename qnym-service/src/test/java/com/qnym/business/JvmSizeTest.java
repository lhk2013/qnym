package com.qnym.business;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JvmSizeTest {

    @Test
    public void  testSize(){

//        System.out.println(ClassLayout.parseClass(Object.class).toPrintable());
//        System.out.println(ClassLayout.parseClass(Fruit.class).toPrintable());
        System.out.println(ClassLayout.parseClass(A.class).toPrintable());
        System.out.println(ClassLayout.parseClass(B.class).toPrintable());
        System.out.println(ClassLayout.parseClass(SignInfo.class).toPrintable());
        B b = new B();
        System.out.println(b);

    }


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            newApple();
        }
        System.out.println("take time:" + (System.currentTimeMillis() - startTime) + "ms");
    }

    public static void newApple() {
        new Apple();
    }


    @Test
    public void  testSize2()throws Exception{

        System.out.println(ClassLayout.parseClass(Object.class).toPrintable());
        System.out.println(ClassLayout.parseClass(Fruit.class).toPrintable());
        System.out.println(ClassLayout.parseClass(WechartFriend.class).toPrintable());
        List<WechartFriend> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            WechartFriend f = new WechartFriend();
            list.add(f);
            f.setNickName(f.hashCode()+"");
//            Thread.sleep(1L);
            System.out.println("当前:"+i);
            if(i==50000){
                System.out.println(50000);
            }
        }
        System.out.println(11111);

        Set<String> os = new HashSet<>();

        os.add("1");
        os.add("2");
        os.add("3");
        os.add("4");
        os.add("5");
        os.add("6");

        Set<String> ns = new HashSet<>();
        ns.add("2");
        ns.add("3");
        ns.add("4");
        ns.add("5");
        ns.add("7");
        ns.add("9");
        ns.add("10");


        ns.retainAll(os);

        System.out.println("12334".matches("\\d+"));

        System.out.println(String.format("接收者:%s 的归属是 %s 不是 发送者:%s 好友",1,2,3));


        List<Long> fids = new ArrayList<>();
        fids.add(2L);fids.add(3L);
        String [] fidArr = (String[]) ConvertUtils.convert(fids, String[].class);
        System.out.println(fidArr);
        System.out.println(111);

        String[] arr = new String[20];
        arr[0]= "111";
        System.out.println(arr);

        List<WechartFriend> listWF = new ArrayList<>();

        System.out.println(ClassLayout.parseClass(WechartFriend.class).toPrintable());

        System.out.println(ClassLayout.parseInstance(listWF).toPrintable());

        for (int i = 0; i < 2; i++) {
            WechartFriend f = new WechartFriend();
            listWF.add(f);
            f.setId(Long.valueOf(i));
            f.setNickName(f.hashCode()+"");
            System.out.println("当前当前当前当前当前当前当前当当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前当前前当前:"+i);
            if(i==5000){
                System.out.println(5000);
            }
            System.out.println(ClassLayout.parseInstance(f).toPrintable());
            System.out.println(GraphLayout.parseInstance(f).toPrintable());

        }
        System.out.println(ClassLayout.parseInstance(listWF).toPrintable());


        String ss = "import com.gangling.middleware.file.interf.UploadResult;";

        FruitApple fruit =  new FruitApple();
        fruit.setSize(10);
        fruit.setName(ss);
        System.out.println(ClassLayout.parseInstance(fruit).toPrintable());
        System.out.println(ClassLayout.parseInstance(ss).toPrintable());
        char[] carr = new char[]{'一','二','三','四','五','六','七'};
        System.out.println(ClassLayout.parseInstance(ss.toCharArray()).toPrintable());
        System.out.println(ClassLayout.parseInstance(carr).toPrintable());


        System.out.println(StringUtils.isEmpty("sdf  f"));

    }

}
