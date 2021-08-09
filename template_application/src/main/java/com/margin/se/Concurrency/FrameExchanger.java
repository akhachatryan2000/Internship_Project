package com.margin.se.Concurrency;

public class FrameExchanger {
    private volatile long framesStoredCount = 0;
    private volatile long framesTakenCount = 0;

    private boolean hasNewFrame = false;

    private Frame frame = null;

    public void storeFrame(Frame frame) {
        this.framesStoredCount++;
        this.frame = frame;
        this.hasNewFrame = true;
    }

    public Frame takeFrame() {
        while (!hasNewFrame) {
            System.out.println("Waiting for the new frame");
        }
        Frame newFrame = this.frame;
        this.framesTakenCount++;
        this.hasNewFrame = false;
        return newFrame;

    }
}
