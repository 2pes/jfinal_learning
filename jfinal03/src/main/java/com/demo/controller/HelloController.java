package com.demo.controller;

import com.jfinal.core.Controller;

public class HelloController extends Controller {
    public void index() {
        renderText("index JFinal World.");
    }

    public void hello() {
        renderText("Hello ");
    }

    public void bye() {
        renderText("bye JFinal World.");
    }
}
