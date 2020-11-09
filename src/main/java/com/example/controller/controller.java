package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@ResponseBody
public class controller {
    @RequestMapping("/cal")
    public Double Calculation(@PathParam("url") String url) {
        if(url.charAt((url.length()-1))!='='){
            throw new RuntimeException("字符串结构错误");
        }else if(url.length()==0){
            throw  new RuntimeException("字符串为空");
        }
        String[] strings1 = toArray2(url);
        String[] strings = toArray1(url);
        Double c = calculator(strings, strings1);
        System.out.println("进来了");
        return c;
    }

    //8+4-7*4
    public String[] toArray1(String str) {

        int length = str.length(); //8474
      //  int sub=2;
         int su=0;
         int begin=0;
         int count=0;
         for(int k=0;k<length;k++){
             if (str.charAt(k)=='+'
                     || str.charAt(k)=='-' ||
                     str.charAt(k)=='*' ||
                     str.charAt(k)=='/'||str.charAt(k)=='=');
             count +=1;
         }

        String[] arrays = new String[count ];
        if (str.isEmpty() == true) {
            throw new RuntimeException("没有数字");
        } else {
//            for (int j = 1; j < length-1; j++) { //1/5*8
//                arrays[0]=String.valueOf(str.charAt(0));//1
//                if (str.charAt(j)=='+'
//                        || str.charAt(j)=='-' ||
//                        str.charAt(j)=='*' ||
//                        str.charAt(j)=='/') {
//                    arrays[sub-1] = String.valueOf(str.charAt(j+1));
//                    sub=sub+1;
//                }

        //400-200=
            for (int j=0;j<length;j++){
                if(str.charAt(j)=='+'
                       || str.charAt(j)=='-' ||
                       str.charAt(j)=='*' ||
                     str.charAt(j)=='/'||str.charAt(j)=='='){
                    arrays[su]=str.substring(begin,j);
                    su++;
                    begin=j+1;
                }
            }



        }
        return arrays;
    }

    public String[] toArray2(String str) {
        int length = str.length(); //1/5*8
        int sub = 1;
        int le=0;
        for (int j=0;j<length;j++){
            if (str.charAt(j)=='+'
                    || str.charAt(j)=='-' ||
                    str.charAt(j)=='*' ||
                    str.charAt(j)=='/'){
                le=le+1;
            }
        }
        String[] arrays2 = new String[le ];
        if (str.isEmpty() == true) {
            throw new RuntimeException("没有字符串");
        } else {
            for (int i = 0; i < length; i++) {
                if (str.charAt(i)=='+'
                        || str.charAt(i)=='-' ||
                        str.charAt(i)=='*' ||
                        str.charAt(i)=='/') {
                    arrays2[sub - 1] = String.valueOf(str.charAt(i));
                    sub = sub + 1;
                }
            }

        }return arrays2;
    }

    public Double calculator(String[] array1, String[] array2) {

       int size = array2.length*2;    //   1/5*8 400+200+55+5 1=2 2=4 3=6 4=8
        Stack stack = new Stack(size);
        int le1 = array2.length;
        int o=0;
       Double Result = 0.0;
        stack.push(array1[0]);
        for (int i = 0; i < le1; i++) {
            Double num1 =Double.parseDouble(stack.pop());
            o++;
            stack.push(array1[o]);   // 1
            Double num2 = Double.parseDouble(stack.pop());
            switch (array2[i]) {
                case "+":
                    Result = num1+num2;
                    stack.push(stack.toString(Result));
                    break;
                case "-":
                    Result = num1-num2;
                    stack.push(stack.toString(Result));
                    break;
                case "*":
                    Result = num1 * num2;
                    stack.push(stack.toString(Result));
                    break;
                case "/":
                    Result = num1/num2;
                    stack.push(stack.toString(Result));
                    break;

            }
        }
        Result = Double.parseDouble(stack.pop());
        System.out.println(Result);

        return Result;

    }
}


