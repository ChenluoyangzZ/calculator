package com.example.controller;

public class Stack1 {
        private  int  maxSize;//栈的大小
        private int[] stack;//数组
        private  int top=-1;
        //构造器
        public Stack1(int maxSize){
            this.maxSize=maxSize;
            stack=new int[this.maxSize];
        }
        //进栈
        public void push(int value){
            if (isFull()){
                System.out.println("栈满");
                return; }
            top++;
            stack[top]=value;
        }
        //出栈
        public  int pop(){
            if(isEmpty()){
                throw new RuntimeException("栈空了不能再出了");
            }
            int value=stack[top];
            top--;
            return value;
        }
        //栈空
        public boolean  isEmpty(){
            return top==-1;
        }
        //栈满
        public  boolean isFull(){
            return top==maxSize-1;
        }
        //判断是不是一个运算符

        public boolean isOper(char val){
            return val=='+'||val=='-'||val=='*'||val=='/';
        }


    }


