package com.example.controller;


public class Stack {
    private String[] Stack;
    private  int P=-1;
    private  int Maxsize;

    //构造器
    public Stack(int Maxsize){
        this.Maxsize=Maxsize;
        Stack=new String[Maxsize];
    }

    //空栈
    public  boolean isEmpty(){
        return P==-1;
   }
    //栈满
    public boolean isFull(){
        return P==Maxsize-1;
    }
    //栈长
//   public int getSize(){return  this.Maxsize; }
    //出栈
   public String pop(){
       if (isEmpty()) {
         throw  new RuntimeException("栈空了不能出");
       }else
       {
          String string=Stack[P];
          P--;
          return string;
       }
   }
     //入栈
   public void push(String string){
        if(isFull()){
            System.out.println("栈满");
        }else {
            P++;
            Stack[P]=string;
        }


   }
     //转换
    public String toString(Double i)
    {
      return  Double.toString(i);
    }

}
