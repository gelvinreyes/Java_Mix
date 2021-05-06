package com.calculator.service.calculator;

public class Response {
    private double x;
    private double y;
    private double result;

    public Response(double x,double y,double result){
        this.x=x;
        this.y=y;
        this.result=result;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getResult() {
        return result;
    }
}
