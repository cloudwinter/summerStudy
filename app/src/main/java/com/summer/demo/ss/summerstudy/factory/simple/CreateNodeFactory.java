package com.summer.demo.ss.summerstudy.factory.simple;

import com.summer.demo.ss.summerstudy.factory.INodes;
import com.summer.demo.ss.summerstudy.factory.NodeA;
import com.summer.demo.ss.summerstudy.factory.NodeB;
import com.summer.demo.ss.summerstudy.factory.NodeC;

/**
 * Created by xiayundong on 2018/5/16.
 */

public class CreateNodeFactory {

    public static INodes createNodes(int type) {
        switch (type) {
            case 1:
                return new NodeA();
            case 2:
                return new NodeB();
            case 3:
            default:
                return new NodeC();
        }
    }

    public static <T extends INodes> INodes createaNodes(Class<T> clz) {
        T result = null;
        try {
            result = (T) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {

        }
        return result;
    }
}
