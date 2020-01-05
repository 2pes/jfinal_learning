package com.demo.controller;

import com.jfinal.core.Controller;

public class PhotoController extends Controller {
    public void index() {
        renderText("Photo index");
    }

    public void view() {
        renderHtml("Photo view ");
    }

    public void upload() {
        renderText(" Photo upload");
    }
    public void download() {
        renderText(" Photo download");
    }
    public void delete() {
        renderText(" Photo delete");
    }
}
