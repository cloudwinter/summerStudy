package com.summer.demo.ss.summerstudy.factory;

import com.summer.demo.ss.summerstudy.factory.simple.CreateNodeFactory;

/**
 * Created by xiayundong on 2018/5/16.
 */

public class TestFactory {

   public static void main(String[] args) {
       NodeA nodeA = (NodeA) CreateNodeFactory.createNodes(1);
       nodeA.print();
       NodeB nodeB = (NodeB) CreateNodeFactory.createaNodes(NodeB.class);
       nodeB.print();
   }
}
