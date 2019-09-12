package com.demo.controller;

import com.jfinal.core.Controller;

/**
 * @author Chen
 * @created 2019-09-12-21:23.
 */
public class IndexController extends Controller {
    public void index() {

        setAttr("msg","3.0index");
        renderTemplate("index.html");
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
