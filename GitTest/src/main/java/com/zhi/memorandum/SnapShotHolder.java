package com.zhi.memorandum;

import java.util.Stack;

public class SnapShotHolder {
    private Stack<SnapShot> stack = new Stack<>();

    public void push(SnapShot snapShot) {
        stack.push(snapShot);
    }

    public SnapShot pop() {
        return stack.pop();
    }
}
